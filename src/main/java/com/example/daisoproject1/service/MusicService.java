package com.example.daisoproject1.service;

import com.example.daisoproject1.domain.Music;
import com.example.daisoproject1.domain.User;
import com.example.daisoproject1.jwt.JwtTokenProvider;
import com.example.daisoproject1.repository.MusicRepository;
import com.example.daisoproject1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class MusicService {
    private MusicRepository musicRepository;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private S3Service s3client;

    @Transactional
    public void Save(MultipartFile file, String Token) {
        // user 식별
        String proId = jwtTokenProvider.getSubject(Token);
        User user = userRepository.findUserByProId(proId).get();

        // file 가지고 entity 만들고
        Music music = new Music(user, file.getOriginalFilename());
        musicRepository.save(music);

        // s3 save
        try{
            s3client.upload(file, music.getStoreFileName());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
