![Java CI](https://github.com/JojoMab/java-insurance-claims-manager/actions/workflows/java-ci.yml/badge.svg)

# Java Insurance Claims Manager

Dieses Bewerberprojekt zeigt Java/OOP anhand eines vereinfachten Versicherungsprozesses. Die Anwendung lädt synthetische Schadensfälle aus CSV-Dateien, validiert die Daten, berechnet Risiko-Scores und erzeugt einen Textreport. Das Projekt verbindet Softwarestruktur mit einem fachlichen Beispiel aus Finanz- und Versicherungs-IT.

## Bewerbungskontext

Das Projekt passt zu dualen Studiengängen in Informatik und Wirtschaftsinformatik mit Bezug zu Versicherungsprozessen, Finanz-IT, Datenvalidierung und Java/OOP. Es ist besonders relevant für Allianz, Generali, Atruvia, Finanz Informatik, Bayerische Versorgungskammer, BG-Phoenics und ConSol.

## Tech Stack

- Java 21
- Maven
- JUnit 5
- CSV-Verarbeitung
- Objektorientierte Modellierung
- GitHub Actions

## Funktionen

- Schadensfälle aus CSV laden
- Pflichtfelder und Beträge validieren
- Risiko-Score von 1 bis 10 berechnen
- Statusfilter anwenden
- Gesamtsumme berechnen
- Hochrisiko-Fälle erkennen
- Textreport erzeugen

## Projektstruktur

```txt
java-insurance-claims-manager/
├── src/main/java/com/example/claims/
│   ├── InsuranceClaimsApp.java
│   ├── model/Claim.java
│   ├── service/ClaimService.java
│   ├── service/RiskScorer.java
│   ├── io/CsvClaimReader.java
│   ├── io/ReportGenerator.java
│   └── util/ClaimValidator.java
├── src/test/java/com/example/claims/
├── data/claims_sample.csv
├── pom.xml
├── README.md
└── docs/
```

## Schnellstart

```bash
mvn test
mvn exec:java -Dexec.mainClass=com.example.claims.InsuranceClaimsApp
```

## Tests ausführen

```bash
mvn test
```

## Beispielausgabe

```txt
Insurance Claims Report
Anzahl Schadensfälle: 18
Gesamtsumme: 189540.00 EUR
Hochrisiko-Fälle: 6
```

## Hinweis auf synthetische Daten

Alle Daten sind synthetisch und dienen ausschließlich der Demonstration.

## English Summary

This Java project demonstrates object-oriented programming with a simplified insurance claims workflow. It loads synthetic claims from CSV, validates data, calculates risk scores and creates a text report. The project is designed as an applicant portfolio project for computer science and business information systems programs.
