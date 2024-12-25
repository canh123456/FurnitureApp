package com.canhptph44323.hoc_bai1_fpt

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

enum class ROUTE_NAME {
    welcome,
    login,
    home,
    signup,
    detail,
    cart,
    checkout,
    success,
    order,
    addShipment,
    addPayment,
    paymentMethod,
    setting,
    selectShipment,
    myReview,
    rating
}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = ROUTE_NAME.welcome.name) {
        composable(ROUTE_NAME.welcome.name) { WelCome(navController) }
        composable(ROUTE_NAME.login.name) { LoginScreen(navController) }
        composable(ROUTE_NAME.home.name) { Home_FurnitureApp(navController) }
        composable(ROUTE_NAME.signup.name) { RegisterScreen(navController) }
        composable(ROUTE_NAME.detail.name) { DetailsProduct(navController) }
        composable(ROUTE_NAME.cart.name) { SmallTopAppCart(navController) }
//        composable(ROUTE_NAME.checkout.name) { SmallTopAppBarPayment(navController) }
//        composable(ROUTE_NAME.success.name) { FinalScreen(navController) }
//        composable(ROUTE_NAME.order.name) { OrderScreenRun(navController) }
//        composable(ROUTE_NAME.addShipment.name) { AddShipmentScreen(navController) }
//        composable(ROUTE_NAME.addPayment.name) { AddPaymentScreen(navController) }
//        composable(ROUTE_NAME.paymentMethod.name) { SelectPaymentScreen(navController) }
//        composable(ROUTE_NAME.setting.name) { settingScreens(navController) }
//        composable(ROUTE_NAME.selectShipment.name) { AddressScreen(navController) }
//        composable(ROUTE_NAME.myReview.name) { MyReViewTopBar(navController) }
//        composable(ROUTE_NAME.rating.name) { ReView(navController) }
    }
}