package com.example.claims;

import com.example.claims.io.CsvClaimReader;
import com.example.claims.io.ReportGenerator;
import com.example.claims.model.Claim;
import com.example.claims.service.ClaimService;
import com.example.claims.service.RiskScorer;
import java.nio.file.Path;
import java.util.List;

public class InsuranceClaimsApp {
    public static void main(String[] args) throws Exception {
        CsvClaimReader reader = new CsvClaimReader();
        RiskScorer riskScorer = new RiskScorer();
        ClaimService claimService = new ClaimService(riskScorer);
        ReportGenerator reportGenerator = new ReportGenerator();

        List<Claim> claims = reader.read(Path.of("data/claims_sample.csv"));
        claimService.assignRiskScores(claims);
        String report = reportGenerator.generateReport(claims);
        Path reportPath = Path.of("reports/claims_report.txt");
        reportGenerator.writeReport(reportPath, report);
        System.out.println(report);
    }
}
