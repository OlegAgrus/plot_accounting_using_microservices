package com.github.olegagrus.plot_accounting.plot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "plot")
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adr", nullable = false)
    private String adr;

    @Column(name = "price_per_hectare", nullable = false)
    private double pricePerHectare;

    @Column(name = "hectares", nullable = false)
    private double hectares;

    @Column(name = "is_sold", nullable = false)
    private boolean isSold;

}
