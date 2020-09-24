package com.zkdlu.template.spring_kotlin.service

import com.zkdlu.template.spring_kotlin.model.entity.User
import com.zkdlu.template.spring_kotlin.model.request.UserVO
import com.zkdlu.template.spring_kotlin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val userRepository:UserRepository) {
    fun createUser(userVo: UserVO): Boolean {
        val user = userVo.convertToDao() as User

        return try {
            userRepository.save(user)
            true
        } catch (exception:Exception){
            println(exception.message)
            false
        }
    }

    fun getUserAll(): List<UserVO> {
        val users:List<User> = userRepository.findAll()

        return users.map { it.convertToVO() } as List<UserVO>
    }

    fun getUser(key: Int): UserVO? {
        val result = userRepository.findById(key)

        return try {
            val user: User? = result.get()
            user?.convertToVO() as UserVO
        } catch (exception:Exception) {
            println(exception.message)
            null
        }
    }

    fun updateUser(key: Int, userVo: UserVO): UserVO? {
        val result = userRepository.findById(key)


        try {
            val user: User? = result.get()
            user?.name = userVo.name
            user?.password = userVo.password

            user?.let {
                return userRepository.save(it).convertToVO() as UserVO
            }

            return null
        } catch (exception:Exception){
            println(exception.message)
            return null
        }
    }

    fun deleteUser(key: Int): Boolean {
        return try {
            userRepository.deleteById(key)
            true
        } catch (exception:Exception) {
            println(exception.message)
            false
        }
    }
}