package com.example.amazons3.repository;

import com.example.amazons3.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquipmentRepository extends JpaRepository<Equipment, Long> {
}
