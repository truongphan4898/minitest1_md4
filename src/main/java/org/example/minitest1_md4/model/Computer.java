package org.example.minitest1_md4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String computerCode;
    private String computerName;
    private String producer;
    @ManyToOne
    @JoinColumn(name = "typeComputerId")
    private TypeComputer typeComputer;
}
