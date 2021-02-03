package com.hackerearth.demo.dao;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class GameData {    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", updatable = false, nullable = false)
private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    String title;
    String platform;
    String score;
    String genre;
    String editors_choice;

    public GameData() {
    }

    public GameData(String title, String platform, String score, String genre, String editors_choice) {
        this.title = title;
        this.platform = platform;
        this.score = score;
        this.genre = genre;
        this.editors_choice = editors_choice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEditors_choice() {
        return editors_choice;
    }

    public void setEditors_choice(String editors_choice) {
        this.editors_choice = editors_choice;
    }
}
