package com.example.repository

import com.example.model.ApiResponse
import com.example.model.Hero

interface HeroRepositoryAlternative {
    /* Dummy Data */
    val heroes: List<Hero>

    suspend fun getAllHeroes(page: Int = 1, limit: Int = 4): ApiResponse
    suspend fun searchHeroes(name: String): ApiResponse
}