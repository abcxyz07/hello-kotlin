package com.mm.kotlinapp.domain


public interface Command<T> {

    fun execute(): T
}