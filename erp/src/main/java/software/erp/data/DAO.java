package software.erp.data;


import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

public interface DAO<T, I extends Serializable> {

	public abstract T salvar(T obj);

    public abstract void atualizar(Object obj);

    public abstract T carregar(Class<T> class1, I pk);

    public abstract T getById(Class<T> class1, I pk);

    public abstract List<T> getAll(Class<T> class1);

    public abstract EntityManager getEntityManager();

    public abstract void excluir(Class<T> class1, Long long1);
}
