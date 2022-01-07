/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoadFreylegastoseminario.bd.crud;

import SoadFreylegastoseminario.bd.crud.exceptions.IllegalOrphanException;
import SoadFreylegastoseminario.bd.crud.exceptions.NonexistentEntityException;
import SoadFreylegastoseminario.bd.crud.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import SoadFreylegastoseminario.bd.tablas.Gasto;
import SoadFreylegastoseminario.bd.tablas.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author ODETH
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        if (usuario.getGastoList() == null) {
            usuario.setGastoList(new ArrayList<Gasto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Gasto> attachedGastoList = new ArrayList<Gasto>();
            for (Gasto gastoListGastoToAttach : usuario.getGastoList()) {
                gastoListGastoToAttach = em.getReference(gastoListGastoToAttach.getClass(), gastoListGastoToAttach.getId());
                attachedGastoList.add(gastoListGastoToAttach);
            }
            usuario.setGastoList(attachedGastoList);
            em.persist(usuario);
            for (Gasto gastoListGasto : usuario.getGastoList()) {
                Usuario oldUsuarioIdOfGastoListGasto = gastoListGasto.getUsuarioId();
                gastoListGasto.setUsuarioId(usuario);
                gastoListGasto = em.merge(gastoListGasto);
                if (oldUsuarioIdOfGastoListGasto != null) {
                    oldUsuarioIdOfGastoListGasto.getGastoList().remove(gastoListGasto);
                    oldUsuarioIdOfGastoListGasto = em.merge(oldUsuarioIdOfGastoListGasto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getCedula()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getCedula());
            List<Gasto> gastoListOld = persistentUsuario.getGastoList();
            List<Gasto> gastoListNew = usuario.getGastoList();
            List<String> illegalOrphanMessages = null;
            for (Gasto gastoListOldGasto : gastoListOld) {
                if (!gastoListNew.contains(gastoListOldGasto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Gasto " + gastoListOldGasto + " since its usuarioId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Gasto> attachedGastoListNew = new ArrayList<Gasto>();
            for (Gasto gastoListNewGastoToAttach : gastoListNew) {
                gastoListNewGastoToAttach = em.getReference(gastoListNewGastoToAttach.getClass(), gastoListNewGastoToAttach.getId());
                attachedGastoListNew.add(gastoListNewGastoToAttach);
            }
            gastoListNew = attachedGastoListNew;
            usuario.setGastoList(gastoListNew);
            usuario = em.merge(usuario);
            for (Gasto gastoListNewGasto : gastoListNew) {
                if (!gastoListOld.contains(gastoListNewGasto)) {
                    Usuario oldUsuarioIdOfGastoListNewGasto = gastoListNewGasto.getUsuarioId();
                    gastoListNewGasto.setUsuarioId(usuario);
                    gastoListNewGasto = em.merge(gastoListNewGasto);
                    if (oldUsuarioIdOfGastoListNewGasto != null && !oldUsuarioIdOfGastoListNewGasto.equals(usuario)) {
                        oldUsuarioIdOfGastoListNewGasto.getGastoList().remove(gastoListNewGasto);
                        oldUsuarioIdOfGastoListNewGasto = em.merge(oldUsuarioIdOfGastoListNewGasto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuario.getCedula();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getCedula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Gasto> gastoListOrphanCheck = usuario.getGastoList();
            for (Gasto gastoListOrphanCheckGasto : gastoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Gasto " + gastoListOrphanCheckGasto + " in its gastoList field has a non-nullable usuarioId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
