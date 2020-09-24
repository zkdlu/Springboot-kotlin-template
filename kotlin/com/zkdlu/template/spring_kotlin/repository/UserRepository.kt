package com.zkdlu.template.spring_kotlin.repository

import com.zkdlu.template.spring_kotlin.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int>{
}