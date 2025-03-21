package psm.lab.koinanroidcomposemvvm.DB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Osoba::class], version = 1, exportSchema = false)
abstract class OsobaDB : RoomDatabase() {
    abstract fun getOsobaDao() : OsobaDao
}