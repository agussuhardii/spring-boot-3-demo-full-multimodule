package com.agussuhardi.user.service;


import com.agussuhardi.user.dto.UsersDTO;
import com.agussuhardi.user.vo.LoginVO;
import com.agussuhardi.user.vo.RegisterVO;
import com.agussuhardi.user.vo.UpdateUserVO;

/**
 * @author agus.suhardii@gmail.com
 * @created 15/06/23/06/2023 :06.36
 * @project spring-demo-full
 */
public interface AuthService {
    void register(RegisterVO vo);

    String login(LoginVO vo);

    UsersDTO getMySelf();

    void updateMySelf(UpdateUserVO vo);
}
