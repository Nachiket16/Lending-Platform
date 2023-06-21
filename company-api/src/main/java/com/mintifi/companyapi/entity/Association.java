package com.mintifi.companyapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "association")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Association {
  //Buyer and Supplier relations with the company
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

}
