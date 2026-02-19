package com.example.newssimulator.data

import com.example.newssimulator.model.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository {

    private val categories = listOf("Sports", "Technology", "Politics")

    fun getNewsStream(): Flow<News> = flow {

        var idCounter = 1

        while (true) {
            delay(2000)

            val news = News(
                id = idCounter,
                title = "Breaking News #$idCounter",
                category = categories.random(),
                content = "Detail berita ke-$idCounter"
            )

            emit(news)
            idCounter++
        }
    }
}
