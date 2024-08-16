package com.ronaldo.data.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "area")
    private String area;

    @Column


