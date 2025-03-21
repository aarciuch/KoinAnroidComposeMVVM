package psm.lab.koinanroidcomposemvvm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import psm.lab.koinanroidcomposemvvm.DB.DBVM
import psm.lab.koinanroidcomposemvvm.DB.Osoba

@Composable
fun DB(navController : NavController) {
    Screen4DB()
}

@Composable
fun Screen4DB(viewModel : DBVM = koinViewModel()) {
    var osobaId by remember { mutableStateOf(0) }
    var osobaName by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    MyColumn(onItemClick = {
        osobaId = it.id
        osobaName = it.name
        showDialog = true
    })
    Column  {
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {showDialog = false},
                title = {Text(text="Usuwanie z bazy")},
                text = { Text(text = "Czy chcesz usunąć osobę: ${osobaName}") },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog = false
                        viewModel.deleteOsoba(osobaId)
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDialog = false
                    }) {
                        Text("Anuluj")
                    }
                }
            )
        }
    }
}

@Composable
fun MyColumn(onItemClick: (Osoba) -> Unit, viewModel : DBVM = koinViewModel()) {
    val osoby by viewModel.allOsoby.observeAsState(emptyList())
    var tekstKlikniety by remember { mutableStateOf(false) }
    var a by remember { mutableStateOf("") }
    Column (modifier = Modifier.padding(all= 24.dp)) {
        TextField(
            value = a,
            onValueChange = {
                a = it },
            label = { Text("Wpisz nazwę") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = { viewModel.insert(Osoba(0,a))
            tekstKlikniety = true})
        {
            Text(text = "Dodaj osobę")
        }
        osoby.forEach { osoba ->
            Text(text = "${osoba.name}",
                modifier = Modifier.clickable { onItemClick(osoba) })
        }
    }
}

