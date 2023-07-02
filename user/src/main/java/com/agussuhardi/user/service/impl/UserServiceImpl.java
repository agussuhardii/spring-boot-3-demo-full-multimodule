package com.agussuhardi.user.service.impl;

import com.agussuhardi.user.dto.UsersDTO;
import com.agussuhardi.user.entity.User;
import com.agussuhardi.user.repository.UserRepository;
import com.agussuhardi.user.service.UserService;
import com.agussuhardi.user.vo.UserQueryVO;
import com.agussuhardi.user.vo.UserUpdateVO;
import com.agussuhardi.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * @author agus.suhardii@gmail.com
 * @created 14/06/23/06/2023 :21.16
 * @project spring-demo-full
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public String save(UserVO vO) {
        var bean = new User();
        BeanUtils.copyProperties(vO, bean);
        bean = userRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public void update(String id, UserUpdateVO vO) {
        User bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRepository.save(bean);
    }

    @Override
    public UsersDTO getById(String id) {
        User original = requireOne(id);
        return toDTO(original);
    }

    public Page<UsersDTO> query(UserQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UsersDTO toDTO(User original) {
        UsersDTO bean = new UsersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private User requireOne(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    @Override
    public String createUserName(String fullName) {
        var username = fullName.replaceAll("\\s", ".").trim().toLowerCase();
        int i = 0;
        var optional = userRepository.findByUsername(username);
        while (optional.isPresent()) {
            i++;
            optional = userRepository.findByUsername(username + i);
        }
        return username + (i == 0 ? "" : i);
    }
}
