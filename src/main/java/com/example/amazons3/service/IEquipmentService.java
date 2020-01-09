package com.example.amazons3.service;

import com.example.amazons3.Util.Response;
import com.example.amazons3.model.Equipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEquipmentService {

    Equipment insert(Equipment equipment);

    Equipment alter(Equipment equipment, Long id);

    Response deleteById(Long id);

    Equipment findById(Long id);

    Page<Equipment> findAll(Pageable pageable);
}
