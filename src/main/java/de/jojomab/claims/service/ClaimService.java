package de.jojomab.claims.service;

import de.jojomab.claims.io.CsvClaimReader;
import de.jojomab.claims.model.Claim;
import de.jojomab.claims.model.ClaimAssessment;
import de.jojomab.claims.model.ClaimStatus;
import de.jojomab.claims.util.ClaimValidator;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ClaimService {
    private final RiskScorer riskScorer;
    private final ClaimValidator claimValidator;

    public ClaimService(RiskScorer riskScorer) {
        this(riskScorer, new ClaimValidator());
    }

    public ClaimService(RiskScorer riskScorer, ClaimValidator claimValidator) {
        this.riskScorer = riskScorer;
        this.claimValidator = claimValidator;
    }

    public List<Claim> loadClaims(Path path) throws IOException {
        CsvClaimReader reader = new CsvClaimReader();
        return reader.read(path);
    }

    public List<Claim> filterByStatus(List<Claim> claims, ClaimStatus status) {
        return claims.stream()
                .filter(claim -> claim.getStatus() == status)
                .toList();
    }

    public double calculateTotalAmount(List<Claim> claims) {
        return claims.stream()
                .mapToDouble(Claim::getAmount)
                .sum();
    }

    public List<ClaimAssessment> getHighRiskClaims(List<Claim> claims) {
        return analyze(claims).stream()
                .filter(assessment -> assessment.getRiskScore() >= 8)
                .toList();
    }

    public List<ClaimAssessment> analyze(List<Claim> claims) {
        return claims.stream()
                .map(claim -> new ClaimAssessment(
                        claim,
                        riskScorer.score(claim),
                        riskScorer.priority(claim),
                        claimValidator.isValid(claim)
                ))
                .toList();
    }
}
