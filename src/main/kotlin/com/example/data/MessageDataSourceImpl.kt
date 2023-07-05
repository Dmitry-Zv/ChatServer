package com.example.data

import com.example.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
    database: CoroutineDatabase
) : MessageDataSource {

    private val messages = database.getCollection<Message>()

    override suspend fun getAllMessages(): List<Message> =

        messages.find()
            .descendingSort(Message::timestamp)
            .toList()


    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}