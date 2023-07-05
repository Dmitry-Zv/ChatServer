package com.example.plugins

import com.example.room.RoomController
import com.example.routes.chatSocketRoute
import com.example.routes.getAllMessages
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocketRoute(roomController)
        getAllMessages(roomController)
    }
}
