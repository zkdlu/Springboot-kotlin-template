package com.zkdlu.template.spring_kotlin.model.request

import com.zkdlu.template.spring_kotlin.interfaces.EntityDao
import com.zkdlu.template.spring_kotlin.model.entity.User
import com.zkdlu.template.spring_kotlin.interfaces.EntityVO as EntityVO

data class UserVO(val id:Int, val name:String, val password:String) : EntityVO {

    override fun convertToDao(): EntityDao {
        return User(id, name, password)
    }
}