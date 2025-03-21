package psm.lab.koinanroidcomposemvvm.DB

import kotlinx.coroutines.flow.Flow

interface OsobaRepository {
    suspend fun insert(osoba: Osoba)
    fun getOsoby() : Flow<List<Osoba>>
    suspend fun deleteOsoba(id: Int)
}