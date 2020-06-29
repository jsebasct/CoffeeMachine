class Rectangle(val width: Int, val height: Int)

enum class Rainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet")
}

fun printArea(rectangle: Rectangle): Int {
    return rectangle.width * rectangle.height
}

fun main() {
    val rec = Rectangle(5,6)
    println(Rainbow.RED.color)
    val rainbowC = Rainbow.INDIGO
    println(rainbowC.name)
    println(rainbowC.ordinal)

    val rainbowV = Rainbow.valueOf("VIOLET")
    println(rainbowV.name)
//    println(rainbowV.get)
//    println(Rainbow.name)

}