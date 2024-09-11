@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.superheroes

import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.HeroRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                Surface(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
                    SuperHeroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroesApp() {
    Scaffold(
        topBar = {
            SuperHeroTopAppBar()
        }
    ) {
        HeroesScreen().SuperHeroList(
            modifier = Modifier.padding(it),
            heroes = HeroRepository.heroes
        )
    }
}

@Composable
fun SuperHeroTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}
