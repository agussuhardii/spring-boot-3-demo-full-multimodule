package com.agussuhardi.user.controller;


import com.agussuhardi.user.dto.UsersDTO;
import com.agussuhardi.user.service.impl.UserServiceImpl;
import com.agussuhardi.user.vo.UserQueryVO;
import com.agussuhardi.user.vo.UserUpdateVO;
import com.agussuhardi.user.vo.UserVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author agus.suhardii@gmail.com
 * @created 14/06/23/06/2023 :21.16
 * @project spring-demo-full
 */
@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public String save(@Valid @RequestBody UserVO vO) {
        return userServiceImpl.save(vO);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        userServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody UserUpdateVO vO) {
        userServiceImpl.update(id, vO);
    }

    @GetMapping("/{id}")
    public UsersDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return userServiceImpl.getById(id);
    }

    @GetMapping
    public Page<UsersDTO> query(@Valid UserQueryVO vO) {
        return userServiceImpl.query(vO);
    }
}
