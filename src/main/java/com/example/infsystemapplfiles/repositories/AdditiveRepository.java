package com.example.infsystemapplfiles.repositories;

import com.example.infsystemapplfiles.models.Additive;
import com.example.infsystemapplfiles.models.TypeRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdditiveRepository extends JpaRepository<Additive, Long> {

    List<Additive> findAdditivesByTypeRecipe(TypeRecipe typeRecipe);

}
