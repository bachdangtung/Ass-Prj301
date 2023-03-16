/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Lecture {
    private int id;
    private ArrayList<Group> groups;
    private ArrayList<Instructor> instructors;
    private ArrayList<TimeSlot> timeSlots;
    private ArrayList<Room> rooms;
    private Date Date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public ArrayList<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(ArrayList<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Lecture(int id, ArrayList<Group> groups, ArrayList<Instructor> instructors, ArrayList<TimeSlot> timeSlots, ArrayList<Room> rooms, Date Date) {
        this.id = id;
        this.groups = groups;
        this.instructors = instructors;
        this.timeSlots = timeSlots;
        this.rooms = rooms;
        this.Date = Date;
    }

    public Lecture() {
    }
}
