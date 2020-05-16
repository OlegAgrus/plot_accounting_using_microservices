package com.github.olegagrus.plot_accounting.plot_selling.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "plot_selling")
public class PlotSelling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_surname", nullable = false)
    private String customerSurname;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transaction_time", nullable = true)
    private Date transactionTime;

    @Column(name = "plot_id", nullable = false, unique = true)
    private Long plotId;

}
