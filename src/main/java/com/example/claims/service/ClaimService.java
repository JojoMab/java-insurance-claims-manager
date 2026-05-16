package com.example.claims.service;

import com.example.claims.io.CsvClaimReader;
import com.example.claims.model.Claim;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class ClaimService {
    private final RiskScorer riskScorer;

    public ClaimService(RiskScorer riskScorer) {
        this.riskScorer = riskScorer;
    }

    public List<Claim> loadClaims(Path path) throws IOException {
        return new CsvClaimReader().read(path);
    }

    public List<Claim> filterByStatus(List<Claim> claims, Claim.ClaimStatus status) {
        return claims.stream().filter(claim -> claim.getStatus() == status).toList();
    }

    public double calculateTotalAmount(List<Claim> claims) {
        return claims.stream().mapToDouble(Claim::getAmount).sum();
    }

    public List<Claim> getHighRiskClaims(List<Claim> claims) {
        assignRiskScores(claims);
        return claims.stream()
            .filter(claim -> claim.getRiskScore() >= 7)
            .sorted(Comparator.comparingInt(Claim::getRiskScore).reversed())
            .toList();
    }

    public void assignRiskScores(List<Claim> claims) {
        claims.forEach(claim -> claim.setRiskScore(riskScorer.calculateRiskScore(claim)));
    }
}
