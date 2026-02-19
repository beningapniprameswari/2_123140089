package com.example.newssimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newssimulator.ui.NewsScreen
import com.example.newssimulator.ui.NewsViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: NewsViewModel = viewModel()
            NewsScreen(viewModel)
        }
    }
}
