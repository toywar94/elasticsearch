package com.project.pattern

import org.springframework.stereotype.Service

@Service
class KotlinTest {


    fun sumTest(){
        val a: Int = 10
        val b: Int = 5
        val result = sum(a, b);

    }

    private fun sum(a: Int, b: Int) : Int{
        return a+b
    }

}