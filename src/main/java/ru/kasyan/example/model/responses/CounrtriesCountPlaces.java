package ru.kasyan.example.model.responses;

public class CounrtriesCountPlaces {
    private String countryName;
    private int latitude;

    public CounrtriesCountPlaces(String photoName, int latitude) {
        this.countryName = photoName;
        this.latitude = latitude;
    }

    public String getPhotoName() {
        return countryName;
    }

    public void setPhotoName(String photoName) {
        this.countryName = photoName;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}
