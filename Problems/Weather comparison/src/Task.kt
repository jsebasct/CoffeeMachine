class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = value
            if (value < -92 || value > 57) {
                field = when (name) {
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    "Dubai" -> 30
                    else -> 0
                }
            }
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    val someEqual = firstCity.degrees == secondCity.degrees
            || firstCity.degrees == thirdCity.degrees
            || secondCity.degrees == thirdCity.degrees

    if (someEqual) {
        println("neither")
    } else {
        val res =
            if (firstCity.degrees < secondCity.degrees) {
                if (firstCity.degrees < thirdCity.degrees) {
                    firstCity
                } else {
                    thirdCity
                }
            } else {
                if (secondCity.degrees < thirdCity.degrees) {
                    secondCity
                } else {
                    thirdCity
                }
            }
        print(res.name)
    }
}