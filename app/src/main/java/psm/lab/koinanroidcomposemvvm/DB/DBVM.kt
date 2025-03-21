package psm.lab.koinanroidcomposemvvm.DB

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

class DBVM(private val repository: OsobaRepositoryImp) : ViewModel() {
    val allOsoby : LiveData<List<Osoba>> = repository.getOsoby().asLiveData()

    fun insert(osoba: Osoba) {
        viewModelScope.launch {
            repository.insert(osoba)
        }
    }

    fun deleteOsoba(id: Int) {
        viewModelScope.launch {
            repository.deleteOsoba(id)
        }
    }
}