package com.example.actor.model;

import android.graphics.drawable.Drawable;

import java.util.*;

public class ModelActor {

    private Drawable imagePhoto = null;
    private String   textName = ""  ;
    private String   textAge = ""  ;
    private String   textDescription = ""  ;


    // child 데이터
    List<ModelMovie> movies = new ArrayList<>();
    List<ModelDrama> dramas = new ArrayList<>();
    List<ModelComment> comments = new ArrayList<>();

    public List<ModelMovie> getMovies() { return movies; }
    public List<ModelDrama> getDramas() { return dramas; }
    public List<ModelComment> getComments() { return comments; }

    public void setMovies(List<ModelMovie> movies) { this.movies = movies; }
    public void setDramas(List<ModelDrama> dramas) { this.dramas = dramas; }
    public void setComments(List<ModelComment> comments) { this.comments = comments; }

    public Drawable getImagePhoto() {
        return imagePhoto;
    }

    public void setImagePhoto(Drawable imagePhoto) {
        this.imagePhoto = imagePhoto;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextAge() {
        return textAge;
    }

    public void setTextAge(String textAge) {
        this.textAge = textAge;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @Override
    public String toString() {
        return "ModelActor{" +
                "imagePhoto=" + imagePhoto +
                ", textName='" + textName + '\'' +
                ", textAge='" + textAge + '\'' +
                ", textDescription='" + textDescription + '\'' +
                '}';
    }

    public ModelActor() {
    }
    public ModelActor(Drawable imagePhoto, String textName, String textAge, String textDescription) {
        this.imagePhoto = imagePhoto;
        this.textName = textName;
        this.textAge = textAge;
        this.textDescription = textDescription;
    }
}
