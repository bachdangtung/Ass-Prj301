/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Asus
 */
public class TimeSlot {
    private int id;
    private Time from;
    private Time to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getFrom() {
        return from;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setTo(Time to) {
        this.to = to;
    }

    public TimeSlot() {
    }

    public TimeSlot(int id, Time from, Time to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }
    
}
