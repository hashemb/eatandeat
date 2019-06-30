package com.example.hashem.eatandeat;

import java.sql.Date;
import java.sql.Time;

public class reserve {

    private int rid, id, tid, isVIP, Kids, paymentM;
        private Date date;
        private Time stime, etime;

    public reserve(int rid, int id, int tid, Date date, Time stime, Time etime, int isVIP, int kids, int paymentM) {
            this.rid = rid;
            this.id = id;
            this.tid = tid;
        this.isVIP = isVIP;
        Kids = kids;
        this.paymentM = paymentM;
        this.date = date;
        this.stime = stime;
        this.etime = etime;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getIsVIP() {
        return isVIP;
    }

    public void setIsVIP(int isVIP) {
        this.isVIP = isVIP;
    }

    public int getKids() {
        return Kids;
    }

    public void setKids(int kids) {
        Kids = kids;
    }

    public int getPaymentM() {
        return paymentM;
    }

    public void setPaymentM(int paymentM) {
        this.paymentM = paymentM;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStime() {
        return stime;
    }

    public void setStime(Time stime) {
        this.stime = stime;
    }

    public Time getEtime() {
        return etime;
    }

    public void setEtime(Time etime) {
        this.etime = etime;
    }
}
