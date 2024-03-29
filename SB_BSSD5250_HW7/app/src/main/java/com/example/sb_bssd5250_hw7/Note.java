package com.example.sb_bssd5250_hw7;

import java.util.Date;

public class Note {

    private String name;
    private String date;
    private String desc;

    public Note() {
        // default to today's date
        date = new Date().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
