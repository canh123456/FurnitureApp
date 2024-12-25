package com.canhptph44323.hoc_bai1_fpt

import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.util.Log
import android.widget.RemoteViews.RemoteCollectionItems
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.canhptph44323.hoc_bai1_fpt.Model.Product
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.ViewUtils.RelativePadding
import java.nio.channels.Selector

enum class ROUTE_HOME_SCREEN{
    Home,
    Favorite,
    Notifications,
    Profile
}

class Category(val icon: Int, val name: String)
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Home_FurnitureApp(navHostController: NavController){
    val navController = rememberNavController()
    val item = listOf(
        BottomNavigationItem(ROUTE_HOME_SCREEN.Home.name,Icons.Default.Home,Icons.Outlined.Home),
        BottomNavigationItem(ROUTE_HOME_SCREEN.Favorite.name,Icons.Default.Favorite,Icons.Outlined.Favorite),
        BottomNavigationItem("Notification",Icons.Default.Notifications,Icons.Outlined.Notifications),
        BottomNavigationItem(ROUTE_HOME_SCREEN.Profile.name,Icons.Default.Person,Icons.Outlined.Person)
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
        ) {
        Scaffold(
            topBar ={
                    TopAPPBar(navController =navController ,navHostController = navHostController)
            },
            bottomBar ={
                    BottomNavigationBar(
                        items = item,
                        selectedItemIndex = selectedItemIndex,
                        onItemSelected ={ index ->
                                selectedItemIndex =index
                            navController.navigate(item[index].tile)
                        }
                    )
            }
        ) { innerPadding ->
                NavigationGraph(navHostController = navHostController, navController = navController , innnerPadding = innerPadding)
        }
    }//
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) ->Unit
){
    NavigationBar(
        containerColor =Color("#ffffff".toColorInt())
    ) {
        items.forEachIndexed{index, item ->
            NavigationBarItem(
                selected =selectedItemIndex == index,
                onClick = { onItemSelected(index)},
                icon = {
                        Icon(
                            imageVector =if (selectedItemIndex == index)item.selectorIcon else item.unselectItem,
                            contentDescription = item.tile,
                            modifier = Modifier.size(24.dp)
                        )
                },
                colors =NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.black ),
                    unselectedIconColor = Color.Gray
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAPPBar(navController: NavHostController, navHostController: NavController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "Home"
    val hometile = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                    fontSize = 17.sp
            )
        ){
            append("Make home\n ")
        }
        withStyle(
            style = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                fontSize = 20.sp
            )
        ){
            append("BEAUTIFULL")
        }
    }
    val tile: Any = when(currentRoute){
        "Home" -> hometile
        "Favorite" -> "Favorite"
        "Notifications" -> "Notifications"
        "Profile" -> "Profile"
        else -> "Home FurnitureApp"
    }
    TopAppBar(
        title ={
            if (tile is AnnotatedString){
                Text(
                    text = tile,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            if(tile is String){
                Text(
                    text = tile,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize(),
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                )
            }
        },
        actions = {
            IconButton(onClick = {navHostController.navigate("cart")}) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription =null,
                    modifier = Modifier.size(25.dp)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id= R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    )
}

@Composable
fun NavigationGraph(navHostController: NavController, navController: NavHostController, innnerPadding: PaddingValues){
    NavHost (
            navController,
            startDestination =ROUTE_HOME_SCREEN.Home.name,
            modifier = Modifier.padding(innnerPadding)
    ){
        composable(ROUTE_HOME_SCREEN.Home.name){ HomeScreen(innnerPadding,navHostController) }
        composable(ROUTE_HOME_SCREEN.Favorite.name){ FavoriteScreen(innnerPadding) }
        composable(ROUTE_HOME_SCREEN.Notifications.name){ NotificationScreen(innnerPadding) }
        composable(ROUTE_HOME_SCREEN.Profile.name){ AccountScreenControl(innnerPadding,navController) }
    }
}

data class BottomNavigationItem(
    val tile: String,
    val selectorIcon: ImageVector,
    var unselectItem: ImageVector
)

@Composable
fun HomeScreen(innnerPadding: PaddingValues = PaddingValues(),navController: NavController){
        val categoryArr = listOf(
            Category(R.drawable.cart,"chair"),
            Category(R.drawable.cart,"table"),
            Category(R.drawable.cart,"armchair"),
            Category(R.drawable.cart,"bad"),
            Category(R.drawable.cart,"table"),
            Category(R.drawable.cart,"chair"),
            Category(R.drawable.cart,"bad"),
        )
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.padding(
        top = 10.dp,
        start = 15.dp,
        end = 15.dp
    )) {
        Row(
            modifier = Modifier.fillMaxSize()
                .horizontalScroll(scrollState)
        ) {
            categoryArr.forEach{ category ->
                CategoryItem(icon = category.icon, name = category.name)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth(),
            ) {
            items(productarr.chunked(2)) {productRow ->
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                    val chunkedList = productarr.chunked(2)
                    Log.d("Debug", "Chunked List Size: ${chunkedList.size}") // Kiểm tra danh sách
                    for (product in productRow){
                        ProductItem(
                            image = product.image,
                            name = product.name,
                            price = product.price,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItem(icon: Int,name: String){
    Column(
        modifier = Modifier.padding(end = 25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .size(44.dp)
            .shadow(elevation = 2.dp, RoundedCornerShape(14.dp))
            .background(color = Color("#F5F5F5".toColorInt())),
            verticalAlignment =Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = name,
            fontSize = 14.sp,
            color = Color("#999999".toColorInt()),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light))
        )
    }
}

val productarr= listOf(
    Product(R.drawable.image1 , "Black Simple Lamp",12.0),
    Product(R.drawable.image2, "Black Simple Lamp",12.0),
    Product(R.drawable.image3 , "Black Simple Lamp",12.0),
    Product(R.drawable.imagedetails , "Black Simple Lamp",12.0),
    Product(R.drawable.image3 , "Black Simple Lamp",12.0),
    Product(R.drawable.image3 , "Black Simple Lamp",12.0)
)

@Composable
fun ProductItem(image: Int , name: String,price: Double, navController: NavController ){
    Column(modifier = Modifier.width(150.dp)
        .height(230.dp)
        .clickable { navController.navigate("detail") },
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(modifier = Modifier.fillMaxWidth()
            .height(200.dp)
        ) {
            Image(modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = image),
                contentDescription = null
                )
            Column(modifier = Modifier.fillMaxSize()
                .padding(bottom = 10.dp, end = 15.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Row(modifier = Modifier.size(30.dp)
                    .shadow(elevation = 2.dp, RoundedCornerShape(6.dp))
                    .background(color = Color("#95a5a6".toColorInt()))
                    .alpha(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement =Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shopping_bag),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
        Text(
            text = name,
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
        )
        Text(
            text = "\$" + price,
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Home_FurnitureAppPreview() {
    val mockNavController = rememberNavController() // Khởi tạo một NavController giả
    Home_FurnitureApp(navHostController = mockNavController)
//    val mockNavController = rememberNavController()
//    HomeScreen(navController = mockNavController)
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//
//}
