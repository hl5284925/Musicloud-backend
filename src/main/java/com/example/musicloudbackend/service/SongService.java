package com.example.musicloudbackend.service;

import com.example.musicloudbackend.exceptions.InformationExistException;
import com.example.musicloudbackend.exceptions.InformationNotFoundException;
import com.example.musicloudbackend.model.Song;
import com.example.musicloudbackend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class SongService {

    private SongRepository songRepository;

@Autowired
    public void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSong(Long id){
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()) {
            return song;
        } else {
            throw new InformationNotFoundException("song with id " + id + " not found");
        }
    }


    public Song createSong(Song songObject) {

        Song song = songRepository.findByTitle(songObject.getTitle());

        if (song != null) {
            throw new InformationExistException("song with title " + song.getTitle() + " already exists");
        } else {
            return songRepository.save(songObject);
        }
    }

    public Song updateSong(Long id, Song songObject) {

        Optional<Song> song = songRepository.findById(id);

        if (song.isPresent()) {
            if (songObject.getTitle().equals(song.get().getTitle())) {
                throw new InformationExistException("song " + song.get().getTitle() + " already exists");
            } else {
                Song updateSong = songRepository.findById(id).get();
                updateSong.setTitle(songObject.getTitle());
                updateSong.setArtist(songObject.getArtist());
                updateSong.setLanguage(songObject.getLanguage());
                updateSong.setYear(songObject.getYear());
                return songRepository.save(updateSong);
            }
        } else {
            throw new InformationNotFoundException("song with id " + id + " not found");
        }
    }

    public Optional<Song> deleteSong(Long id) {
        Optional<Song> song = songRepository.findById(id);

        if (song.isPresent()) {
            songRepository.deleteById(id);
            return song;
        } else {
            throw new InformationNotFoundException("song with id " + id + " not found");
        }
    }

}
