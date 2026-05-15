package de.jojomab.claims;

import de.jojomab.claims.model.Claim;
import de.jojomab.claims.service.ClaimService;
import de.jojomab.claims.service.ReportGenerator;
import de.jojomab.claims.service.RiskScorer;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ClaimService service = new ClaimService(new RiskScorer());
        ReportGenerator reportGenerator = new ReportGenerator();

        List<Claim> claims = service.loadClaims(Path.of("data/claims.csv"));
        String report = reportGenerator.createReport(service.analyze(claims));
        Path reportPath = Path.of("reports/claims_report.txt");
        reportGenerator.writeReport(reportPath, report);

        System.out.println("Claims report generated: " + reportPath);
        System.out.println("Claims analyzed: " + claims.size());
        System.out.println("High-risk claims: " + service.getHighRiskClaims(claims).size());
    }
}
