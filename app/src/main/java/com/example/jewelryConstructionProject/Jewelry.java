package com.example.jewelryConstructionProject;
import java.util.UUID;

public class Jewelry {

    private UUID Id;
    private String title;
    private String description;
    private String date;
    private Boolean isForExhibition;

    public Jewelry(String title, String description, String date, Boolean isForExhibition) {
        Id = UUID.randomUUID();

        this.title = title;
        this.description = description;
        this.date = date;
        this.isForExhibition = isForExhibition;
    }
    public UUID getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getForExhibition() {
        return isForExhibition;
    }

    public void setForExhibition(Boolean forExhibition) {
        isForExhibition = forExhibition;
    }
}

