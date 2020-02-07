package com.application.usermanagemet.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.application.usermanagemet.config.security.JwtTokenProvider;
import com.application.usermanagemet.service.CustomUserDetailsService;
import com.application.usermanagemet.util.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtOncePerRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwtToken = getJwtTokenFromRequest(request);
        if (StringUtils.hasText(jwtToken) && tokenProvider.validateToken(jwtToken)) {
            Long userId = tokenProvider.getUserIdFromToken(jwtToken);
            UserDetails userDetails = userDetailsService.loadUserById(userId);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }        
        filterChain.doFilter(request, response);
    }

    private String getJwtTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader(Constant.JWT_HEADER_KEY.getValue());
        if (StringUtils.hasText(token) && token.contains(Constant.TOKEN_TYPE.getValue())) {
            return token.replace(Constant.TOKEN_TYPE.getValue(), "").trim();
        }
        return null;
    }

}