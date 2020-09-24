package com.zkdlu.template.spring_kotlin.interfaces

import org.springframework.web.bind.annotation.*

interface CrudController<TEntity, TKey> {
    @PostMapping
    fun create(@RequestBody model:TEntity): Boolean

    @GetMapping
    fun read(): List<TEntity>

    @PutMapping("/{key}")
    fun update(@PathVariable key:TKey, @RequestBody model:TEntity):TEntity?

    @DeleteMapping("/{key}")
    fun delete(@PathVariable key:TKey):Boolean

    @GetMapping("/{key}")
    fun readOne(@PathVariable key:TKey):TEntity?
}