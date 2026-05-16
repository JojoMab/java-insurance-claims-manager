package com.example.claims.io;

import com.example.claims.model.Claim;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReportGenerator {
    public String generateReport(List<Claim> claims) {
        double totalAmount = claims.stream().mapToDouble(Claim::getAmount).sum();
        long highRisk = claims.stream().filter(claim -> claim.getRiskScore() >= 7).count();
        StringBuilder builder = new StringBuilder();
        builder.append("Insurance Claims Report
");
        builder.append("=======================

");
        builder.append("Anzahl Schadensfälle: ").append(claims.size()).append("
");
        builder.append("Gesamtsumme: ").append(String.format("%.2f", totalAmount)).append(" EUR
");
        builder.append("Hochrisiko-Fälle: ").append(highRisk).append("

");
        for (Claim claim : claims) {
            builder.append(claim.getId()).append(" | ")
                .append(claim.getClaimantName()).append(" | ")
                .append(claim.getClaimType()).append(" | ")
                .append(claim.getAmount()).append(" EUR | Risiko ")
                .append(claim.getRiskScore()).append("
");
        }
        return builder.toString();
    }

    public void writeReport(Path path, String report) throws IOException {
        Files.createDirectories(path.getParent());
        Files.writeString(path, report);
    }
}
