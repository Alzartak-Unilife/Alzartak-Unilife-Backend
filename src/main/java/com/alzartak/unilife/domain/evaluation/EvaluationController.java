package com.alzartak.unilife.domain.evaluation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EvaluationController {
    private final EvaluationService evaluationService;

    @PostMapping("/evaluate")
    public List<EvaluationResponse> searchEvaluation(@RequestBody EvaluationRequest evaluationRequest) {
        return evaluationService.searchEvaluation(evaluationRequest);
    }
}
