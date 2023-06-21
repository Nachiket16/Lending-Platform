package com.mintifi.companyapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "association_code")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssociationCode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long associationId;
  private String buyer_identifier;


}
