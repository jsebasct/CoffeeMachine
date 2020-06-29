import java.util.*

class Player(val id: Int) {

    /* ... */
    companion object Properties {
        /* Default player speed in playing field - 7 cells per turn */
        var defaultSpeed = 7

        fun calcMovePenalty(cell: Int): Int {
            return 1
        }
    }

    /* creates a new instance of Player */
    object Factory {
        fun create(playerId: Int): Player {
            return Player(playerId)
        }
    }

    /* Allows saving player instance into a file or something else */
    object Serializer {
        var counter = 0;
        fun toBytes(): Int {
            return counter++
        }

        fun fromBytes(): Player {
            return Player(1)
        }
    }
}

fun main(args: Array<String>) {
    /* prints 7 */
    println(Player.defaultSpeed)
    Player.defaultSpeed = 8
    println(Player.defaultSpeed)


    /* prints 7 */
    println(Player.Properties.defaultSpeed)

/* also prints 7 */
    println(Player.defaultSpeed)

/* prints 13 */
    println(Player.Factory.create(13).id)
    println(Player.Serializer.toBytes())
    println(Player.Serializer.toBytes())
    println(Player.Serializer.toBytes())
    println(Player.Serializer.toBytes())

//    val scanner = Scanner(System.`in`)
//    var counter = 0;
//    var keepCounting = true
//
//    while (keepCounting && scanner.hasNext()) {
//        val input = scanner.next().trim().toInt()
//        if (keepCounting) {
//            keepCounting = input != 0
//        }
//
//        if (keepCounting) {
//            counter++
//        }
//    }
//    println(counter)
}
