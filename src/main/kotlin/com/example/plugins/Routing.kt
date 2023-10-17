package com.example.plugins

import com.example.models.RandomParameters
import com.example.repository.RandomValueInt
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.routing.get
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.buildJsonArray
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val repo by inject<RandomValueInt>()
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        static("/static"){
            resources("files")
        }
        get("/") {
            val range1 = call.request.queryParameters["r1"]?.toInt()
            val range2 = call.request.queryParameters["r2"]?.toInt()
            var value = call.request.queryParameters["value"]?.toInt()
            val length = call.request.queryParameters["length"]?.toInt()
            val charset = call.request.queryParameters["charset"]?.toString()


            if (range1 != null && range2 != null) {
                if (value == null) {
                    val randNumb = repo.getRandomNumber(range1, range2, value = 1)
                    call.respond(HttpStatusCode.OK, randNumb)
                } else {
                    val randNumb = repo.getRandomNumber(range1, range2, value)
                    call.respond(HttpStatusCode.OK, randNumb)
                }
            } else if (length != null && charset != null) {
                if (value == null) {
                    val randString = repo.getRandomString(length, charset, value = 1)
                    call.respond(HttpStatusCode.OK, randString)
                } else {
                    val randString = repo.getRandomString(length, charset, value)
                    call.respond(HttpStatusCode.OK, randString)
                }


            }

        }

        get("/UUID") {

            var value = call.request.queryParameters["value"]?.toInt()
            if (value == null) {
                val randUUID = repo.getRandmUUID(value = 1)
                call.respond(HttpStatusCode.OK, randUUID)
            } else {
                val randUUID = repo.getRandmUUID(value!!)
                call.respond(HttpStatusCode.OK, randUUID)
            }
        }
        get("/Test"){
            call.respondText("Hello World!", status = HttpStatusCode.OK)
        }
    }
}
