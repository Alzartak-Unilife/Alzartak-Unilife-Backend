package com.alzartak.unilife.domain.avg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Avg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avgId;

    @Column
    private String baseCode;

    @Column
    private String professor;

    @Column
    private Float avgEvaluation;
}
