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
public class Period implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "begin", columnDefinition = "DATETIME")
  @Temporal(TemporalType.TIMESTAMP)
  private Date begin;

  @Column(name = "end", columnDefinition = "DATETIME")
  @Temporal(TemporalType.TIMESTAMP)

  private Date end;

  @Column(name = "full_time", columnDefinition = "TINYINT(1)")
  private boolean fullTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getBegin() {
    return begin;
  }

  public void setBegin(Date begin) {
    this.begin = begin;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public boolean isFullTime() {
    return fullTime;
  }

  public void setFullTime(boolean fullTime) {
    this.fullTime = fullTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Period period = (Period) o;

    if (fullTime != period.fullTime)
      return false;
    if (id != null ? !id.equals(period.id) : period.id != null)
      return false;
    if (begin != null ? !begin.equals(period.begin) : period.begin != null)
      return false;
    return end != null ? end.equals(period.end) : period.end == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (begin != null ? begin.hashCode() : 0);
    result = 31 * result + (end != null ? end.hashCode() : 0);
    result = 31 * result + (fullTime ? 1 : 0);
    return result;
  }

  @Override public String toString() {
    return "Period{" +
        "id=" + id +
        ", begin=" + begin +
        ", end=" + end +
        ", fullTime=" + fullTime +
        '}';
  }
}
