package com.daniella.navigation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daniella.navigation.Payment
import com.daniella.navigation.nav.HomeTab
import com.daniella.navigation.nav.HomeTab.Home
import com.daniella.navigation.nav.HomeTab.Payments
import com.daniella.navigation.nav.HomeTab.Products
import com.daniella.navigation.nav.HomeTab.Settings
import com.daniella.navigation.nav.Screen

@Composable
fun HomeScreen(rootNavController: NavHostController){
    val navController = rememberNavController()

//    Determines the tab that is currently being shown
    var selectedTab by remember { mutableStateOf(0) }


    val tabs = listOf(Home, Products, Payments, Settings)


//    Does the measurements for the different screen sizes and are responsive
    Scaffold (bottomBar = {
        NavigationBar {
    tabs.forEachIndexed{index,tab ->
        NavigationBarItem(
            icon = {
                Icon(imageVector =  tab.icon,contentDescription = null)
                   },
//            Displays title of the current tab
            label = { Text(text = tab.title) },
            onClick = {selectedTab = index },
            selected = selectedTab == index,
            colors = NavigationBarItemColors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.Blue,
                selectedIndicatorColor = Color.Magenta,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
                disabledIconColor = Color.Gray,
                disabledTextColor = Color.Gray,
            )
            )

    }
    }
//        }
    }
    )
//    Here we define the body of our screen
    { paddingValues ->
//        Box displays an item on top of another
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {

//                When the tab number is the number display the screen

                0 -> HomeContent()
                1 -> ProductsContent()
                2 -> PaymentsContent()
                3 -> SettingsContent(rootNavController)
//                Must have this to help to navigate out
            }
        }





//    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
//        Text(text = "HOME" , fontWeight = FontWeight.Bold, fontSize = 20.sp)
//    }
}
}



//They are tabs but each is a screen on its own so they need to be in separate functions

@Composable
fun HomeContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "HOME")

        val friends = listOf("Daniella", "Geremy","Hellen","Charles", "Diana")
        LazyVerticalGrid(GridCells.Fixed(2))  { items (friends) { friend -> Text(text = " $friend ")  } }
    }
}

@Composable
fun ProductsContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "PRODUCTS")
    }
}

@Composable
fun PaymentsContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "PAYMENTS")
        val payments = listOf(
            Payment(incoming = false,
                amount = 2000.0,
                narration = "Lunch",
                date = "30th June 2025"
            ),


        Payment(incoming = false,
            amount = 2000.0,
            narration = "Lunch",
            date = "1st July 2025"
        ),

        Payment(incoming = true,
            amount = 200.0,
            narration = "Per diem",
            date = "2nd July 2025"
        ),

        Payment(incoming = true,
            amount = 200000.0,
            narration = "Salary",
            date = "2nd July 2025"
        ),

        Payment(incoming = false,
            amount = 2000.0,
            narration = "Laundry",
            date = "3rd July 2025")
        )
        LazyColumn (verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(payments){payment -> PaymentCard(payment) }
        }
    }
}

@Composable
fun SettingsContent(rootNavController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "SETTINGS")
        Spacer(Modifier.height(32.dp))

        Button(onClick = {rootNavController.navigate(Screen.Login.route)}) {
            Text(text = "Log Out")
        }
    }

    
}

@Composable
fun PaymentCard(payment: Payment){
    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
        containerColor = Color.White
    ) ,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp,Color.LightGray)

        ){
        Row (modifier = Modifier.padding(16.dp, 8.dp)){
            if(payment.incoming){
                Icon(imageVector = Icons.Default.ArrowUpward,
                    contentDescription = "",
                    tint = Color.Green,
                    modifier = Modifier.size(64.dp)
                )
            }else{
                Icon(imageVector = Icons.Default.ArrowDownward,
                    contentDescription = "",
                    tint = Color.Red,
                    modifier = Modifier.size(64.dp))
            }
//            
            
            Spacer(Modifier.width(16.dp))
            Column {
                Text(text = payment.narration, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "${payment.amount}/-")
                Text(text = payment.date)
                
            }
        }
    }
}


//@Composable
//fun HomeNavigation(navController: NavHostController)
//{
//    NavHost(navController = navController,
//        startDestination = HomeTab.Home.route){
//        composable(HomeTab.Home.route){
//            HomeContent() }
//    }
//
//
//
//}

@Preview(showBackground = true)
@Composable
fun PaymentCardScreen(){
    val payment = Payment(incoming = false, amount = 10000.0, narration = "Shoes", date = "25th June 2025")
    PaymentCard(payment = payment)
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}


