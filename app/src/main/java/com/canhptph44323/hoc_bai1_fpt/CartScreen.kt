package com.canhptph44323.hoc_bai1_fpt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.canhptph44323.hoc_bai1_fpt.Model.Product

@Composable
fun CartScreen(innerPadding: PaddingValues, navHostController: NavController){
    Column(modifier = Modifier.fillMaxSize()
        .padding(start = 10.dp, innerPadding.calculateTopPadding(), end = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween)
    {
        CartGrid(productArr = productarr)
        Column(modifier = Modifier
            .fillMaxWidth().height(170.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Box(modifier = Modifier.fillMaxWidth().padding(end = 10.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                TextField(
                    placeholder = {
                        Text(
                            text = "Enter your promo code",
                            color = Color("#999999".toColorInt()),
                            fontSize =16.sp,
                            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                            fontWeight = FontWeight(600)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = {

                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#E0E0E0".toColorInt()),
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                    ),
                )
                    Row(modifier = Modifier
                        .size(45.dp)
                        .shadow(elevation = 2.dp, RoundedCornerShape(14.dp))
                        .background(color = Color("#303030".toColorInt())),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center) {
                        Image(painter = painterResource(id = R.drawable.arrownext),
                            contentDescription = null,
                            modifier = Modifier.size(22.dp))
                    }
            }
            Row(modifier = Modifier.fillMaxWidth()
                .padding(start = 15.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Total :",
                    fontSize = 23.sp,
                    fontWeight = FontWeight(700),
                    color = Color("#808080".toColorInt()),
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                )
                Text(
                    text = "\$ 95.00",
                    fontSize = 23.sp,
                    fontWeight = FontWeight(700),
                    color = Color("#000000".toColorInt()),
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                )
            }
            Box(modifier = Modifier.padding(7.dp)
                .fillMaxWidth().height(8.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color(0xFF242424))
                .clickable(onClick = {
                    navHostController.navigate("checkout")
                })
                ){
                Row(modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Check Box",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                        fontWeight= FontWeight(600),
                    )
                }
            }
        }
    }
}

@Composable
fun CartItem(icon: Int, name: String, price: Double){
    Row(modifier = Modifier.fillMaxWidth().height(110.dp)
        .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier
            .width(110.dp)
            .height(120.dp), contentScale = ContentScale.FillBounds)
        Column(modifier =  Modifier
            .width(200.dp)
            .padding(10.dp).fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                    Text(
                        text = name,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                        color = colorResource(R.color.gray)
                    )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "\$"+ price,
                    fontSize =16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                    color = colorResource(R.color.black)
                )
            }
            Row(modifier = Modifier.width(113.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier.size(30.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = Color("#E0E0E0".toColorInt())),
                    contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                }
                Text(
                    text = "01",
                    fontSize =18.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                    color = Color.Black
                )
                Box(modifier = Modifier.size(30.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = Color("#E0E0E0".toColorInt())),
                    contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.apart),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }
        Column(modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.delete),
                contentDescription = null,
                modifier = Modifier.size(24.dp))
        }
    }
}

@Composable
fun CartGrid(productArr : List<Product>){
    LazyColumn(modifier = Modifier.fillMaxWidth().height(500.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(productArr) {productRow ->
            CartItem(icon = productRow.image, name = productRow.name, price = productRow.price)
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = colorResource(id = R.color.graySecond), thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppCart(navHostController: NavController){
    Scaffold(
        topBar ={
            TopAppBar(
                colors =TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title ={
                    Text(
                        text = "My Cart",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = FontFamily(Font(R.font.merriweather_regular)),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navHostController.navigateUp()
                        }
                    ) {
                        Icon(painter = painterResource(R.drawable.arrowback),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp))
                    }
                },
                actions ={
                    IconButton(modifier = Modifier.size(24.dp),
                        onClick = {}) { }
                }
            )
        }
    ) { innerPadding ->
        CartScreen(innerPadding = innerPadding , navHostController = navHostController)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCartScreen() {
    CartScreen(
        innerPadding = PaddingValues(0.dp),
        navHostController = rememberNavController()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSmallTopAppCart() {
    SmallTopAppCart(
        navHostController = rememberNavController()
    )
}

