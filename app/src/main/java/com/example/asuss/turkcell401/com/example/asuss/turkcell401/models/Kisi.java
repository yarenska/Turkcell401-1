package com.example.asuss.turkcell401.com.example.asuss.turkcell401.models;

public class Kisi {
    private int photoID;
    private String name;
    private String job;

    public Kisi(int photoID, String name, String job){
        this.photoID = photoID;
        this.name = name;
        this.job = job;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getPhotoID() {
        return photoID;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
