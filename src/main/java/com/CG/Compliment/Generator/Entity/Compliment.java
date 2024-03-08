package com.CG.Compliment.Generator.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compliment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String category;

//    @Data: Generates getter, setter, toString, hashCode, and equals methods.
//    @NoArgsConstructor: Generates a no-argument constructor.
//    @AllArgsConstructor: Generates a constructor with all fields.
}
