package me.study.hellooauth.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class GoogleAccessTokenInfo {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private String scope;
    @JsonProperty("token_type")
    private String tokenType;


    public GoogleAccessTokenInfo(String accessToken, String expiresIn, String refreshToken, String scope, String tokenType) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.tokenType = tokenType;
    }


}
