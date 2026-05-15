package de.jojomab.claims.service;

import de.jojomab.claims.model.ClaimAssessment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReportGenerator {
    public String createReport(List<ClaimAssessment> assessments) {
        StringBuilder builder = new StringBuilder();
        builder.append("Insurance Claims Report\n");
        builder.append("=======================\n\n");
        builder.append("Claims analyzed: ").append(assessments.size()).append("\n\n");
        for (ClaimAssessment assessment : assessments) {
            builder
                .append(assessment.getClaim().getId())
                .append(": risk=")
                .append(assessment.getRiskScore())
                .append(" priority=")
                .append(assessment.getPriority())
                .append(" plausible=")
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
