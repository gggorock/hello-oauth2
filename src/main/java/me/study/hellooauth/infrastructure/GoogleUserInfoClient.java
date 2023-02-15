package me.study.hellooauth.infrastructure;

import me.study.hellooauth.domain.GoogleUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "googleUserInfoClient",
        url="https://www.googleapis.com/oauth2/v1/userinfo?alt=json")
public interface GoogleUserInfoClient {

    @RequestMapping(method = RequestMethod.GET)
    GoogleUserInfo getInfo(@RequestHeader("Authorization") String accessToken);

}
