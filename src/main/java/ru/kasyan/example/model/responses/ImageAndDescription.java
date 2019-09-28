package ru.kasyan.example.model.responses;

public class ImageAndDescription {

    private String image;
    private String photoName;
    private String description;
    private double lattitude;
    private double longtitude;
    private String country;
    private String city;
    private String vkLink;

    public ImageAndDescription(String image, String photoName, String description, double lattitude, double longtitude, String country, String city, String vkLink) {
        this.image = image;
        this.photoName = photoName;
        this.description = description;
        this.lattitude = lattitude;
        this.longtitude = longtitude;
        this.country = country;
        this.city = city;
        this.vkLink = vkLink;
    }

    public ImageAndDescription() {}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVkLink() {
        return vkLink;
    }

    public void setVkLink(String vkLink) {
        this.vkLink = vkLink;
    }
}
