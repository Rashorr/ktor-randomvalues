package com.example.modules

import com.example.repository.RandomValueImpl
import com.example.repository.RandomValueInt
import org.koin.dsl.module

val appModule = module {
    single<RandomValueInt> {
        RandomValueImpl()
    }
}