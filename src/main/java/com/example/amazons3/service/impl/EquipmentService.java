package com.example.amazons3.service.impl;

import com.example.amazons3.Util.Response;
import com.example.amazons3.model.Equipment;
import com.example.amazons3.service.IEquipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EquipmentService implements IEquipmentService {
    @Override
    public Equipment insert(Equipment equipment) {
        return null;
    }

    @Override
    public Equipment alter(Equipment equipment, Long id) {
        return null;
    }

    @Override
    public Response deleteById(Long id) {
        return null;
    }

    @Override
    public Equipment findById(Long id) {
        return null;
    }

    @Override
    public Page<Equipment> findAll(Pageable pageable) {
        return null;
    }
}
