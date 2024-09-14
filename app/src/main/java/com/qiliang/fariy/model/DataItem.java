package com.qiliang.fariy.model;

/*
 * author: huangkuncan
 * date: 2024/9/14
 * desc:
 */
public class DataItem {
    private String image;
    private String logo;
    private String title;
    private String description;
    private double rating;
    private int rating_count;
    private String landing_page;

    // Getters and Setters
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public String getLanding_page() {
        return landing_page;
    }

    public void setLanding_page(String landing_page) {
        this.landing_page = landing_page;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "image='" + image + '\'' +
                ", logo='" + logo + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", rating_count=" + rating_count +
                ", landing_page='" + landing_page + '\'' +
                '}';
    }
}

