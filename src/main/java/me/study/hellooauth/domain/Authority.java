package me.study.hellooauth.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(of = "id")
public class Authority {

    @Id
    @GeneratedValue
    private Long id;
    private Long memberId;

    @Embedded
    private GoogleAccessTokenInfo googleAccessTokenInfo;

    Authority(Long memberId, GoogleAccessTokenInfo googleAccessTokenInfo) {
        this.memberId = memberId;
        this.googleAccessTokenInfo = googleAccessTokenInfo;
    }

    public static Authority of(Long memberId, GoogleAccessTokenInfo googleAccessTokenInfo) {
        return new Authority(memberId, googleAccessTokenInfo);
    }
}
