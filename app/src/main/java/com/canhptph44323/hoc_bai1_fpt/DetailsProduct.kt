package com.canhptph44323.hoc_bai1_fpt

import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.motion.utils.ViewSpline.CustomSet
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailsProduct(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        ) {
        Custom(navController)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "Minimal Stand",
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily(Font(R.font.gelasio_bold))
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "\$ 50",
                    fontSize = 30.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                )
                Row(modifier = Modifier.width(113.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    Box(modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color("#E0E0E0".toColorInt())),
                        contentAlignment = Alignment.Center) {
                        Image(painter = painterResource(id = R.drawable.add),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp))
                    }
                    Text(
                        text = "01",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                    )
                    Box(modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color("#E0E0E0".toColorInt())),
                        contentAlignment = Alignment.Center) {
                        Image(painter = painterResource(id = R.drawable.apart),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp))
                    }
                }
            }
            Row(modifier = Modifier.width(200.dp), verticalAlignment = Alignment.CenterVertically)
            {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "4.5",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                    modifier = Modifier.padding(start = 15.dp).clickable {
                        navController.navigate("rating")
                    }
                )
                Text(
                    text = "(50 review)",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                    modifier = Modifier.padding(10.dp)
                )
            }
            Text(
                text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
                fontSize = 15.sp,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight(600),
                color = Color("#606060".toColorInt()),
                fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
            )
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Row(modifier = Modifier.size(60.dp)
                    .shadow(elevation = 2.dp, RoundedCornerShape(8.dp))
                    .background(color = Color("#F5F5F5".toColorInt())),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                    ) {
                    Image(painter = painterResource(id = R.drawable.marker),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp))
                }
                Box(
                    modifier = Modifier.padding(7.dp)
                        .width(270.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = Color(0xFF242424))
                        .clickable(onClick = {
                            navController.navigate("cart")
                        })
                ) {
                    Row(modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = "ADD To Cart",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
                        )
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun Custom(navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(390.dp)) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(390.dp),
                horizontalArrangement = Arrangement.End) {
                Image(
                    painter = painterResource(id = R.drawable.imagedetails),
                    contentDescription = null,
                    modifier = Modifier
                        .width(330.dp)
                        .fillMaxHeight()
                        .shadow(elevation = 2.dp, shape = RoundedCornerShape(bottomStart = 52.dp))
                        .zIndex(1f),
                    contentScale = ContentScale.FillBounds,
                )
            }
        }
        Box(modifier = Modifier
            .width(130.dp)
            .fillMaxHeight()) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier
                    .width(45.dp)
                    .clickable { navController.navigateUp() }
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .shadow(
                        elevation = 0.dp,
                        shape = RoundedCornerShape(14.dp),
                        clip = true
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.arrowback),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                        )
                }
                Column(modifier = Modifier
                    .height(192.dp)
                    .shadow(
                        elevation = 4.dp, RoundedCornerShape(40.dp),
                        clip = true
                    )
                    .width(64.dp)
                    .background(Color.White, RoundedCornerShape(40.dp)),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.color1), contentDescription = null, modifier = Modifier.size(34.dp))
                    Image(painter = painterResource(id = R.drawable.color2), contentDescription = null, modifier = Modifier.size(34.dp))
                    Image(painter = painterResource(id = R.drawable.color3), contentDescription = null, modifier = Modifier.size(34.dp))
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCustom() {
    Custom(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun PreviewCustom1() {
    DetailsProduct(navController = rememberNavController())
}