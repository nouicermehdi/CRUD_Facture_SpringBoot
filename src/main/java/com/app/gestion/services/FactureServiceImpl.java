package com.app.gestion.services;

import com.app.gestion.dto.FactureDto;
import com.app.gestion.entity.Facture;
import com.app.gestion.repository.FactureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {
    private final FactureRepository factureRepository;

    public Facture postFacture(FactureDto factureDto) {
        return saveOrUpdateFacture(new Facture(), factureDto);
    }


    private Facture saveOrUpdateFacture(Facture facture, FactureDto factureDto) {
        facture.setId(factureDto.getId());
        facture.setDescription(factureDto.getDescription());
        facture.setTitle(factureDto.getTitle());
        facture.setDateEmission(factureDto.getDateEmission());
        facture.setDateEcheance(factureDto.getDateEcheance());
        facture.setMontantTotal(factureDto.getMontantTotal());
        facture.setCreatedAt(factureDto.getCreatedAt());
        return factureRepository.save(facture);

    }



    public List<Facture> getAllFactures() {
        return factureRepository.findAll().stream()
                .sorted(Comparator.comparing(Facture::getId).reversed())
                .collect(Collectors.toList())
                ;
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Facture with ID " + id + " not found"));
    }


    public Facture updateFacture(Long id, FactureDto factureDto) {

        Optional<Facture> optionalfacture = factureRepository.findById(id);
        if (optionalfacture.isPresent()) {
            return saveOrUpdateFacture(optionalfacture.get(), factureDto);

        } else {
            throw new EntityNotFoundException("Facture not found with id " + id);
        }
    }

    @Override
    public void deleteFacture(Long id) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        if (optionalFacture.isPresent()) {
            factureRepository.delete(optionalFacture.get());
        }else {
            throw new EntityNotFoundException("Facture not found with id " + id);
        }

    }
}
