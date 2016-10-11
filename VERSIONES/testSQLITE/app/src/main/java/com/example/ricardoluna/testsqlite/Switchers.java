package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 20/09/2016.
 */
public class Switchers {
    String mdf , rack  ;
    int idSwitcher ,numMdf ,numRack ;

    public Switchers(String mdf, String rack, int idSwitcher, int numMdf, int numRack) {
        this.mdf = mdf;
        this.rack = rack;
        this.idSwitcher = idSwitcher;
        this.numMdf = numMdf;
        this.numRack = numRack;
    }

    public String getMdf() {
        return mdf;
    }

    public void setMdf(String mdf) {
        this.mdf = mdf;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }

    public int getIdSwitcher() {
        return idSwitcher;
    }

    public void setIdSwitcher(int idSwitcher) {
        this.idSwitcher = idSwitcher;
    }

    public int getNumMdf() {
        return numMdf;
    }

    public void setNumMdf(int numMdf) {
        this.numMdf = numMdf;
    }

    public int getNumRack() {
        return numRack;
    }

    public void setNumRack(int numRack) {
        this.numRack = numRack;
    }
}
