package com.srenterprises.entity; import jakarta.persistence.*; import java.util.*;
@Entity @Table(name="inventory") public class Inventory { @Id public UUID id=UUID.randomUUID(); @OneToOne @JoinColumn(name="product_id") public Product product; public int quantity; @Column(name="low_stock_threshold") public int lowStockThreshold=5; }
