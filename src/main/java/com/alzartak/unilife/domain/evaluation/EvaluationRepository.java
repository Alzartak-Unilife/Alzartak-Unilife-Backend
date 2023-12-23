package com.alzartak.unilife.domain.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByBaseCodeAndProfessor(String baseCode, String Professor);
}
