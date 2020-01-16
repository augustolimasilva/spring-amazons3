package com.example.amazons3.controller;

import com.example.amazons3.model.Equipment;
import com.example.amazons3.model.dto.EquipmentDTO;
import com.example.amazons3.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private IEquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<Equipment> insert(@RequestBody @Valid EquipmentDTO equipmentDTO){
        return new ResponseEntity<>(equipmentService.insert(equipmentDTO), HttpStatus.CREATED);
    }
}
