package psm.lab.koinanroidcomposemvvm

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::UserRepositoryImp) { bind<UserRepository>() }
    viewModelOf(::UserViewModel)
}