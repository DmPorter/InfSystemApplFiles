package com.example.infsystemapplfiles.services;


import com.example.infsystemapplfiles.models.Additive;
import com.example.infsystemapplfiles.repositories.AdditiveRepository;
import com.example.infsystemapplfiles.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditiveService {

    private final AdditiveRepository additiveRepository;

    private final RecipeRepository recipeRepository;

    @Autowired
    public AdditiveService(AdditiveRepository additiveRepository, RecipeRepository recipeRepository) {
        this.additiveRepository = additiveRepository;
        this.recipeRepository = recipeRepository;
    }


    public List<Additive> getAdditivesByRecipe(long id) {
        return additiveRepository.findAdditivesByTypeRecipe(recipeRepository.findById(id).get().getTypeRecipe());
    }
}
