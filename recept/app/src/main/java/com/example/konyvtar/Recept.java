package com.example.konyvtar;

public class Recept {
    private String recept;
    private int minoseg;
    private int nehezseg;

    public Recept(String recept, int minoseg, int nehezseg) {
        this.recept = recept;
        this.minoseg = minoseg;
        this.nehezseg = nehezseg;
    }

    public String getRecept() {
            return recept;
        }
    public void setRecept(String recept) {
            this.recept = recept;
        }
    public int getMinoseg() {
            return minoseg;
        }
    public void setMinoseg(int minoseg) {
            this.minoseg = minoseg;
        }
    public int getNehezseg() { return nehezseg; }
    public void setNehezseg(int nehezseg) {
            this.nehezseg = nehezseg;
        }
}

