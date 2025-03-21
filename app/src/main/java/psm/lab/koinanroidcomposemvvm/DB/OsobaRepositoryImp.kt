package psm.lab.koinanroidcomposemvvm.DB

import kotlinx.coroutines.flow.Flow

class OsobaRepositoryImp(private val osobaDao: OsobaDao) : OsobaRepository {

    val _osoby : Flow<List<Osoba>> = osobaDao.getAllOsoby()

    override suspend fun insert(osoba: Osoba) {
        osobaDao.insertOsoba(osoba)
    }

    override fun getOsoby() = _osoby

    override suspend fun deleteOsoba(id: Int) {
        osobaDao.deleteOsoba(id)
    }
}