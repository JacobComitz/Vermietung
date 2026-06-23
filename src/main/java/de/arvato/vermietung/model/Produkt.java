package de.arvato.vermietung.model;

public class Produkt {
    private String name;
    private String beschreibung;
    private String kategorie;
    private int anzahl;
    private double preisProTag;
    private String bildpfad;

    public Produkt(String name, String beschreibung, String kategorie, int anzahl, double preisProTag, String bildpfad) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.kategorie = kategorie;
        this.anzahl = anzahl;
        this.preisProTag = preisProTag;
        this.bildpfad = bildpfad;

    }

    public String getName() {
        return name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getKategorie() {
        return kategorie;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public double getPreisProTag() {
        return preisProTag;
    }

    public String getBildpfad() {
        return bildpfad;
    }
}
