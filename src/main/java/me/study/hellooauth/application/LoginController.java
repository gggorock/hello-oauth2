package me.study.hellooauth.application;

import lombok.extern.slf4j.Slf4j;
import me.study.hellooauth.domain.GoogleAccessTokenInfo;
import me.study.hellooauth.domain.GoogleUserInfo;
import me.study.hellooauth.infrastructure.GoogleUserInfoClient;
import me.study.hellooauth.infrastructure.GoogleOauthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    private final GoogleOauthDao googleOauthDao;
    private final GoogleUserInfoClient userInfoClient;

    @Autowired
    public LoginController(GoogleOauthDao googleOauthDao, GoogleUserInfoClient userInfoClient) {
        this.googleOauthDao = googleOauthDao;
        this.userInfoClient = userInfoClient;
    }

    @RequestMapping(path = "/login/oauth/google", method = RequestMethod.GET)
    public String login(String code) {
        GoogleAccessTokenInfo exchange = googleOauthDao.exchange(code);
        String accessToken = exchange.getAccessToken();
        GoogleUserInfo info = googleOauthDao.getInfo(accessToken);
        return "info: "+ info;
    }


}
