package com.example.di

import com.example.repository.HeroRepository
import com.example.repository.HeroRepositoryAlternative
import com.example.repository.HeroRepositoryAlternativeImpl
import com.example.repository.HeroRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImpl()
    }
    single<HeroRepositoryAlternative> {
        HeroRepositoryAlternativeImpl()
    }
}