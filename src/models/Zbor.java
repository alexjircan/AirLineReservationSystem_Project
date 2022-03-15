package models;

import java.util.ArrayList;

public class Zbor {
    private int idZbor, idPilot, pretBilet, nrLocuriTotal, nrLocuriLibere;
    private String dataPlecare, aeroportP, aeroportS;

    public Zbor(int idZbor, int idPilot, int pretBilet, int nrLocuriTotal, int nrLocuriLibere, String dataPlecare, String aeroportP, String aeroportS) {
        this.idZbor = idZbor;
        this.idPilot = idPilot;
        this.pretBilet = pretBilet;
        this.nrLocuriTotal = nrLocuriTotal;
        this.nrLocuriLibere = nrLocuriLibere;
        this.dataPlecare = dataPlecare;
        this.aeroportP = aeroportP;
        this.aeroportS = aeroportS;
    }

    public int getIdZbor() {
        return idZbor;
    }

    public int getIdPilot() {
        return idPilot;
    }

    public int getPretBilet() {
        return pretBilet;
    }

    public int getNrLocuriTotal() {
        return nrLocuriTotal;
    }

    public int getNrLocuriLibere() {
        return nrLocuriLibere;
    }

    public String getDataPlecare() {
        return dataPlecare;
    }

    public String getAeroportP() {
        return aeroportP;
    }

    public String getAeroportS() {
        return aeroportS;
    }
}
