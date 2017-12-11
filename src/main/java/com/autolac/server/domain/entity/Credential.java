package com.autolac.server.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lacau on 11/12/17.
 */
@Entity
public class Credential implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "login")
  private String login;

  @Column(name = "password")
  private String password;

  @Column(name = "token")
  private String token;

  @Column(name = "token_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date tokenDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getTokenDate() {
    return tokenDate;
  }

  public void setTokenDate(Date tokenDate) {
    this.tokenDate = tokenDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Credential that = (Credential) o;

    if (id != null ? !id.equals(that.id) : that.id != null)
      return false;
    if (login != null ? !login.equals(that.login) : that.login != null)
      return false;
    if (password != null ? !password.equals(that.password) : that.password != null)
      return false;
    if (token != null ? !token.equals(that.token) : that.token != null)
      return false;
    return tokenDate != null ? tokenDate.equals(that.tokenDate) : that.tokenDate == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (login != null ? login.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (token != null ? token.hashCode() : 0);
    result = 31 * result + (tokenDate != null ? tokenDate.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Credential{" +
        "id=" + id +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", token='" + token + '\'' +
        ", tokenDate=" + tokenDate +
        '}';
  }
}