package org.fretron.kafka.model

class User {

    private var firstName: String = ""
    private var age: Int = 0

    constructor()

    constructor(firstName: String, age: Int) {
        this.firstName = firstName
        this.age = age
    }

    override fun toString(): String {
        return "User(${this.firstName}, ${this.age})"
    }

    fun getFirstName(): String = this.firstName

    fun setFirstName(firstName: String) {
        this.firstName = firstName
    }

    fun getAge(): Int = this.age

    fun  setAge(age: Int) {
        this.age = age
    }

}