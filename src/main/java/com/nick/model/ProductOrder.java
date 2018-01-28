package com.nick.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDERS")
public class ProductOrder {
    @Id
    @GeneratedValue(generator = "ORDER_GEN")
    @SequenceGenerator(name = "ORDER_GEN", sequenceName = "ORDER_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "ORDER_DETAILS")
    private String details;
    @ManyToOne
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    public ProductOrder() {
    }
}
