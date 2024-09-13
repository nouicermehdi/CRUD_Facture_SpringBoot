package com.app.gestion.services;

import com.app.gestion.dto.FactureDto;
import com.app.gestion.entity.Facture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FactureService {
    public Facture postFacture(FactureDto factureDto);

    public List<Facture> getAllFactures();

    public Facture getFactureById(Long id);

    public Facture updateFacture(Long id, FactureDto factureDto);

    public void deleteFacture(Long id);
}
