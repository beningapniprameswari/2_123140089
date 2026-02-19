package com.example.newssimulator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newssimulator.data.NewsRepository
import com.example.newssimulator.model.News
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = NewsRepository()

    // Semua berita masuk ke sini
    private val _allNews = MutableStateFlow<List<News>>(emptyList())

    // Berita yang sudah dibaca
    private val _readNewsIds = MutableStateFlow<Set<Int>>(emptySet())

    // Kategori aktif
    private val _selectedCategory = MutableStateFlow("Sports")
    val selectedCategory: StateFlow<String> = _selectedCategory

    // Counter dibaca
    val readCount: StateFlow<Int> =
        _readNewsIds.map { it.size }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), 0)

    init {
        viewModelScope.launch {
            repository.getNewsStream().collect { news ->
                _allNews.value = _allNews.value + news
            }
        }
    }

    fun changeCategory(category: String) {
        _selectedCategory.value = category
    }

    fun markAsRead(news: News) {
        _readNewsIds.value = _readNewsIds.value + news.id
    }

    // 🔥 Final List yang ditampilkan
    val newsList: StateFlow<List<News>> =
        combine(_allNews, _selectedCategory, _readNewsIds)
        { newsList, category, readIds ->

            newsList
                .filter { it.category == category }          // Filter kategori
                .filter { it.id !in readIds }                // Hilangkan yang sudah dibaca
                .map { it.copy(title = "📰 ${it.title}") }   // Transform
        }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}
