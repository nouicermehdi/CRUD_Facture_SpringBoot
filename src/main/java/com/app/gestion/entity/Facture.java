package com.app.gestion.entity;

import com.app.gestion.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitialiser", "handler"})
@Table(name = "Facture")
public class Facture extends BaseEntity {
    private String title;
    private String description;
    private Date dateEmission;
    private Date dateEcheance;
    private Double montantTotal;

}
