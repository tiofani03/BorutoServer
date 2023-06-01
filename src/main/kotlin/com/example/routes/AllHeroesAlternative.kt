package com.example.routes

import com.example.model.ApiResponse
import com.example.repository.HeroRepository
import com.example.repository.HeroRepositoryAlternative
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroesAlternative() {
    val heroRepository: HeroRepositoryAlternative by inject()

    get("/boruto/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            val limit = call.request.queryParameters["limit"]?.toInt() ?: 4
            val apiResponse = heroRepository.getAllHeroes(
                page = page,
                limit = limit,
            )

            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK,
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only number allowed"),
                status = HttpStatusCode.BadRequest,
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Heroes not found"),
                status = HttpStatusCode.NotFound
            )
        }
    }
}