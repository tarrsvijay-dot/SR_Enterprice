package com.srenterprises.entity;
import jakarta.persistence.*; import java.time.*; import java.util.*;
@Entity @Table(name="categories") public class Category { @Id public UUID id=UUID.randomUUID(); @Column(nullable=false,unique=true) public String name; @Column(nullable=false,unique=true) public String slug; public String description; public boolean active=true; @Column(name="created_at") public Instant createdAt=Instant.now(); @Column(name="updated_at") public Instant updatedAt=Instant.now(); }
