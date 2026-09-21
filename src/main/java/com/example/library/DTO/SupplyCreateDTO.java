package com.example.library.DTO;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupplyCreateDTO {
    @NotBlank(message = "Tên vật tư không được để trống")
    private String name;

    private String manufacturer;

    private String unit;

    private Integer quantity;

    public SupplyCreateDTO(){}
    public SupplyCreateDTO(String name, String manufacturer, String unit, Integer quantity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.quantity = quantity;
    }

}
