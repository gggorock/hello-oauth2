package me.study.hellooauth.application;

import lombok.RequiredArgsConstructor;
import me.study.hellooauth.domain.Authority;
import me.study.hellooauth.domain.GoogleAccessTokenInfo;
import me.study.hellooauth.domain.GoogleUserInfo;
import me.study.hellooauth.domain.Member;
import me.study.hellooauth.infrastructure.GoogleOauthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoogleOauthService {

    private final GoogleOauthDao googleOauthDao;
    private final MemberRepository memberRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public GoogleOauthService(GoogleOauthDao googleOauthDao, MemberRepository memberRepository, AuthorityRepository authorityRepository) {
        this.googleOauthDao = googleOauthDao;
        this.memberRepository = memberRepository;
        this.authorityRepository = authorityRepository;
    }

    public void join(String code) {
        GoogleAccessTokenInfo authorizationInfo = googleOauthDao.exchange(code);
        String accessToken = authorizationInfo.getAccessToken();
        GoogleUserInfo info = googleOauthDao.getInfo(accessToken);

        memberRepository.findMemberByEmail(info.getEmail())
                .ifPresent(duplicatedMember -> { throw new DuplicatedMemberException();});

        Member newMember = Member.of(info);
        memberRepository.save(newMember);

        Long memberId = newMember.getId();
        Authority authority = Authority.of(memberId, authorizationInfo);
        authorityRepository.save(authority);
    }
}
