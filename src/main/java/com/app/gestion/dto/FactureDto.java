package com.app.gestion.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class FactureDto {
    private Long id;
    private String title;
    private String description;
    private Date dateEmission ;
    private Date dateEcheance ;
    private Double montantTotal ;
    private LocalDateTime createdAt;


}
