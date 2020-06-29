class Box(var height: Double, var width: Double, var length: Double) {
    fun getVolume():Double {
        return height * width * length
    }
}

//fun List<Int>.allNonZero() =  all { TODO() }
//fun List<Int>.allNonZero1() =  none { TODO() }
//fun List<Int>.allNonZero2() =  any { TODO() }

fun List<Int>.containsZero() =  any { 0 }
//fun List<Int>.containsZero1() =  all { TODO() }
//fun List<Int>.containsZero2() =  none { TODO() }

fun main() {
    val list1 = listOf(1, 2, 3)
//    list1.allNonZero() eq true
//    list1.allNonZero1() eq true
//    list1.allNonZero2() eq true

    println(list1.containsZero() == false)
//    list1.containsZero1() eq false
//    list1.containsZero2() eq false

    val list2 = listOf(0, 1, 2)
//    list2.allNonZero() eq false
//    list2.allNonZero1() eq false
//    list2.allNonZero2() eq false

    println(list2.containsZero() == true)
//    list2.containsZero1() eq true
//    list2.containsZero2() eq true
}