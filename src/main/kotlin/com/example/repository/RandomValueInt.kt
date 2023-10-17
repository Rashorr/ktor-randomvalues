package com.example.repository

import com.example.models.RandomNumber
import com.example.models.RandomParameters
import com.example.models.RandomString
import com.example.models.RandomUUID
import java.util.*

interface RandomValueInt {


    fun getRandomNumber(range1: Int, range2: Int, value: Int) : List<RandomNumber>

    fun getRandomString(length: Int, charset: String, value: Int): List<RandomString>

    fun getRandmUUID(value: Int): List<RandomUUID>

}