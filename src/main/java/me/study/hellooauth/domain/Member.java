package me.study.hellooauth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String email;

    private String picture;

    @Builder
    public Member(String email, String picture) {
        this.email = email;
        this.picture = picture;
    }

    public static Member of(GoogleUserInfo info) {
        String email = info.getEmail();
        String picture = info.getPicture();
        return new Member(email, picture);
    }
}
