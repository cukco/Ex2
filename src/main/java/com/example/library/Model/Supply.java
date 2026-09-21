package com.example.library.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="supplies")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String manufacturer;

    @Column
    private String unit;

    @Column
    private Integer quantity;

    @Column
    private boolean isDeleted=false;

    public Supply() {}
    public Supply(String name, String manufacturer, String unit, Integer quantity,boolean isDeleted) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.unit = unit;
        this.quantity = quantity;
        this.isDeleted = isDeleted;
    }


}
