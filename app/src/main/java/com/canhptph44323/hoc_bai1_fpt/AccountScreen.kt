package com.canhptph44323.hoc_bai1_fpt

import android.os.Message
import android.service.quicksettings.Tile
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AccountScreenControl(innerPaddingValues: PaddingValues,navController: NavController){
    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color("#f5f6fa".toColorInt()))) {
        Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            Row(modifier = Modifier.fillMaxWidth().height(80.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.avatar), contentDescription = null, modifier = Modifier.size(80.dp))
                Spacer(modifier = Modifier.height(15.dp))
                Column {
                    Text(
                        text = "Canh Pham",
                        fontSize = 22.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                        modifier = Modifier.padding(start = 20.dp)
                    )
                    Text(
                        text = "bruno203@gmail.com", fontSize = 15.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column {
                MethodAccount(title = "My Oder", message = "Already have 10 orders",
                    click = {navController.navigate("order")})
                Spacer(modifier = Modifier.height(15.dp))
                MethodAccount(title = "Shipping Addresses", message = "03 Addresses",
                    click = {navController.navigate("selectShipment")})
                Spacer(modifier = Modifier.height(15.dp))
                MethodAccount(title = "Payment Method", message = "You have 2 cards",
                    click = {navController.navigate("paymentMethod")})
                Spacer(modifier = Modifier.height(15.dp))
                MethodAccount(title = "My reviews", message = "Reviews for 5 items",
                    click = {navController.navigate("myReview")})
                Spacer(modifier = Modifier.height(15.dp))
                MethodAccount(title = "Setting", message = "Notification, Password, FAQ, Contact",
                    click = {navController.navigate("setting")})
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun MethodAccount(title: String,message: String, click: () ->Unit){
    Row(modifier = Modifier
        .height(85.dp)
        .fillMaxWidth()
        .clickable(onClick = click)
        .shadow(elevation = 1.dp, shape =  RoundedCornerShape(8.dp))
        .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))
        .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier.fillMaxSize()
            .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
//            Row(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(15.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {  }
            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                )
                Text(
                    text = message,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
            Image(painter = painterResource(id = R.drawable.back), contentDescription = null, modifier = Modifier.size(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAccount() {
    AccountScreenControl(
        innerPaddingValues = PaddingValues(0.dp),
        navController = rememberNavController()
    )
}