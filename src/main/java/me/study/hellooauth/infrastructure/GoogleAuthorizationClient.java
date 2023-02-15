package me.study.hellooauth.infrastructure;

import me.study.hellooauth.domain.GoogleAccessTokenInfo;
import me.study.hellooauth.domain.GoogleAccessTokenRefreshRequest;
import me.study.hellooauth.domain.GoogleAccessTokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "googleClient", url="https://oauth2.googleapis.com/token")
public interface GoogleAuthorizationClient {
    @RequestMapping(method = RequestMethod.POST)
    GoogleAccessTokenInfo exchange(@RequestBody GoogleAccessTokenRequest request);

    @RequestMapping(method = RequestMethod.POST)
    GoogleAccessTokenInfo refresh(GoogleAccessTokenRefreshRequest request);


}
