# Inventory-App (Games & Displays) 📦📱

Meine vierte Android-App! Dieses Projekt ist ein mächtiges Upgrade zu meinen vorherigen Apps. 
Hier ging es darum zwischen verschiedenen Screens zu navigieren und Nutzereingaben sicher zu verarbeiten.

Direkt zum Code 👉 

## 🚀 Was das Projekt kann:
* **Zwei Kategorien:** Verwaltung von Spiele-Sammlungen (`Game`) und Bildschirmen/TVs (`Display`).
* **Volles Daten-Handling:** Dynamisches Anzeigen, Hinzufügen neuer Objekte über Formulare und gezieltes Löschen live aus der Liste.
* **Smarte Screen-Navigation:** Ein funktionierendes Homescreen-System, das über Zustände nahtlos zwischen Listenansichten und Editor-Formularen wechselt.
* **Absturzsichere Eingabe:** Die App fängt falsche Nutzereingaben (z.B. Buchstaben in Preisfeldern) automatisch ab, ohne zu crashen.

## 🧠 Gelerntes & Konzepte:
* **State Hoisting & Lifted States:** Zentrales Verwalten von `mutableStateListOf` ganz oben in der Hierarchie, damit die Daten beim Screen-Wechsel nicht verloren gehen.
* **Dynamische Listen:** Tiefes Verständnis von `LazyColumn`, `items()` und `item()`-Blöcken für flüssiges Scrollen und Live-Updates der UI beim Löschen.
* **Crash-Prevention (Kotlin-Logik):** Einsatz von `.toDoubleOrNull() ?: 0.0` und `.toIntOrNull() ?: 0`, um ungültige Formular-Eingaben sicher zu handhaben.
* **Formular-Reset:** Automatisches Leeren aller temporären Variablen nach dem Hinzufügen eines Objekts für ein sauberes Nutzererlebnis.
