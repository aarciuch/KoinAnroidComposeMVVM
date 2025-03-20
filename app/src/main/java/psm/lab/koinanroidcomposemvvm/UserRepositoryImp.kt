package psm.lab.koinanroidcomposemvvm

class UserRepositoryImp : UserRepository {

    private val _users = arrayListOf<User>()

    override fun findUser(name: String): User? {
        return _users.firstOrNull{it.name == name}
    }

    override fun addUser(users: List<User>) {
        _users.addAll(users)
    }

    override fun getUsers(): ArrayList<User> {
        return _users
    }
}