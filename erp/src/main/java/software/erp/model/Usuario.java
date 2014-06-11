package software.erp.model;

import java.io.Serializable;
import java.util.Date;

//@Entity
public class Usuario
implements Serializable
{

private static final long serialVersionUID = 1L;
//@Id
//@GeneratedValue
private Long id;
private String nome;
private String email;
private String login;
private String senha;
private Date nascimento;
private String celular;
private String idioma;
private boolean ativo;

public Usuario()
{
}

public Long getId()
{
  return id;
}

public void setId(Long id)
{
  this.id = id;
}

public String getNome()
{
  return nome;
}

public void setNome(String nome)
{
  this.nome = nome;
}

public String getEmail()
{
  return email;
}

public void setEmail(String email)
{
  this.email = email;
}

public String getLogin()
{
  return login;
}

public void setLogin(String login)
{
  this.login = login;
}

public String getSenha()
{
  return senha;
}

public void setSenha(String senha)
{
  this.senha = senha;
}

public Date getNascimento()
{
  return nascimento;
}

public void setNascimento(Date nascimento)
{
  this.nascimento = nascimento;
}

public String getCelular()
{
  return celular;
}

public void setCelular(String celular)
{
  this.celular = celular;
}

public String getIdioma()
{
  return idioma;
}

public void setIdioma(String idioma)
{
  this.idioma = idioma;
}

public boolean isAtivo()
{
  return ativo;
}

public void setAtivo(boolean ativo)
{
  this.ativo = ativo;
}

public static long getSerialversionuid()
{
  return 1L;
}
}


