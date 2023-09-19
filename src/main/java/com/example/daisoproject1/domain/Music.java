package com.example.daisoproject1.domain;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String originalName;
    @Getter
    private String storeFileName;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public Music(User user,String originalName) {
        this.user = user;
        this.originalName = originalName;
        // 확장자 가져오기
        String ext = StringUtils.getFilenameExtension(originalName);

        this.storeFileName = UUID.randomUUID().toString() +"."+ ext;
    }

}
