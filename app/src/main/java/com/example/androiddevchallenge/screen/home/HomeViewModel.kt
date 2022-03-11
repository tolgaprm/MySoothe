package com.example.androiddevchallenge.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.alignYourBodyCollections
import com.example.androiddevchallenge.data.alignYourMindCollections
import com.example.androiddevchallenge.data.favoriteCollectionsOne
import com.example.androiddevchallenge.data.favoriteCollectionsTwo


class HomeViewModel : ViewModel() {

    private val _homeViewState = mutableStateOf<HomeViewState>(HomeViewState())
    val homeViewState: State<HomeViewState> get() = _homeViewState

    init {
        val favoriteList = favoriteCollectionsOne
        val favoriteListTwo = favoriteCollectionsTwo
        val alignYourBodyCollectionsList = alignYourBodyCollections
        val alignYourMindCollectionList = alignYourMindCollections

        _homeViewState.value = _homeViewState.value.copy(
            favoriteListOne = favoriteList,
            favoriteListTwo = favoriteListTwo,
            alignYourBodyCollections = alignYourBodyCollections,
            alignYourMindCollections = alignYourMindCollections
        )
    }

    fun onChangeSearch(search: String) {

        _homeViewState.value = _homeViewState.value.copy(
            search = search
        )
    }


}