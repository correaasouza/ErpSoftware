package software.erp.data;



import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

	public abstract class DAOImplementacao<T, I extends Serializable> implements DAO<T, I>{

    private EntityManager manager;

    public DAOImplementacao()
    {
    }

    public T salvar(Object entity)
    {
        T saved = null;
        saved = getEntityManager().merge(entity);
        return saved;
    }

    public void atualizar(Object entity)
    {
        getEntityManager().merge(entity);
    }

    public void excluir(T classe, Long pk)
    {
     //   T entityRem = getEntityManager().find(classe, pk);
 //       getEntityManager().remove(entityRem);
    }

//    public carregar(T classe, Long pk)  {
//    	try {
//    		//return getEntityManager().find(classe, pk);
//		} catch (NoResultException e) {
//			return null;
//		}
//       
//    }

    public Object getById(Class<T> classe, Long pk)
    {
    	try {
    		return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;// TODO: handle exception
		}
        
    }

    public List getAll(Class classe)
    {
        return getEntityManager().createQuery((new StringBuilder()).append("select o from ").append(classe.getSimpleName()).append(" o order  by nome").toString()).getResultList();
    }

    public EntityManager getEntityManager()
    {
        return manager;
    }
}
