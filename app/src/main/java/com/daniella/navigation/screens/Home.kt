package com.daniella.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
        Text(text = "HOME" , fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }
}






@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}