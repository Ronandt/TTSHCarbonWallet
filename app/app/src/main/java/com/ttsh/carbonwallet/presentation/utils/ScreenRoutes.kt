package com.ttsh.carbonwallet.presentation.utils

sealed class ScreenRoute(val route: String, val routeHierarchy: String = "", val parameters: String = "") {
    object SplashScreen : ScreenRoute("splash_screen")
    object LoginScreen : ScreenRoute("login_screen")
    object RegisterScreen : ScreenRoute("register_screen")
    object FormOnboardingScreen : ScreenRoute("form_onboarding_screen")
    object InformationOnboardingScreen : ScreenRoute("information_onboarding_screen")
    object LeaderboardScreen : ScreenRoute("leaderboard_screen")
    object HomeScreen : ScreenRoute("home_screen")
    object ProfileScreen : ScreenRoute("profile_screen")
    object SettingsScreen : ScreenRoute("settings_screen")
    object SearchActivitiesScreen: ScreenRoute("search_activities_screen")
    object QRCodeScreen: ScreenRoute("qr_code_screen")
    object EnteredEventScreen: ScreenRoute("entered_event_screen")
    object EarnedMerchantPointsScreen: ScreenRoute("earned_merchant_points_screen")
    object EarnWithMerchantListScreen: ScreenRoute("earn_with_merchant_list_screen")
    object EarnWithMerchantDetailsScreen: ScreenRoute("earn_with_merchant_details_screen")
    object RedeemWithMerchantListScreen: ScreenRoute("redeem_with_merchant_list_screen")
    object RedeemWithMerchantSuccessScreen:ScreenRoute("redeem_with_merchant_success_screen")
    object RedeemWithMerchantMapScreen:ScreenRoute("redeem_with_merchants_map_screen")
    object MerchantMenuScreen: ScreenRoute("merchant_menu_screen")
    object TriviaRoadmapScreen: ScreenRoute("trivia_screen")
    object TriviaDetailsScreen: ScreenRoute("trivia_details_screen")
    object TriviaResultsScreen: ScreenRoute("trivia_results_screen")
    object EventSuccessScreen: ScreenRoute("event_success_screen")

    override fun toString(): String {
        return "${if(routeHierarchy.isEmpty()) "" else "$routeHierarchy/"}${route}${if(parameters.isEmpty()) "" else "/$parameters"}"
    }
}