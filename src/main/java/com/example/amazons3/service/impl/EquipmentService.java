package com.example.amazons3.service.impl;

import com.example.amazons3.Util.Constants;
import com.example.amazons3.Util.Response;
import com.example.amazons3.exception.CustomException;
import com.example.amazons3.model.Equipment;
import com.example.amazons3.model.dto.EquipmentDTO;
import com.example.amazons3.repository.IEquipmentRepository;
import com.example.amazons3.service.IEquipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class EquipmentService implements IEquipmentService {

    @Autowired
    IEquipmentRepository equipmentRepository;

    @Override
    public Equipment insert(EquipmentDTO equipmentDTO) {
        Equipment equipment = new ModelMapper().map(equipmentDTO, Equipment.class);
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment alter(EquipmentDTO equipmentDTO, Long id) {
        if(Objects.isNull(id)) {
            throw new CustomException(Constants.ID_REQUIRED);
        }

        Optional<Equipment> equipment1 = equipmentRepository.findById(id);

        if(equipment1.isPresent()){
            Equipment equipment = new ModelMapper().map(equipmentDTO, Equipment.class);
            equipment.setId(id);
            return equipmentRepository.save(equipment);
        }else{
            throw new CustomException(Constants.EQUIPMENT_NOT_FOUND);
        }
    }

    @Override
    public Response deleteById(Long id) {
        if(Objects.isNull(id)){
            throw new CustomException(Constants.ID_REQUIRED);
        }

        Optional<Equipment> equipment = equipmentRepository.findById(id);

        if(equipment.isPresent()){
            equipmentRepository.deleteById(id);
            return new Response(Constants.SUCESS, Constants.DELETED_SUCCESSFUL);
        }else{
            throw new CustomException(Constants.EQUIPMENT_NOT_FOUND);
        }
    }

    @Override
    public Equipment findById(Long id) {
        Optional<Equipment> equipment = equipmentRepository.findById(id);

        if(equipment.isPresent()){
            return equipment.get();
        }else{
            throw new CustomException(Constants.EQUIPMENT_NOT_FOUND);
        }
    }

    @Override
    public Page<Equipment> findAll(Pageable pageable) {
        return equipmentRepository.findAll(pageable);
    }
}
