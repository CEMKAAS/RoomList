package com.zaroslikov.roomlist.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel
import com.zaroslikov.roomlist.data.AddTable
import kotlinx.coroutines.launch

@Composable
fun List (
    viewModel: MainViewModel = viewModel(factory = MainViewModel.factory)
) {
    val scope = rememberCoroutineScope()
    val homeState by viewModel.itemNeco().collectAsState(initial = emptyList())
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Button(onClick = {
                scope.launch {
                    viewModel.insertNeco()
                }
            }) {
                Text(text = "sd")
            }
        }
        items(homeState) { itemsList ->
            AddProductCard(addProduct = itemsList)
        }
    }
}


@Composable
fun AddProductCard(
    addProduct: AddTable
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Text(
                text = addProduct.title,
                modifier = Modifier
                    .fillMaxWidth(0.16f)
                    .padding(6.dp),
                fontWeight = FontWeight.SemiBold,
            )

            Text(
                text = "${addProduct.count} шт.",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .padding(6.dp),
                fontWeight = FontWeight.Black,
                fontSize = 18.sp
            )
        }
    }
}
