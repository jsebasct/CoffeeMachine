package machine

import java.util.*

enum class MachineState {
    PROCESS,
    PROCESS_BUY,
    PROCESS_FILL_WATER,
    PROCESS_FILL_MILK,
    PROCESS_FILL_COFFEE,
    PROCESS_FILL_CUPS
}

class CoffeeMachine(
    var water: Int,
    var milk: Int,
    var coffeeBeans: Int,
    var disposableCups: Int,
    var money: Int
) {

    var machineState = MachineState.PROCESS

    fun processInput(userInput: String): String {
        var res = ""

        if (machineState == MachineState.PROCESS) {
            res = when (userInput) {
                "buy" -> prepareBuy()
                "fill" -> prepareFill()
                "take" -> executeTake()
                "remaining" -> executeRemaining()
                "exit" -> "exit"
                else -> "exit"
            }
        } else if (machineState == MachineState.PROCESS_BUY) {
            val optionCoffee = userInput//scanner.nextLine()
            machineState = MachineState.PROCESS

            if (optionCoffee != "back") {
                val typeOfCoffee = optionCoffee.trim().toInt()
                prepareCoffee(typeOfCoffee)
            }
        } else if (machineState == MachineState.PROCESS_FILL_WATER) {
            this.water += userInput.toInt()
            machineState = MachineState.PROCESS_FILL_MILK
            res = "Write how many ml of milk do you want to add:"

        } else if (machineState == MachineState.PROCESS_FILL_MILK) {
            this.milk += userInput.toInt()
            machineState = MachineState.PROCESS_FILL_COFFEE
            res = "Write how many grams of coffee beans do you want to add:"

        } else if (machineState == MachineState.PROCESS_FILL_COFFEE) {
            this.coffeeBeans += userInput.toInt()
            machineState = MachineState.PROCESS_FILL_CUPS
            res = "Write how many disposable cups of coffee do you want to add:"

        } else if (machineState == MachineState.PROCESS_FILL_CUPS) {
            this.disposableCups += userInput.toInt()
            machineState = MachineState.PROCESS
            res = ""
        }

        return res
    }

    private fun prepareFill(): String {
        val question = "Write how many ml of water do you want to add:"
        machineState = MachineState.PROCESS_FILL_WATER
        return question
    }

    private fun executeTake(): String {
        val money = collectTheMoney()
        return "I gave you \$$money"
    }

    private fun executeRemaining(): String {
        return report()
    }

    private fun prepareBuy(): String {
        machineState = MachineState.PROCESS_BUY
        return "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "
    }

    private fun executeBuy(scanner: Scanner) {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        val optionCoffee = scanner.nextLine()
        if (optionCoffee != "back") {
            val typeOfCoffee = optionCoffee.trim().toInt()
            this.prepareCoffee(typeOfCoffee)
        }
    }

    /**
     * Espresso The coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
     * For the cappuccino, the machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
     * For the latte, the machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
     */
    fun prepareCoffee(typeOfCoffee: Int) {
        machineState = MachineState.PROCESS
        if (validRequest(typeOfCoffee)) {
            println("I have enough resources, making you a coffee!")
            this.disposableCups--
            when (typeOfCoffee) {
                1 -> this.money += prepareEspresso()
                2 -> this.money += prepareLatte()
                3 -> this.money += prepareCappucino()
                else -> {
                }
            }
        }
    }

    fun report(): String {
        return "The coffee machine has:\n" +
                "$water of water\n" +
                "$milk of milk \n$coffeeBeans of coffee beans" +
                "\n$disposableCups of disposable cups" +
                "\n$money of money"
    }

    private fun validRequest(typeOfCoffee: Int): Boolean {
        var res = true
        when (typeOfCoffee) {
            1 -> { //espresso
                if (water < 250) {
                    println("Sorry, not enough water!")
                    res = false
                } else if (coffeeBeans < 16) {
                    println("Sorry, not enough coffee beans!")
                    res = false
                }
            }
            2 -> { //late
                if (water < 350) {
                    println("Sorry, not enough water!")
                    res = false
                } else if (milk < 75) {
                    println("Sorry, not enough milk!")
                    res = false
                } else if (coffeeBeans < 20) {
                    println("Sorry, not enough coffee beans!")
                    res = false
                }
            }
            3 -> { //capuchino
                if (water < 200) {
                    println("Sorry, not enough water!")
                    res = false
                } else if (milk < 100) {
                    println("Sorry, not enough milk!")
                    res = false
                } else if (coffeeBeans < 12) {
                    println("Sorry, not enough coffee beans!")
                    res = false
                }
            }
            else -> {
            }
        }
        return res
    }

    private fun prepareCappucino(): Int {
        this.water -= 200
        this.milk -= 100
        this.coffeeBeans -= 12
        return 6;
    }

    private fun prepareLatte(): Int {
        this.water -= 350
        this.milk -= 75
        this.coffeeBeans -= 20
        return 7
    }

    private fun prepareEspresso(): Int {
        this.water -= 250
        this.coffeeBeans -= 16
        return 4
    }

    fun refill(water: Int, milk: Int, coffee: Int, cups: Int) {
        this.water += water
        this.milk += milk
        this.coffeeBeans += coffee
        this.disposableCups += cups
    }

    private fun collectTheMoney(): Int {
        val res = this.money
        this.money = 0
        return res
    }
}


fun main() {
    val scanner = Scanner(System.`in`)
    val machine = CoffeeMachine(400, 540, 120, 9, 550)

    print("Write action (buy, fill, take, remaining, exit): ")
    var command = scanner.nextLine().trim()

    do {
        var askAgain = true
        var result = machine.processInput(command)

        println(result)
        while (result.contains("?") || result.contains("how many")) {
            command = scanner.nextLine().trim()
            result = machine.processInput(command)
            println(result)
        }

        askAgain = result != "exit"
        if (askAgain) {
            print("Write action (buy, fill, take, remaining, exit): ")
            command = scanner.nextLine().trim()
        } else {
            command = "exit"
        }

    } while (command != "exit")
}

private fun executeBuy(scanner: Scanner, machine: CoffeeMachine) {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val optionCoffee = scanner.nextLine()
    if (optionCoffee != "back") {
        val typeOfCoffee = optionCoffee.trim().toInt()
        machine.prepareCoffee(typeOfCoffee)
    }
}


























































