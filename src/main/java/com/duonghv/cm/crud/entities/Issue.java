package com.duonghv.cm.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="issue")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ID")
  private Integer id;

  @Column(name="COMPUTER_ID")
  private String computerId;

  @Column(name="DESCRIPTION")
  private String description;

  @Column(name="ASSIGNEE")
  private String assignee;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="ISSUE_DATE")
  private Date issueDate;

}
