package psm.lab.koinanroidcomposemvvm.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface OsobaDao {

    @Insert
    suspend fun insertOsoba(osoba: Osoba)

    @Query("SELECT * FROM osoba")
    fun getAllOsoby(): Flow<List<Osoba>>

    @Query("DELETE FROM osoba WHERE id = :idOsoby")
    suspend fun deleteOsoba(idOsoby: Int)
}