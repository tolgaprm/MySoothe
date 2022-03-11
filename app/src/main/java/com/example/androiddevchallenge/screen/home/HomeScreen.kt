package com.example.androiddevchallenge.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.AlignYourRow
import com.example.androiddevchallenge.components.FavoriteCollectionRow
import com.example.androiddevchallenge.components.MySootheTextField
import com.example.androiddevchallenge.components.TitleText

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel()
) {

    HomeScreenContent(homeViewModel = homeViewModel)

}

@Composable
fun HomeScreenContent(homeViewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {

        SearchSection(homeViewModel)

        FavoriteCollectionsSection(homeViewModel)

        Spacer(modifier = Modifier.height(56.dp))

        AlignYourBodySection(homeViewModel)

        Spacer(modifier = Modifier.height(56.dp))

        AlignYourMindSection(homeViewModel)
    }
}

@Composable
fun SearchSection(homeViewModel: HomeViewModel) {
    MySootheTextField(
        modifier = Modifier
            .padding(top = 56.dp)
            .fillMaxWidth(),
        value = homeViewModel.homeViewState.value.search,
        onValueChange = homeViewModel::onChangeSearch,
        placeholder = {
            Text(
                text = stringResource(R.string.home_search),
                style = MaterialTheme.typography.body1,

                )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search, contentDescription = stringResource(
                    id = R.string.home_search
                ),
                modifier = Modifier.size(18.dp)
            )
        }

    )
}

@Composable
fun FavoriteCollectionsSection(homeViewModel: HomeViewModel) {

    TitleText(
        titleResourceId = R.string.home_fav_collect,
        modifier = Modifier.paddingFromBaseline(40.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))

    FavoriteCollectionRow(collection = homeViewModel.homeViewState.value.favoriteListOne)

    Spacer(modifier = Modifier.height(8.dp))

    FavoriteCollectionRow(collection = homeViewModel.homeViewState.value.favoriteListTwo)


}

@Composable
fun AlignYourBodySection(homeViewModel: HomeViewModel) {
    TitleText(titleResourceId = R.string.home_align_your_body)

    AlignYourRow(collectionList = homeViewModel.homeViewState.value.alignYourBodyCollections)
}

@Composable
fun AlignYourMindSection(homeViewModel: HomeViewModel) {
    TitleText(titleResourceId = R.string.home_align_your_mind)

    AlignYourRow(collectionList = homeViewModel.homeViewState.value.alignYourMindCollections)
}