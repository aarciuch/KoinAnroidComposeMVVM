package psm.lab.koinanroidcomposemvvm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun List(navController: NavController) {
    ViewModelInject()
}
@Composable
fun ViewModelInject(viewModel: UserViewModel = koinViewModel())  {
    var a by remember { mutableStateOf("") }
    var b by remember { mutableStateOf("") }
    var c = remember { mutableStateOf(arrayListOf<User>()) }

    Column (modifier = Modifier.padding(top = 24.dp, start = 8.dp, end = 8.dp)){
        HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(top = 24.dp))
        TextField(
            value = a,
            onValueChange = {
                a = it
                b = viewModel.sayHello(a) },
            label = { Text("Enter name here") },
            modifier = Modifier.fillMaxWidth()
        )
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly) {
            Button(onClick = { b = viewModel.sayHello(a) })
            {
                Text(text = "Szukaj")
            }
            Button(onClick = {
                viewModel.addUser(a)
                b = ""
                a = ""
                c.value = viewModel.getList()  }
            )
            {
                Text(text = "Dodaj")
            }

        }
        Text(text = "${b}")
        LazyColumn (
            Modifier
                .background(Color.Yellow)
                .fillMaxWidth())
        {
            items(c.value) {
                Column {
                    Text(text = it.name,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 30.sp)
                    HorizontalDivider(thickness = 3.dp, color = Color.Red)
                }
            }
        }
    }
}