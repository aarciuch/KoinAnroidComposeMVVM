package psm.lab.koinanroidcomposemvvm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.KoinAndroidContext
import psm.lab.koinanroidcomposemvvm.ui.theme.KoinAnroidComposeMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinAnroidComposeMVVMTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
                KoinAndroidContext {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
   val navController = rememberNavController()

   Scaffold (
       bottomBar = {
           BottomNavigationBar(navController)
       }
   ) { innerPadding ->
       NavHost(
           navController = navController,
           startDestination = Pages.List.name,
           modifier = Modifier.padding(innerPadding)
       ) {
           composable(route = Pages.List.name) { List(navController) }
           composable(route = Pages.DB.name) { DB(navController) }
       }
   }
}
@Composable
fun BottomNavigationBar(navController: NavController) {

    BottomAppBar() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            Column() {
                Text(
                    text = "List",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                )
                IconButton(onClick = { navController.navigate(route = Pages.List.name) })  {
                    Icon(Icons.Filled.Home, contentDescription = "List")
                }
            }
            Column () {
                Text(
                    text = "DB",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                )
                IconButton(onClick = { navController.navigate(route = "${Pages.DB.name}") }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "DB")
                }
            }
        }
    }
}


