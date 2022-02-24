package com.example.musicloudbackend.repository;

import com.example.musicloudbackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Song findByTitle(String Title);
}
