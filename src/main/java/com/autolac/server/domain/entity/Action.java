package com.autolac.server.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by lacau on 11/12/17.
 */
@Entity
public class Action implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "fk_period")
  private Period period;

  @Column(name = "name")
  private String name;

  @Column(name = "type")
  private ActionType type;

  @Column(name = "interval")
  private Integer interval;

  @Column(name = "variance")
  private Integer variance;

  @Column(name = "active", columnDefinition = "TINYINT(1)")
  private boolean active;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Period getPeriod() {
    return period;
  }

  public void setPeriod(Period period) {
    this.period = period;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ActionType getType() {
    return type;
  }

  public void setType(ActionType type) {
    this.type = type;
  }

  public Integer getInterval() {
    return interval;
  }

  public void setInterval(Integer interval) {
    this.interval = interval;
  }

  public Integer getVariance() {
    return variance;
  }

  public void setVariance(Integer variance) {
    this.variance = variance;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Action action = (Action) o;

    if (active != action.active)
      return false;
    if (id != null ? !id.equals(action.id) : action.id != null)
      return false;
    if (period != null ? !period.equals(action.period) : action.period != null)
      return false;
    if (name != null ? !name.equals(action.name) : action.name != null)
      return false;
    if (type != action.type)
      return false;
    if (interval != null ? !interval.equals(action.interval) : action.interval != null)
      return false;
    return variance != null ? variance.equals(action.variance) : action.variance == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (period != null ? period.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (interval != null ? interval.hashCode() : 0);
    result = 31 * result + (variance != null ? variance.hashCode() : 0);
    result = 31 * result + (active ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Action{" +
        "id=" + id +
        ", period=" + period +
        ", name='" + name + '\'' +
        ", type=" + type +
        ", interval=" + interval +
        ", variance=" + variance +
        ", active=" + active +
        '}';
  }
}
