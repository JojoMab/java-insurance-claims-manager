# Java Insurance Claims Manager

![Java CI](https://github.com/JojoMab/java-insurance-claims-manager/actions/workflows/java-ci.yml/badge.svg)

Java Insurance Claims Manager ist ein Java/OOP-Bewerberprojekt für einen vereinfachten Versicherungsprozess. Die Anwendung lädt synthetische Schadensfälle aus einer CSV-Datei, prüft Plausibilität, berechnet Risiko und Priorität und erzeugt einen strukturierten Textreport.

## Bewerbungskontext

Das Projekt passt zu dualen Studiengängen in Informatik und Wirtschaftsinformatik mit Bezug zu Finanz- und Versicherungs-IT. Besonders geeignet ist es für Bewerbungen bei Allianz, Generali, Atruvia, Finanz Informatik, Bayerische Versorgungskammer, BG-Phoenics und ConSol.

## Tech Stack

- Java 21
- Maven
- JUnit 5
- CSV-Verarbeitung
- objektorientierte Modellierung
- Service- und Reportstruktur
- GitHub Actions CI

## Funktionen

- Versicherungsfälle aus CSV laden
- Schadensfälle als Java-Objekte modellieren
- ClaimType und ClaimStatus über Enums abbilden
- Risiko-Score von 1 bis 10 berechnen
- Priorität als low, medium oder high bestimmen
- Plausibilitätsprüfung durchführen
- Fälle nach Status filtern
- Gesamtschadenssumme berechnen
- High-Risk-Fälle erkennen
- Report als TXT erzeugen
- JUnit-Tests für Risiko-, Service- und Validierungslogik

## Projektstruktur

```text
java-insurance-claims-manager/
├── README.md
├── pom.xml
├── data/
│   └── claims.csv
├── docs/
│   ├── application_fit.md
│   └── recruiter_summary_de.md
├── examples/
│   └── terminal_output.txt
├── src/main/java/de/jojomab/claims/
│   ├── Main.java
│   ├── io/
│   │   └── CsvClaimReader.java
│   ├── model/
│   │   ├── Claim.java
│   │   ├── ClaimAssessment.java
│   │   ├── ClaimStatus.java
│   │   └── ClaimType.java
│   ├── service/
│   │   ├── ClaimService.java
│   │   ├── ReportGenerator.java
│   │   └── RiskScorer.java
│   └── util/
│       └── ClaimValidator.java
└── src/test/java/de/jojomab/claims/
    ├── ClaimServiceTest.java
    ├── ClaimValidatorTest.java
    └── RiskScorerTest.java
```

## Schnellstart

```bash
mvn test
mvn exec:java -Dexec.mainClass=de.jojomab.claims.Main
```

## Tests

```bash
mvn test
```

Die Tests prüfen die Risiko-Logik, zentrale Service-Methoden und die Plausibilitätsprüfung von Schadensfällen.

## Beispielausgabe

```text
Claims report generated: reports/claims_report.txt
Claims analyzed: 16
High-risk claims: 4
```

## Hinweis auf synthetische Daten

Alle Daten in diesem Projekt sind synthetisch. Das Repository ist ein Bewerberprojekt und bildet kein echtes Versicherungssystem ab.

## English Summary

This Java applicant project demonstrates a simplified insurance claims workflow with object-oriented modeling, CSV processing, risk scoring, validation, reporting and unit tests. It uses synthetic data and is intentionally scoped for dual study applications in computer science and business information systems.
