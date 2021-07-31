/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Yassine
 */
public class Event {

    private int id;
    private int idu;
    private String event_name;
    private String date;
    private String heure;
    private String place;

    public Event(int id, int idu, String event_name, String date, String heure, String place) {
        this.id = id;
        this.idu = idu;
        this.event_name = event_name;
        this.date = date;
        this.heure = heure;
        this.place = place;
    }

    public Event(int idu, String event_name, String date, String heure, String place) {
        this.idu = idu;
        this.event_name = event_name;
        this.date = date;
        this.heure = heure;
        this.place = place;
    }

    public Event(String event_name, String date, String heure, String place) {
        this.event_name = event_name;
        this.date = date;
        this.heure = heure;
        this.place = place;
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", idu=" + idu + ", event_name=" + event_name + ", date=" + date + ", heure=" + heure + ", place=" + place + '}';
    }

}
