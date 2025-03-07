package com.app.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permisions")
public class PermisionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String name;
}
