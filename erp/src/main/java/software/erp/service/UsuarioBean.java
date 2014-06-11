package software.erp.service;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import software.erp.data.UsuarioDAO;
import software.erp.model.Usuario;



//@ManagedBean
public class UsuarioBean{
	//@EJB
  private UsuarioDAO usuarioDao;
  private String confirmaSenha;
  private Usuario usuario;
  private List lista;
  private Map parametros;
  private String destinoSalvar;

  public UsuarioBean()
  {
      usuario = new Usuario();
  }

  public UsuarioDAO getUsuarioDao()
  {
      return this.usuarioDao;
  }

  public void setUsuarioDao(UsuarioDAO usuarioDao)
  {
      this.usuarioDao = usuarioDao;
  }

  public String novo()
  {
      usuario.setAtivo(true);
      return "usuario";
  }

  public String editar()
  {
      confirmaSenha = usuario.getSenha();
      return "usuario";
  }

  public String salvar()
  {
      FacesContext context = FacesContext.getCurrentInstance();
      if(!usuario.getSenha().equalsIgnoreCase(confirmaSenha))
      {
          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha confirmada incorreta", ""));
          return null;
      } else
      {
          this.usuarioDao.salvar(usuario);
          return "mostraUsuario";
      }
  }

  public String excluir()
  {
      usuarioDao.excluir(Usuario.class, usuario.getId());
      lista = null;
      return null;
  }

  public String ativar()
  {
      if(usuario.isAtivo())
      {
          usuario.setAtivo(false);
      } else
      {
          usuario.setAtivo(true);
      }
      usuarioDao.atualizar(usuario);
      return null;
  }

  public List getLista()
  {
      if(lista == null)
      {
          lista = usuarioDao.getAll(Usuario.class);
      }
      return lista;
  }

  public Map getParametros()
  {
      return parametros;
  }

  public void setParametros(Map parametros)
  {
      this.parametros = parametros;
  }

  public String getConfirmaSenha()
  {
      return confirmaSenha;
  }

  public void setConfirmaSenha(String confirmaSenha)
  {
      this.confirmaSenha = confirmaSenha;
  }

  public Usuario getUsuario()
  {
      return usuario;
  }

  public void setUsuario(Usuario usuario)
  {
      this.usuario = usuario;
  }

  public String getDestinoSalvar()
  {
      return destinoSalvar;
  }

  public void setDestinoSalvar(String destinoSalvar)
  {
      this.destinoSalvar = destinoSalvar;
  }

  public void setLista(List lista)
  {
      this.lista = lista;
  }
}


