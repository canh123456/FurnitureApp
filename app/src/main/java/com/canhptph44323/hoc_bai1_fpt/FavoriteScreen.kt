package com.canhptph44323.hoc_bai1_fpt

import android.graphics.drawable.Icon
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
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.compose.rememberNavController
import com.canhptph44323.hoc_bai1_fpt.Model.Product

@Composable
fun FavoriteScreen(innerPadding: PaddingValues) {
    Column(modifier = Modifier) {
        FavoriteGrid(productArr = productarr)

    }
}

@Composable
fun FavoriteItem(icon: Int , name: String, price:Double){
    Row(modifier = Modifier.fillMaxWidth().height(110.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Image(painter = painterResource(id= icon), contentDescription = null,
            modifier = Modifier.width(140.dp).height(200.dp).padding(start = 15.dp)
                .shadow(elevation = 2.dp, shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillBounds)
        Column(modifier = Modifier.width(150.dp).fillMaxHeight()
            .padding(start = 20.dp),
            horizontalAlignment = Alignment.Start) {
            Text(
                text = name,
                fontSize = 15.sp, fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "\$ " + price,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                color = Color.DarkGray
            )
        }
        Column(modifier = Modifier.fillMaxHeight().width(50.dp)
            .padding(end = 20.dp, top = 0.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = AbsoluteAlignment.Right) {
            Icon(painter = painterResource(id = R.drawable.delete), contentDescription = null,
                modifier = Modifier.size(20.dp))
            Row(modifier = Modifier.size(25.dp).clip(shape = RoundedCornerShape(6.dp))
                .background(color = Color("#E0E0E0".toColorInt()))
                .padding()
                .clickable {  },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Icon(painter = painterResource(id = R.drawable.bag), contentDescription = null, modifier = Modifier.size(20.dp))
            }
        }
    }
}

@Composable
fun FavoriteGrid(productArr : List<Product>){
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()
            , contentPadding = PaddingValues(10.dp)
        ) {
            items(productArr){productRow ->
                FavoriteItem(
                    name = productRow.name,
                    icon = productRow.image,
                    price = productRow.price
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(color = colorResource(id = R.color.graySecond), thickness = 0.5.dp,
                    modifier = Modifier.padding(start = 15.dp, end = 15.dp))
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Box(modifier = Modifier.fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
            contentAlignment = Alignment.BottomCenter) {
            CustomButton(
                title = "Add all to my cart", modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF242424))
                    .clickable(onClick = {}),
                    textStyle = TextStyle(
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                    fontWeight = FontWeight(600),
                    fontSize = 17.sp
                )
            )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewFavoriteItem() {
//    FavoriteItem(
//        icon = R.drawable.image3, // Thay bằng icon resource trong project
//        name = "Sample Product",
//        price = 99.99
//    )
    FavoriteScreen(innerPadding = PaddingValues())

}