package software.erp.data;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public abstract class DAOImplementacao<T, I extends Serializable> implements DAO<T, I>{

	 @PersistenceContext 
    private EntityManager manager;

    public DAOImplementacao()
    {
    }

    public T salvar(T entity)
    {
        T saved = null;
        saved = getEntityManager().merge(entity);
        return saved;
    }

    public void atualizar(Object entity)
    {
        getEntityManager().merge(entity);
    }

    public void excluir(Class<T> classe, Long pk)
    {
      T entityRem = getEntityManager().find(classe, pk);
      getEntityManager().remove(entityRem);
    }

    public T carregar(Class<T> classe, I pk)  {
    	
    	try {
    		return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}
       
    }

    public Object getById(Class<T> classe, Long pk)
    {
    	try {
    		return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;// TODO: handle exception
		}
        
    }
    

    public List<T> getAll(Class<T> classe)
    {
        return getEntityManager().createQuery((new StringBuilder()).append("select o from ").append(classe.getSimpleName()).append(" o order  by nome").toString()).getResultList();
    }

    public EntityManager getEntityManager()
    {
        return manager;
    }
}
