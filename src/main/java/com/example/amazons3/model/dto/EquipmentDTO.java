package com.example.amazons3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {


    @NotNull(message = "{validation.typeEquipment.notnull}")
    @Length(min = 1, max = 20, message = "{validation.typequipment.length}")
    private String typeEquipment;

    @NotNull(message = "{validation.model.notnull}")
    @Length(min = 1, max = 100, message = "{validation.model.length}")
    private String model;

    private int mounth;

    private int year;

    @NotNull(message = "{validation.photo.notnull}")
    private MultipartFile photo;
}
