package com.app.gestion.controller;

import com.app.gestion.dto.FactureDto;
import com.app.gestion.entity.Facture;
import com.app.gestion.services.FactureService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facture")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FactureController {
    private final FactureService factureService;

    @PostMapping
    public ResponseEntity<?> postFacture(@RequestBody FactureDto dto) {
        Facture createFacture = factureService.postFacture(dto);
        if (createFacture != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createFacture);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllFactures() {
        return ResponseEntity.ok(factureService.getAllFactures());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFactureById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(factureService.getFactureById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFacture(@PathVariable Long id ,@RequestBody FactureDto dto) {
        try {
            return ResponseEntity.ok(factureService.updateFacture(id,dto));
        }catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).body("Something went wrong");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFacture(@PathVariable Long id) {
        try {
            factureService.deleteFacture(id);
            return ResponseEntity.ok(null);
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).body("Something went wrong");
        }
    }
}
