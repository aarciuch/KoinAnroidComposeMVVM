package psm.lab.koinanroidcomposemvvm

import androidx.lifecycle.ViewModel

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    fun sayHello(name: String): String {
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello ${it.name}" } ?: "User ${name} not found!"
    }
    fun addUser(name: String) {
        var list = arrayListOf<User>()
        list.add(User(name))
        repository.addUser(list)
    }
    fun getList(): ArrayList<User> {
        return repository.getUsers()
    }
}