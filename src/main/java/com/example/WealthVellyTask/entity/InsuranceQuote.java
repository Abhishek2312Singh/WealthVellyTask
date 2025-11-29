package com.example.WealthVellyTask.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class InsuranceQuote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer clientAge;

    @Column(nullable = false)
    private Double coverageAmount;

    @Column(nullable = false)
    private Double basePremium;

    private Double finalPremium;
}
