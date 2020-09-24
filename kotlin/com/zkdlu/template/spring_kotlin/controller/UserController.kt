package com.zkdlu.template.spring_kotlin.controller

import com.zkdlu.template.spring_kotlin.interfaces.CrudController
import com.zkdlu.template.spring_kotlin.model.request.UserVO
import com.zkdlu.template.spring_kotlin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(@Autowired val userService: UserService) : CrudController<UserVO, Int>{

    override fun create(model: UserVO): Boolean {
        return userService.createUser(model)
    }

    override fun read(): List<UserVO> {
        return userService.getUserAll()
    }

    override fun update(key: Int, model: UserVO): UserVO? {
        return userService.updateUser(key, model)
    }

    override fun delete(key: Int): Boolean {
        return userService.deleteUser(key)
    }

    override fun readOne(key: Int): UserVO? {
        return userService.getUser(key)
    }
}