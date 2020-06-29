//enum class DangerLevel(private val numberLevel: Int) {
enum class DangerLevel(private val numberLevel: Int) {
    HIGH (3),
    MEDIUM (2),
    LOW(1);

    fun getLevel(): Int {
        return numberLevel;
    }
}

fun main () {
    val high = DangerLevel.HIGH
    val medium = DangerLevel.MEDIUM

    println(high.getLevel() > medium.getLevel()) // true

}