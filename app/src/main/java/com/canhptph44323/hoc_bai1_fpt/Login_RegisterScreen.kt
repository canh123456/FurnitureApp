package com.canhptph44323.hoc_bai1_fpt

import android.content.Context
import android.renderscript.ScriptGroup.Input
import android.service.quicksettings.Tile
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController

//@Preview(showBackground = true)
@Composable
fun RegisterScreen(navController: NavController? = null )
{
    Column (modifier = Modifier.fillMaxSize()
        .background(color = Color.White)
        .padding(13.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start)
    {
            Column(modifier = Modifier.fillMaxWidth().height(70.dp))
            {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                    )
                {
                    Divider(
                            color = Color( "#BDBDBD".toColorInt()),
                        thickness = 2.dp,
                        modifier = Modifier.width(105.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.width(100.dp).height(200.dp)
                    )
                    Divider(
                        color = Color( "#BDBDBD".toColorInt()),
                        thickness = 2.dp,
                        modifier = Modifier.width(105.dp)
                    )
                }
            }

            Column(modifier = Modifier.fillMaxWidth().height(100.dp),
                    verticalArrangement = Arrangement.Center
                )
            {
                Text(
                    text = "WelCome !",
                    fontSize =28.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Font(R.font.gelasio_bold))
                )
            }

            Column(modifier = Modifier.fillMaxWidth(1f)
                                        .height(500.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(elevation = 4.dp, spotColor = colorResource(id = R.color.graySecond))
                    )
            {
                Column(modifier = Modifier.fillMaxSize().padding(15.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                    )
                {
                    InputRow(tile = "name")
                    InputRow(tile = "Email" )
                    InputRow(tile = "Password")
                    InputRow(tile = "confirmPassword")
                    Box(modifier = Modifier
                        .padding(7.dp)
                        .width(200.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF242424))
                        .clickable {  }
                    ) {
                        Row(modifier = Modifier
                            .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Sign Up",
                                fontSize = 17.sp,
                                color = Color.White,
                                fontWeight = FontWeight(600),
                                fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
                            )
                        }
                    }
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Gray,
                                fontFamily = FontFamily(Font(R.font.merriweather_regular))
                            )
                        ){
                            append("Already have account? ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        ){append("SIGN IN")}
                    }, modifier = Modifier.clickable {
                        if (navController != null) {
                            navController.popBackStack()
                        }
                    })
                }
            }

    }
}
@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen( ) // Sử dụng giá trị giả hoặc null
    LoginScreen()
}
@Composable
fun InputRow(tile: String){
    Column {
        Text(text = tile,
            color = colorResource(id= R.color.graySecond),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
            fontSize = 17.sp
        )
        CustomTextField()
    }
}

@Composable
fun CustomTextField() {
    var username by remember { mutableStateOf("") }
    TextField(
        value = username,
        onValueChange = {

        },
        modifier = Modifier
            .fillMaxWidth(0.8f),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color("#E0E0E0".toColorInt()),
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
        ),
    )
}

@Composable
fun LoginScreen(navController: NavController? = null){
        Column (modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
            .padding(13.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start)
        {
            Column(modifier = Modifier.fillMaxWidth().height(70.dp))
            {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Divider(
                        color = Color( "#BDBDBD".toColorInt()),
                        thickness = 2.dp,
                        modifier = Modifier.width(105.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.width(100.dp).height(200.dp)
                    )
                    Divider(
                        color = Color( "#BDBDBD".toColorInt()),
                        thickness = 2.dp,
                        modifier = Modifier.width(105.dp)
                    )
                }
            }

            Column(modifier = Modifier.fillMaxWidth().height(150.dp),
                verticalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = "Hello !",
                    fontWeight = FontWeight(700),
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.gelasio_bold))
                )
                Text(
                    text = "WelCome Back!",
                    fontSize =28.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Font(R.font.gelasio_bold))
                )
            }

            Column(modifier = Modifier.fillMaxWidth(1f)
                .height(500.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(elevation = 4.dp, spotColor = colorResource(id = R.color.graySecond))
            )
            {
                Column(modifier = Modifier.fillMaxSize().padding(15.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    InputRow(tile = "name")
//                    InputRow(tile = "Email" )
                    InputRow(tile = "Password")
//                    InputRow(tile = "confirmPassword")

                    Text(
                        text = "Forgot Password ?",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                        fontSize = 17.sp
                    )

                    Box(modifier = Modifier
                        .padding(7.dp)
                        .width(200.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF242424))
                        .clickable {  }
                    ) {
                        Row(modifier = Modifier
                            .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Login",
                                fontSize = 17.sp,
                                color = Color.White,
                                fontWeight = FontWeight(600),
                                fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
                            )
                        }
                    }
                    Text(text = buildAnnotatedString {
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Gray,
//                                fontFamily = FontFamily(Font(R.font.merriweather_regular))
//                            )
//                        ){
//                            append("Already have account? ")
//                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.gelasio_bold))
                            )
                        ){append("SIGN UP")}
                    }, modifier = Modifier.clickable {
                        if (navController != null) {
                            navController.popBackStack()
                        }
                    })
                }
            }

        }
    }
