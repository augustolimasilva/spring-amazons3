package com.example.amazons3.service;

import com.example.amazons3.util.Response;
import com.example.amazons3.model.Equipment;
import com.example.amazons3.model.dto.EquipmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEquipmentService {

    Equipment insert(EquipmentDTO EquipmentDTO);

    Equipment alter(EquipmentDTO EquipmentDTO, Long id);

    Response deleteById(Long id);

    Equipment findById(Long id);

    Page<Equipment> findAll(Pageable pageable);
}
