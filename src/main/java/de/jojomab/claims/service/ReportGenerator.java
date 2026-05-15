package de.jojomab.claims.service;

import de.jojomab.claims.model.ClaimAssessment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReportGenerator {
    public String createReport(List<ClaimAssessment> assessments) {
        StringBuilder builder = new StringBuilder();
        long highRiskClaims = assessments.stream().filter(assessment -> assessment.getRiskScore() >= 8).count();
        long invalidClaims = assessments.stream().filter(assessment -> !assessment.isPlausible()).count();
        double totalAmount = assessments.stream().mapToDouble(assessment -> assessment.getClaim().getAmount()).sum();

        builder.append("Insurance Claims Report\n");
        builder.append("=======================\n\n");
        builder.append("Claims analyzed: ").append(assessments.size()).append("\n");
        builder.append("High-risk claims: ").append(highRiskClaims).append("\n");
        builder.append("Invalid claims: ").append(invalidClaims).append("\n");
        builder.append(String.format("Total amount: %.2f EUR%n%n", totalAmount));

        builder.append("Claim details\n");
        builder.append("-------------\n");
        for (ClaimAssessment assessment : assessments) {
            builder
                    .append(assessment.getClaim().getId())
                    .append(" | claimant=")
                    .append(assessment.getClaim().getClaimantName())
                    .append(" | type=")
                    .append(assessment.getClaim().getClaimType())
                    .append(" | amount=")
                    .append(String.format("%.2f", assessment.getClaim().getAmount()))
                    .append(" | risk=")
                    .append(assessment.getRiskScore())
                    .append(" | priority=")
                    .append(assessment.getPriority())
                    .append(" | plausible=")
                    .append(assessment.isPlausible())
                    .append("\n");
        }
        return builder.toString();
    }

    public void writeReport(Path path, String report) throws IOException {
        Files.createDirectories(path.getParent());
        Files.writeString(path, report);
    }
}
