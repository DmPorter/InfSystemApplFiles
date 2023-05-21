package com.example.infsystemapplfiles.repositories;

import com.example.infsystemapplfiles.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.date >=  ?1 and o.date <= ?2")
    List<Order> findByDateBetween(Timestamp date, Timestamp date2);

}
