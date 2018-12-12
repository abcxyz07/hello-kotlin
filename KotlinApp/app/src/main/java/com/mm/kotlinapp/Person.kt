package com.mm.kotlinapp


public class Person {

    var name: String = ""

    get() = field.toUpperCase();
    set(value){
        field = "Name, $value"
    }
}