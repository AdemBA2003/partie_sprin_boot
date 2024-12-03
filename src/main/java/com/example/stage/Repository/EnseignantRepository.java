package com.example.stage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.stage.models.Enseignant;

@Repository 
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
    void deleteById(Integer id);
}
