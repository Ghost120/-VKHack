package ru.kasyan.example.model.responses;

public class CounrtriesCountPlaces {
    private String photoName;
    private int latitude;

    public CounrtriesCountPlaces(String photoName, int latitude) {
        this.photoName = photoName;
        this.latitude = latitude;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}
