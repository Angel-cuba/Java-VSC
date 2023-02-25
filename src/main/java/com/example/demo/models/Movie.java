package com.example.demo.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "movies")

public class Movie {
    @Id
    private ObjectId id;
    private String indbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getIndbId() {
        return indbId;
    }
    public void setIndbId(String indbId) {
        this.indbId = indbId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getTrailerLink() {
        return trailerLink;
    }
    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public List<String> getBackdrops() {
        return backdrops;
    }
    public void setBackdrops(List<String> backdrops) {
        this.backdrops = backdrops;
    };
    public List<Review> getReviewIds() {
        return reviewIds;
    }
}
