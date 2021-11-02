package com.example.testback.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.testback.DAO.userDAO;
import com.example.testback.config.auth.PrincipalDetails;
import com.example.testback.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private userDAO userDAO;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, userDAO userDAO) {

        super(authenticationManager);
        this.userDAO=userDAO;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {


        String jwtHeader = request.getHeader("Authorization");
        System.out.println("Header: "+jwtHeader);

        //header 있는지 확인
        if(jwtHeader == null|| !jwtHeader.startsWith("Bearer")){
            chain.doFilter(request,response);
            return;
        }

        //JWT토큰을 검증을 해서 정상적인 사용자 인지 확인
        String jwtToken = request.getHeader("Authorization").replace("Bearer ","");

        String email = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(jwtToken).getClaim("email").asString();

        //서명확인
        if(email != null){
            User userEntity = userDAO.findByName(email);
            PrincipalDetails principalDetails = new PrincipalDetails(userEntity);
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails,null,principalDetails.getAuthorities());

            //시큐리티 세션에 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);

            chain.doFilter(request,response);
        }
    }
}
