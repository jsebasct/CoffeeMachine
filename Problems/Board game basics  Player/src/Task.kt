class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var counter = 1
        val defaultHP = 100
        fun create(name: String ): Player {
            return Player(counter++, name, defaultHP)
        }
    }
}