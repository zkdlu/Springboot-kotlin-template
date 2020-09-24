package com.zkdlu.template.spring_kotlin.model.entity

import com.zkdlu.template.spring_kotlin.interfaces.EntityDao
import com.zkdlu.template.spring_kotlin.interfaces.EntityVO
import com.zkdlu.template.spring_kotlin.model.request.UserVO
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id:Int,
        @Column(length = 100, nullable = false) var name:String,
        @Column(length = 255, nullable = false) var password:String) : EntityDao {

    override fun convertToVO(): EntityVO {
        return UserVO(id, name, password)
    }
}