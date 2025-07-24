package com.itxiaodao.interceptors;

import com.itxiaodao.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            response.getWriter().write("Missing token");
            return false;
        }

        try {
            Claims claims = JwtUtil.parseToken(token);

            // 验证 Redis 中是否存在
            String username = redisTemplate.opsForValue().get(token);
            if (username == null) {
                response.setStatus(401);
                response.getWriter().write("Token expired or invalid");
                return false;
            }

        } catch (Exception e) {
            response.setStatus(401);
            response.getWriter().write("Invalid token");
            return false;
        }

        return true;
    }

}
