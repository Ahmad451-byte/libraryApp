
# LibraryApp – JavaFX Buchverwaltung

Diese Anwendung ist ein einfaches Buchverwaltungsprogramm auf Basis von JavaFX, das Bücher in einer MySQL-Datenbank speichert und anzeigt.

## Funktionen
- Bücher hinzufügen und speichern
- Gespeicherte Bücher anzeigen
- Datenbankanbindung mit JDBC
- GUI mit JavaFX

## Voraussetzungen
- Java 17
- Maven
- MySQL

## Datenbankverbindung

Die Datei `Database.java` enthält Platzhalter für die Verbindungsdaten zur Datenbank:

```java
private static final String URL = "jdbc:mysql://<HOST>:<PORT>/<DB_NAME>";
private static final String USER = "<USERNAME>";
private static final String PASSWORD = "<PASSWORD>"; // Aus Sicherheitsgründen hier nicht eintragen

> Um das Projekt lokal auszuführen, ersetze diese Platzhalter mit deinen echten Zugangsdaten.



Hinweis

Aus Sicherheitsgründen enthält dieses Repository keine echten Zugangsdaten. Bitte trage deine eigenen lokalen Verbindungsdaten ein, um die Anwendung zu testen oder weiterzuentwickeln.
Holen Sie sich Outlook für Android
