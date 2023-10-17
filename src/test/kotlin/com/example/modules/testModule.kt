package com.example.modules

import TestRepository
import com.example.repository.RandomValueImpl
import com.example.repository.RandomValueInt
import org.koin.dsl.module

val testModule = module {
    single<RandomValueInt> {
        TestRepository()
    }
}