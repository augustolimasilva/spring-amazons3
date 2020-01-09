package com.example.amazons3.controller;

import com.example.amazons3.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private IEquipmentService equipmentService;
}
