package com.duonghv.cm.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ID")
  private Integer id;

  @Column(name="GROUP")
  private String group;

  @Column(name="GROUP_ID")
  private String groupId;

  @Column(name="AGENT")
  private String agent;

  @Column(name="COMPUTER_NAME")
  private String computerName;

  @Column(name="DOMAIN")
  private String domain;

  @Column(name="IP_LAN")
  private String iplan;

  @Column(name="MAC_ADDRESS")
  private String macAddress;

  @Column(name="IPINTRANET")
  private String ipIntranet;

  @Column(name="STATUS")
  private String status;

  @Column(name="CERT")
  private String cert;

  @Column(name="UPDATE")
  private String update;

  @Column(name="SERVICES_RUNNING")
  private String servicesRunning;

  @Column(name="CLIENT_ID")
  private String clientId;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="LAST_PING")
  private Date lastPing;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="FIRST_PING")
  private Date firstPing;

  @Column(name="IP_DCN")
  private String ipdcn;

  @Column(name="HR")
  private String hr;

  @Column(name="CPU")
  private String cpu;

  @Column(name="RAM")
  private Integer ram;

  @Column(name="OS")
  private String os;

  @Column(name="OS_VERSION")
  private String osVersion;

  @Column(name="OFFICE_VERSION")
  private String officeVersion;

  @Column(name="PLATFORM")
  private String platform;

}
