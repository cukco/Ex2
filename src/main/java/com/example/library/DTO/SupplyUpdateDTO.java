package com.example.library.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupplyUpdateDTO {
    @NotBlank(message = "Tên vật tư không được để trống")
    private String name;

    private String manufacturer;

    private String unit;

    private Integer quantity;

    private Long id;
    public SupplyUpdateDTO(){}
    public SupplyUpdateDTO(String name, String manufacturer, String unit) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
    }

    public SupplyUpdateDTO(String name, String manufacturer, String unit, Integer quantity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.quantity = quantity;
    }

    public SupplyUpdateDTO(String name, String manufacturer, String unit, Long id) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.id = id;
    }

    public SupplyUpdateDTO(String name, String manufacturer, String unit, Integer quantity, Long id) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.quantity = quantity;
        this.id = id;
    }




}
