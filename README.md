# Java Insurance Claims Manager

Java/OOP-Bewerberprojekt fuer einen vereinfachten Versicherungsprozess. Die Anwendung laedt synthetische Schadensfaelle aus CSV-Dateien, prueft Plausibilitaet, berechnet Risiko und Prioritaet und erzeugt einen strukturierten Report.

## Kurzprofil fuer Recruiter

Das Projekt zeigt Java-Grundlagen, objektorientierte Modellierung, Services, CSV-Verarbeitung, einfache Geschaeftslogik und JUnit-Tests. Es ist fachlich auf Finanz- und Versicherungs-IT ausgerichtet und bleibt bewusst auf Bewerberniveau fuer ein duales Studium.

## Bewerbungsbezug

Passend fuer Allianz, Generali, Atruvia, Finanz Informatik, Bayerische Versorgungskammer, BG-Phoenics und ConSol.

## Tech Stack

- Java 21
- Maven
- JUnit 5
- CSV-Dateien
- einfache Service- und Reportstruktur
- GitHub Actions CI

## Funktionen

- Versicherungsfaelle aus CSV laden
- Schadensfaelle als Java-Objekte modellieren
- Risiko-Score berechnen
- Prioritaet bestimmen
- Plausibilitaetspruefung durchfuehren
- Report als TXT erzeugen
- JUnit-Tests fuer Risiko- und Service-Logik

## Projektstruktur

```txt
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
│   ├── io/CsvClaimReader.java
│   ├── model/
│   └── service/
└── src/test/java/de/jojomab/claims/
```

## Schnellstart

```bash
mvn test
mvn exec:java -Dexec.mainClass=de.jojomab.claims.Main
```

## Beispielausgabe

```txt
Claims report generated: reports/claims_report.txt
```

## Was ich mit dem Projekt zeige

- Java/OOP-Grundlagen
- Klassen, Services und einfache Geschaeftslogik
- Finanz-/Versicherungsprozessverstaendnis
- Datenvalidierung auf Bewerberniveau
- JUnit-Tests und CI

## Hinweis

Synthetische Daten, keine echten Versicherungsdaten und kein produktives System.

## English Summary

Java applicant project for a simplified insurance claims workflow. It demonstrates object-oriented design, CSV processing, risk scoring, report generation and unit tests with synthetic data.
