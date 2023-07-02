package com.agussuhardi.user.service;


import com.agussuhardi.user.dto.UsersDTO;

/**
 * @author agussuhardi
 * @created 17/06/23/06/2023 :06.06
 * @project spring-demo-full
 */
public interface UserService {
    UsersDTO getById(String id);

    String createUserName(String fullName);
}
