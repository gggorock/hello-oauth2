package me.study.hellooauth.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class GoogleUserInfo {
    private final Long id;
    private final String email;
    @JsonProperty("verified_email")
    private final boolean verifiedEmail;
    private final String picture;

    public GoogleUserInfo(Long id, String email, boolean verifiedEmail, String picture) {
        this.id = id;
        this.email = email;
        this.verifiedEmail = verifiedEmail;
        this.picture = picture;
    }
}
