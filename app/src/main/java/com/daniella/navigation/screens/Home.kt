package com.daniella.navigation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.daniella.navigation.nav.HomeTab
import com.daniella.navigation.nav.HomeTab.Home
import com.daniella.navigation.nav.HomeTab.Payments
import com.daniella.navigation.nav.HomeTab.Products
import com.daniella.navigation.nav.HomeTab.Settings

@Composable
fun HomeScreen(){
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(0) }


    val tabs = listOf(HomeTab.Home, HomeTab.Products, HomeTab.Payments, HomeTab.Settings)

    Scaffold (bottomBar = {
        NavigationBar {
    tabs.forEachIndexed{index,tab ->
        NavigationBarItem(
            icon = {
                Icon(imageVector =  tab.icon,contentDescription = null)
                   },
            label = { Text(text = tab.title) },
            selected = selectedTab == index,
            onClick = {selectedTab = index })
    }
    }
//        }
    }
    )
    { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                0 -> HomeContent()
                1 -> ProductsContent()
                2 -> PaymentsContent()
                3 -> SettingsContent()
            }
        }





    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
        Text(text = "HOME" , fontWeight = FontWeight.Bold, fontSize = 20.sp)
    }
}
}




@Composable
fun HomeContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home")
    }
}

@Composable
fun ProductsContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Product")
    }
}

@Composable
fun PaymentsContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Payment")
    }
}

@Composable
fun SettingsContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Settings")
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}