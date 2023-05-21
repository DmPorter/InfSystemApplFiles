package com.example.infsystemapplfiles.repositories;

import com.example.infsystemapplfiles.models.OrderPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPositionRepository extends JpaRepository<OrderPosition, Long> {

}
