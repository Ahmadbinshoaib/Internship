package com.example.apiassignment;

public class Structure {
    private float id;
    private String title;
    private String event_date_utc;
    private float event_date_unix;
    private float flight_number;
    private String details;
    Links LinksObject;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEvent_date_utc() {
        return event_date_utc;
    }

    public float getEvent_date_unix() {
        return event_date_unix;
    }

    public float getFlight_number() {
        return flight_number;
    }

    public String getDetails() {
        return details;
    }

    public Links getLinks() {
        return LinksObject;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEvent_date_utc(String event_date_utc) {
        this.event_date_utc = event_date_utc;
    }

    public void setEvent_date_unix(float event_date_unix) {
        this.event_date_unix = event_date_unix;
    }

    public void setFlight_number(float flight_number) {
        this.flight_number = flight_number;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setLinks(Links linksObject) {
        this.LinksObject = linksObject;
    }
}
class Links {
    private String reddit = null;
    private String article;
    private String wikipedia;


    // Getter Methods

    public String getReddit() {
        return reddit;
    }

    public String getArticle() {
        return article;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    // Setter Methods

    public void setReddit(String reddit) {
        this.reddit = reddit;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }
}
