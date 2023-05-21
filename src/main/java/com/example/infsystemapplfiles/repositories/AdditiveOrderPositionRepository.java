package com.example.infsystemapplfiles.repositories;

import com.example.infsystemapplfiles.models.AdditiveOrderPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditiveOrderPositionRepository extends JpaRepository<AdditiveOrderPosition, Long> {

}
