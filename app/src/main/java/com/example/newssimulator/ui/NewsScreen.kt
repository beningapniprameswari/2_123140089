package com.example.newssimulator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.newssimulator.model.News

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(viewModel: NewsViewModel) {

    val newsList by viewModel.newsList.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val readCount by viewModel.readCount.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("News Simulator") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            // 🔹 Counter berita dibaca
            Text(
                text = "Berita dibaca: $readCount",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 Filter Kategori
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                listOf("Sports", "Technology", "Politics").forEach { category ->

                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = {
                            viewModel.changeCategory(category)
                        },
                        label = {
                            Text(category)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 List Berita
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {

                items(newsList) { news ->
                    NewsItem(news = news, viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun NewsItem(
    news: News,
    viewModel: NewsViewModel
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        onClick = {
            viewModel.markAsRead(news)
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = news.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Kategori: ${news.category}"
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = news.content
            )
        }
    }
}
