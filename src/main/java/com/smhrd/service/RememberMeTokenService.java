package com.smhrd.service;

import com.smhrd.model.rememberMe.RememberMeToken;
import com.smhrd.repository.rememberme.RememberMeTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class RememberMeTokenService implements PersistentTokenRepository {
    @Autowired
    private RememberMeTokenRepository rememberMeTokenRepository;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        RememberMeToken newToken = new RememberMeToken(token);
        rememberMeTokenRepository.save(newToken);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        RememberMeToken token = rememberMeTokenRepository.findBySeries(series);
        if(token != null) {
            token.setToken(tokenValue);
            token.setLastUsed(lastUsed);
            this.rememberMeTokenRepository.save(token);
        }
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        RememberMeToken token = rememberMeTokenRepository.findBySeries(seriesId);
        return new PersistentRememberMeToken(token.getUsername(), token.getSeries(), token.getToken(), token.getLastUsed());
    }

    @Override
    public void removeUserTokens(String username) {
        List<RememberMeToken> tokenList = rememberMeTokenRepository.findByUsername(username);
        for(RememberMeToken rememberMeToken : tokenList) {
            if(rememberMeToken != null) {
                rememberMeTokenRepository.delete(rememberMeToken);
            }
        }
    }
}
