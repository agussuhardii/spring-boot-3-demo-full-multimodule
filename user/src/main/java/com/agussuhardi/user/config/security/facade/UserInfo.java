package com.agussuhardi.user.config.security.facade;

import com.agussuhardi.user.config.exception.CustomException;
import com.agussuhardi.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public final class UserInfo {

    public static User getPrincipal() {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null)
            throw new CustomException(HttpStatus.FORBIDDEN, "aaaaaaaaaaaaaa");
        return (User) principal;
    }
}
