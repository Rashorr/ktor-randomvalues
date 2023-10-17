package com.example

import com.example.modules.appModule
import com.example.modules.testModule
import com.example.plugins.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import org.koin.ktor.plugin.Koin
import kotlin.test.*

class ApplicationTest {

    @Test
    fun testGetRandomNumber() =
        testApplication {
            setupTest()
            val range1 = 1
            val range2 = 10

            val response = client.get( "/?r1=$range1&r2=$range2")
            assertEquals(HttpStatusCode.OK, response.status)
        }

    @Test
    fun getRandomString() =
        testApplication {
            setupTest()
            val length = 10
            val charset = "adgsdföosidf2394723b"

            val response = client.get("/?length=$length&charset=$charset")
            assertEquals(HttpStatusCode.OK, response.status)
        }

    @Test
    fun getUUID() = testApplication {
        setupTest()
        val response = client.get("/UUID")
        assertEquals(HttpStatusCode.OK, response.status)
    }



    private fun ApplicationTestBuilder.setupTest(){
        application {
            install(Koin){
                modules(testModule)
            }
            install(ContentNegotiation){
                json()
            }
            configureRouting()
        }
    }
}
