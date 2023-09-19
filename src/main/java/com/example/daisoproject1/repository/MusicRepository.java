package com.example.daisoproject1.repository;

import com.example.daisoproject1.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long > {

    Optional<Music> findMusicByOriginalName(String originalName);
    Optional<Music> findMusicByStoreFileName(String storeFileName);
}
