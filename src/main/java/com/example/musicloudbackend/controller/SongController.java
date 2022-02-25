package com.example.musicloudbackend.controller;

import com.example.musicloudbackend.model.Song;
import com.example.musicloudbackend.repository.SongRepository;
import com.example.musicloudbackend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SongController {

    private SongService songService;

    @Autowired
    public void setSongService(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/test/")
    public String getTest(){return "The test is working!";}

    @GetMapping("/songs/")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }


    @GetMapping("/songs/{id}/")
    public Optional<Song> getSong(@PathVariable Long id) throws Exception {

        Optional<Song> song = songService.getSong(id);

        if (song.isPresent()) {
            return song;
        } else {
            throw new Exception("song with id " + id + " not found");
        }
    }

    @PostMapping("/songs/")
    public Song createSong(@RequestBody Song songObject) {

        return songService.createSong(songObject);

    }

    @PutMapping("/songs/{id}/")
    public Song updateSong(@PathVariable(value = "id") Long id, @RequestBody Song songObject) {

        return songService.updateSong(id, songObject);

    }

    @DeleteMapping("/songs/{id}/")
    public Optional<Song> deleteSong(@PathVariable(value = "id") Long id) {
        return songService.deleteSong(id);
    }



}
