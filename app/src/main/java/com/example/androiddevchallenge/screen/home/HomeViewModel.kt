package com.example.androiddevchallenge.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Collection
import com.example.androiddevchallenge.data.favoriteCollectionsOne
import com.example.androiddevchallenge.data.favoriteCollectionsTwo


class HomeViewModel : ViewModel() {

    private val _homeViewState = mutableStateOf<HomeViewState>(HomeViewState())
    val homeViewState: State<HomeViewState> get() = _homeViewState

    init {
        val favoriteList = favoriteCollectionsOne
        val favoriteListTwo = favoriteCollectionsTwo
        _homeViewState.value = _homeViewState.value.copy(
            favoriteListOne = favoriteList,
            favoriteListTwo = favoriteListTwo
        )
    }

    fun onChangeSearch(search: String) {

        _homeViewState.value = _homeViewState.value.copy(
            search = search
        )
    }


}