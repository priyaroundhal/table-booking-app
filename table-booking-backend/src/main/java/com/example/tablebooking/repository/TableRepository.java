package com.example.tablebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tablebooking.dto.RestaurantTable;



@Repository
public interface TableRepository extends JpaRepository<RestaurantTable, Long>{

}
