package tikray.iago.tikray2v.screens.navegation

sealed class Screen(val route:String){

    object Home: Screen(route = " Home_Screen_route")
    object Register: Screen(route = "Register_Screen_Route")


}