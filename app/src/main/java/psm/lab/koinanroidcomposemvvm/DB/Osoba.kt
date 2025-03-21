package psm.lab.koinanroidcomposemvvm.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "osoba")
data class Osoba(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "name") val name : String
) {
}