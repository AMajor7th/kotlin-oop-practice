import kotlin.math.PI

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)
    with(squareCabin) {
        println("\nSquare Cabin\n================")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Have room? ${haveRoom()}")
        println("Floor area: ${floorArea()}")
    }
    with(roundHut) {
        println("\nRound Hut\n================")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Have room? ${haveRoom()}")
        println("Floor area: ${floorArea()}")
    }
    with(roundTower) {
        println("\nRound Tower\n================")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Have room? ${haveRoom()}")
        println("Floor area: ${floorArea()}")
        println("Have room? ${haveRoom()}")
        getRoom()
        println("Have room? ${haveRoom()}")
        getRoom()
    }
}

abstract class Dwelling(var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    abstract fun floorArea(): Double
    fun haveRoom(): Boolean { return capacity > residents }
    fun getRoom() {
        if (capacity > residents) {
            println("You got a room!")
            residents++
        } else {
            println("Sorry! There are no rooms left.")
        }
    }
}

class SquareCabin(residents: Int, val length: Double): Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea(): Double {
        return length*length
    }
}

open class RoundHut(residents: Int, val radius: Double): Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
	override fun floorArea(): Double {
        return PI*radius*radius
    }
}

class RoundTower(residents: Int, radius: Double, val floors: Int = 2): RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    override fun floorArea(): Double {
        return super.floorArea()*floors
    }
}
