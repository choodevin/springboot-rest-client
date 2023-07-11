package com.main.api.interceptor;

import com.main.api.model.Users;
import com.main.api.repository.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
public class UserValidationInterceptor implements HandlerInterceptor {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("user-token");
        Optional<Users> usersOptional = usersRepository.findByToken(token);

        if (usersOptional.isPresent()) {
            Users user = usersOptional.get();
            LocalDateTime now = LocalDateTime.now();

            if (now.isBefore(user.getTokenExpire())) {
                return true;
            }
        }

        // Token not found, return unauthorized
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return false;
    }
}
