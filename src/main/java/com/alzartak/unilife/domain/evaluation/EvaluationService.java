package com.alzartak.unilife.domain.evaluation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;

    public List<EvaluationResponse> searchEvaluation(EvaluationRequest evaluationRequest) {
        List<Evaluation> evaluations = evaluationRepository.findByBaseCodeAndProfessor(evaluationRequest.getBaseCode(), evaluationRequest.getProfessor());

        return evaluations.stream()
                .map(evaluation -> {
                    EvaluationResponse response = new EvaluationResponse();
                    response.setYear(evaluation.getYear());
                    response.setSemester(evaluation.getSemester());
                    response.setScore(evaluation.getScore());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
