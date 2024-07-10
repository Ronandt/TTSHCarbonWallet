package com.ttsh.carbonwallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ttsh.carbonwallet.presentation.screens.InformationOnboardingScreen.InformationOnboardingScreen
import com.ttsh.carbonwallet.presentation.screens.earnedmerchantpointsscreen.EarnedMerchantPointsScreen
import com.ttsh.carbonwallet.presentation.screens.earnwithmerchantdetailsscreen.EarnWithMerchantDetailsScreen
import com.ttsh.carbonwallet.presentation.screens.earnwithmerchantlistscreen.EarnedWithMerchantListScreen
import com.ttsh.carbonwallet.presentation.screens.enteredeventscreen.EnteredEventScreen
import com.ttsh.carbonwallet.presentation.screens.eventsuccessscreen.EventSuccessScreen
import com.ttsh.carbonwallet.presentation.screens.homescreen.HomeScreen
import com.ttsh.carbonwallet.presentation.screens.leaderboardscreen.LeaderboardScreen
import com.ttsh.carbonwallet.presentation.screens.loginscreen.LoginScreen
import com.ttsh.carbonwallet.presentation.screens.merchantmenuscreen.MerchantMenuScreen
import com.ttsh.carbonwallet.presentation.screens.profilescreen.ProfileScreen
import com.ttsh.carbonwallet.presentation.screens.qrcodescreen.QRCodeScreen
import com.ttsh.carbonwallet.presentation.screens.redeemwithmerchantlistscreen.RedeemWithMerchantListScreen
import com.ttsh.carbonwallet.presentation.screens.redeemwithmerchantmapscreen.RedeemWithMerchantMapScreen
import com.ttsh.carbonwallet.presentation.screens.redeemwithmerchantsuccessscreen.RedeemWithMerchantSuccessScreen
import com.ttsh.carbonwallet.presentation.screens.registerscreen.RegisterScreen
import com.ttsh.carbonwallet.presentation.screens.searchactivitiesscreen.SearchActivitiesScreen
import com.ttsh.carbonwallet.presentation.screens.settingsscreen.SettingsScreen
import com.ttsh.carbonwallet.presentation.screens.splashscreen.SplashScreen
import com.ttsh.carbonwallet.presentation.screens.triviadetailsscreen.TriviaDetailsScreen
import com.ttsh.carbonwallet.presentation.screens.triviaresultsscreen.TriviaResultsScreen
import com.ttsh.carbonwallet.presentation.screens.triviaroadmapscreen.TriviaRoadMapScreen
import com.ttsh.carbonwallet.presentation.screens.tutorialscreen.TutorialScreen
import com.ttsh.carbonwallet.presentation.theme.CarbonWalletTheme
import com.ttsh.carbonwallet.presentation.utils.ScreenRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            CarbonWalletTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = ScreenRoute.SplashScreen.route) {
                        composable(ScreenRoute.SplashScreen.route) {

                            SplashScreen({navController.navigate("authentication") {
                                this.popUpTo(ScreenRoute.SplashScreen.route) {
                                    this.inclusive = true
                                }
                            } })
                        }
                        composable(ScreenRoute.TutorialScreen.route) {
                            TutorialScreen()
                        }
                        composable(ScreenRoute.InformationOnboardingScreen.route) {
                           InformationOnboardingScreen(scope = scope)
                        }
                        navigation(route = "authentication",startDestination = ScreenRoute.LoginScreen.route) {
                            composable(ScreenRoute.LoginScreen.route) {
                                LoginScreen(onAuthenticated = {navController.navigate("users")}, toRegister = {
                                    navController.navigate(ScreenRoute.RegisterScreen.route)
                                })
                            }
                            composable(ScreenRoute.RegisterScreen.route) {
                                RegisterScreen(toLogin = {
                                    navController.navigate(ScreenRoute.LoginScreen.route)

                                }, toHome = {navController.navigate(ScreenRoute.InformationOnboardingScreen.route)})
                            }
                        }
                        navigation(route = "users", startDestination = "home") {
                            composable(ScreenRoute.QRCodeScreen.route) {
                                QRCodeScreen()
                            }
                            navigation(route = "event", startDestination = ScreenRoute.EnteredEventScreen.route)  {
                                composable(ScreenRoute.EnteredEventScreen.route) {
                                    EnteredEventScreen()
                                }
                                composable(ScreenRoute.EventSuccessScreen.route) {
                                    EventSuccessScreen()
                                }
                            }

                            navigation(route = "home", startDestination = ScreenRoute.HomeScreen.route) {
                                composable(ScreenRoute.HomeScreen.route) {
                                    HomeScreen()
                                }
                                composable(ScreenRoute.SearchActivitiesScreen.route ) {
                                    SearchActivitiesScreen()
                                }
                                navigation(route = "profile", startDestination = ScreenRoute.ProfileScreen.route) {
                                    composable(ScreenRoute.ProfileScreen.route) {
                                        ProfileScreen()
                                    }
                                    composable(ScreenRoute.SettingsScreen.route) {
                                        SettingsScreen()
                                    }

                                }
                            }
                            composable(ScreenRoute.LeaderboardScreen.route) {
                                LeaderboardScreen()
                            }
                            navigation(route = "merchant", startDestination = ScreenRoute.MerchantMenuScreen.route) {
                                navigation(route = "redeem", startDestination = ScreenRoute.RedeemWithMerchantListScreen.route) {
                                    composable(route = ScreenRoute.RedeemWithMerchantListScreen.route   ) {
                                        RedeemWithMerchantListScreen()
                                    }
                                    composable(route = ScreenRoute.RedeemWithMerchantMapScreen.route) {
                                        RedeemWithMerchantMapScreen()
                                    }
                                    composable(route = ScreenRoute.RedeemWithMerchantSuccessScreen.route) {
                                        RedeemWithMerchantSuccessScreen()
                                    }
                                }
                                navigation(route = "earn", startDestination = ScreenRoute.EarnWithMerchantListScreen.route) {
                                    composable(route = ScreenRoute.EarnWithMerchantListScreen.route) {
                                        EarnedWithMerchantListScreen()
                                    }
                                    composable(route = ScreenRoute.EarnWithMerchantDetailsScreen.route) {
                                        EarnWithMerchantDetailsScreen()
                                    }
                                    composable(route = ScreenRoute.EarnedMerchantPointsScreen.route) {
                                        EarnedMerchantPointsScreen()
                                    }

                                }
                                composable(ScreenRoute.MerchantMenuScreen.route) {
                                    MerchantMenuScreen()
                                }

                            }
                            navigation(route = "trivia", startDestination = ScreenRoute.TriviaRoadmapScreen.route) {
                                composable(ScreenRoute.TriviaRoadmapScreen.route) {
                                    TriviaRoadMapScreen()
                                }
                                composable(ScreenRoute.TriviaDetailsScreen.route) {
                                    TriviaDetailsScreen()
                                }
                                composable(ScreenRoute.TriviaResultsScreen.route) {
                                    TriviaResultsScreen()
                                }

                            }




                        }




                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CarbonWalletTheme {
        Greeting("Android")
    }
}