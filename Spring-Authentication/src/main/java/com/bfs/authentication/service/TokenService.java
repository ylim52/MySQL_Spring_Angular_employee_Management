package com.bfs.authentication.service;

import com.bfs.authentication.dao.TokenDao;
import com.bfs.authentication.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("tokenService")
@Transactional
public class TokenService {

    @Autowired
    private TokenDao tokenDao;

    public List<Token> getByToken(String token){
        List<Token> tokens = tokenDao.findByToken(token);
        return tokens;
    }

}
