package com.alzartak.unilife.domain.avg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AvgRepository extends JpaRepository<Avg, Long> {
    @Query(value = "SELECT AVG(avg_evaluation) FROM avg WHERE base_code = :baseCode AND professor = :professor", nativeQuery = true)
    Float findAvgEvaluationByBaseCodeAndProfessor(@Param("baseCode") String baseCode, @Param("professor") String professor);
}
