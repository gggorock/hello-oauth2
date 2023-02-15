package me.study.hellooauth.infrastructure;

import lombok.RequiredArgsConstructor;
import me.study.hellooauth.domain.GoogleAccessTokenInfo;
import me.study.hellooauth.domain.GoogleAccessTokenRefreshRequest;
import me.study.hellooauth.domain.GoogleAccessTokenRequest;
import me.study.hellooauth.domain.GoogleUserInfo;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class GoogleOauthDao implements OauthDao {

    private final String CLIENT_ID = "396972341265-do8d7jd9ohk7ue04ghe1srpr9l651bad.apps.googleusercontent.com";
    private final String CLIENT_SECRET = "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";
    private final String REDIRECT_URI = "http://localhost:8080/login/oauth/google";
    private final String GRANT_TYPE_EXCHANGE = "authorization_code";
    private final String GRANT_TYPE_REFRESH = "refresh_token";

    private final GoogleAuthorizationClient googleAuthorizationClient;

    private final GoogleUserInfoClient googleUserInfoClient;
    public GoogleAccessTokenInfo exchange(String code) {
        GoogleAccessTokenRequest request = GoogleAccessTokenRequest.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .code(code)
                .grantType(GRANT_TYPE_EXCHANGE)
                .redirectUri(REDIRECT_URI)
                .build();
        return googleAuthorizationClient.exchange(request);
    }

    public GoogleAccessTokenInfo refresh(String refreshToken) {
        GoogleAccessTokenRefreshRequest request = GoogleAccessTokenRefreshRequest.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .grantType(GRANT_TYPE_REFRESH)
                .refreshToken(refreshToken)
                .build();
        return googleAuthorizationClient.refresh(request);
    }

    public GoogleUserInfo getInfo(String accessToken) {
        String authorizationHeaderValue = String.format("Bearer %s", accessToken);
        return googleUserInfoClient.getInfo(authorizationHeaderValue);
    }
}
