package com.example.musicloudbackend.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column

    private Long id;

    @Column
    private String title;

    @Column
    private String artist;

    @Column
    private String language;

    @Column
    private Integer year;


    public Song() {
    }

    public Song(Long id, String title, String artist, String language, Integer year) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.language = language;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", language='" + language + '\'' +
                ", year=" + year +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
