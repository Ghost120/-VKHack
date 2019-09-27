package ru.kasyan.example.model;


import javax.persistence.*;

@Entity
@Table(name = "places")
public class Place {
    private String photoName;
    private String description;
    private int id;
    private double latitude;
    private double longitude;
    private String country;
    private String city;
    private String vk_link;
    private int userVkId;
    private String fileNameInFileSystem;


    public Place(String photoName, String description, int id, int latitude, int longitude, String country, String city, String vk_link, int userVkId, String fileNameInFileSystem) {
        this.photoName = photoName;
        this.description = description;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.vk_link = vk_link;
        this.userVkId = userVkId;
        this.fileNameInFileSystem = fileNameInFileSystem;
    }

    public Place() {
    }

    @Column(name = "photo_name", nullable = false)
    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "latitude", nullable = false)

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude", nullable = false)
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Column(name = "country", nullable = false)
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "city", nullable = false)
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "vk_link", nullable = false)
    public String getVk_link() {
        return vk_link;
    }
    public void setVk_link(String vk_link) {
        this.vk_link = vk_link;
    }

    @Column(name = "user_vk_id", nullable = false)
    public int getUserVkId() {
        return userVkId;
    }
    public void setUserVkId(int userVkId) {
        this.userVkId = userVkId;
    }

    @Column(name = "file_name_in_filesytem", nullable = false)
    public String getFileNameInFileSystem() {
        return fileNameInFileSystem;
    }
    public void setFileNameInFileSystem(String fileNameInFileSystem) {
        this.fileNameInFileSystem = fileNameInFileSystem;
    }
}
