package com.example.hashem.eatandeat;

public class table {

    private int tid, nbOfSeats;

    public table(int tid, int nbOfSeats) {
        this.tid = tid;
        this.nbOfSeats = nbOfSeats;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getNbOfSeats() {
        return nbOfSeats;
    }

    public void setNbOfSeats(int nbOfSeats) {
        this.nbOfSeats = nbOfSeats;
    }

    @Override
    public String toString() {
        return "Table " + tid +
                " have " + nbOfSeats +
                " seats";
    }
}
