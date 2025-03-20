package psm.lab.koinanroidcomposemvvm

interface UserRepository {
    fun findUser(name: String): User?
    fun addUser(users : List<User>)
    fun getUsers() : ArrayList<User>
}
