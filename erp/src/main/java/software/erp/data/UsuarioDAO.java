package software.erp.data;

import software.erp.model.Usuario;

public interface UsuarioDAO extends DAO<Usuario, Integer>
{
    public abstract Usuario buscarPorLogin(String s);

}

