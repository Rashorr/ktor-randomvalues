package com.example.repository

import com.example.models.RandomNumber
import com.example.models.RandomParameters
import com.example.models.RandomString
import com.example.models.RandomUUID
import java.util.UUID

class RandomValueImpl : RandomValueInt {


    override fun getRandomNumber(range1: Int, range2: Int, value: Int): List<RandomNumber> {
        val randNumberlist = mutableListOf<RandomNumber>()

        for (i in 1..value) {
            val randomInt = (range1..range2).random()
            val randomNumber = RandomNumber(randomInt)
            randNumberlist.add(randomNumber)
        }
        return randNumberlist
    }

    override fun getRandomString(length: Int, charset: String, value: Int): List<RandomString> {
        val randomStringlist = mutableListOf<RandomString>()
        for (i in 1..value) {
            val randomStringValue = (1..length).map { charset.random() }.joinToString("")
            val randomString = RandomString(randomStringValue)
            randomStringlist.add(randomString)
        }
        return randomStringlist
    }

    override fun getRandmUUID(value: Int): List<RandomUUID> {
        val randomUUIDlist = mutableListOf<RandomUUID>()
        for (i in 1..value) {
            val randomUUIDvalue = UUID.randomUUID().toString()
            val randomUUID = RandomUUID(randomUUIDvalue)
            randomUUIDlist.add(randomUUID)
        }
        return randomUUIDlist
    }
}