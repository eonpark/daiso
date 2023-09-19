package com.example.daisoproject1.controller;

import com.example.daisoproject1.jwt.JwtTokenProvider;
import com.example.daisoproject1.service.MusicService;
import com.example.daisoproject1.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/music")
public class MusicController {
    private final S3Service s3Service;
    private final MusicService musicService;

    @PostMapping("/upload")
    public ResponseEntity  upload(HttpServletRequest httpServletRequest, @RequestPart MultipartFile file) throws IOException {
        String bearerToken = httpServletRequest.getHeader("Authorization");
        String jwt = "";
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")){
            jwt = bearerToken.substring(7);
        }
        musicService.Save(file, jwt);
        return ResponseEntity.ok().body("okay");
    }


}
