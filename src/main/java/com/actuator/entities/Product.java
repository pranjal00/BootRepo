package com.actuator.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Component
public class Product implements Serializable {
    @Id
    @Column(name = "product_no", nullable = false)
    private Long productNo;
    @Column(name = "product_name")
    private String productName;
    private String description;
    @Column(name = "warranty_months")
    private int warrantyMonths;
    private double price;
}
