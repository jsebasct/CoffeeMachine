import java.util.Scanner

enum class Rainbow(val color: String, val rgb: String) {
    red("Red", "#FF0000"),
    orange("Orange", "#FF7F00"),
    yellow("Yellow", "#FFFF00"),
    green("Green", "#00FF00"),
    blue("Blue", "#0000FF"),
    indigo("Indigo", "#4B0082"),
    violet("Violet", "#8B00FF");
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val colorName = input.nextLine()
    
    var found = false
    for (en in Rainbow.values()) {
        if (!found && en.name == colorName) {
            found = true
        }
    }
    println(found)
}
