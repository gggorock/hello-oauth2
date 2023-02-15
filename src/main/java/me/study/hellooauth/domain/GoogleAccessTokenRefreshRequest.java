package me.study.hellooauth.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoogleAccessTokenRefreshRequest {
    private final String refreshToken;
    private final String clientId;
    private final String clientSecret;
    private final String grantType;

    @Builder
    GoogleAccessTokenRefreshRequest(String refreshToken, String clientId, String clientSecret, String grantType) {
        this.refreshToken = refreshToken;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
    }
}
