package psm.lab.koinanroidcomposemvvm


import androidx.room.Room
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import psm.lab.koinanroidcomposemvvm.DB.DBVM
import psm.lab.koinanroidcomposemvvm.DB.OsobaDB
import psm.lab.koinanroidcomposemvvm.DB.OsobaRepository
import psm.lab.koinanroidcomposemvvm.DB.OsobaRepositoryImp

val appModule = module {
    single { Room.databaseBuilder(get(), OsobaDB::class.java, "osobaDB").build() }
    single { get<OsobaDB>().getOsobaDao() }

    single { OsobaRepositoryImp(get()) } bind OsobaRepository::class
   // singleOf(::OsobaRepositoryImp) { bind<OsobaRepositoryImp>() }

    singleOf(::UserRepositoryImp) { bind<UserRepository>() }
    viewModelOf(::UserViewModel)
    viewModelOf(::DBVM)
}


