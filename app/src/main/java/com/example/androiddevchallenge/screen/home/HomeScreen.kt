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
import com.example.androiddevchallenge.components.FavoriteCollectionRow
import com.example.androiddevchallenge.components.MySootheTextField

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
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


        FavoriteCollectionsSection(homeViewModel)


    }


}

@Composable
fun FavoriteCollectionsSection(homeViewModel: HomeViewModel) {
    Text(
        text = stringResource(R.string.home_fav_collect).uppercase(),
        style = MaterialTheme.typography.h2,
        modifier = Modifier.paddingFromBaseline(40.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))

    FavoriteCollectionRow(collection = homeViewModel.homeViewState.value.favoriteListOne)

    Spacer(modifier = Modifier.height(8.dp))

    FavoriteCollectionRow(collection = homeViewModel.homeViewState.value.favoriteListTwo)

}