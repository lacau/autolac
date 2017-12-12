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
public class Hashtag implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "count")
  private Integer count;

  @Column(name = "last_update", columnDefinition = "DATETIME")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Hashtag hashtag = (Hashtag) o;

    if (id != null ? !id.equals(hashtag.id) : hashtag.id != null)
      return false;
    if (name != null ? !name.equals(hashtag.name) : hashtag.name != null)
      return false;
    if (count != null ? !count.equals(hashtag.count) : hashtag.count != null)
      return false;
    return lastUpdate != null ? lastUpdate.equals(hashtag.lastUpdate) : hashtag.lastUpdate == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (count != null ? count.hashCode() : 0);
    result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Hashtag{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", count=" + count +
        ", lastUpdate=" + lastUpdate +
        '}';
  }
}
