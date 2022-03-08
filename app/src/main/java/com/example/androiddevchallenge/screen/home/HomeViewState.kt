package com.example.androiddevchallenge.screen.home

import com.example.androiddevchallenge.data.Collection

data class HomeViewState(
    val search: String = "",
    val favoriteListOne: List<Collection> = listOf(),
    val favoriteListTwo: List<Collection> = listOf(),

)