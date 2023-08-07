import kotlin.random.Random

fun main() {
    println("----------------------------")
    println("Test iteration:")
    val winner = deathRollWithPrintout(10000)
    println("Winner = Player${if (winner) "1" else "2"}")
    println("----------------------------")

    val n = 1_000_000
    val start = 10000
    var player1Wins = 0
    var player2Wins = 0

    for (i in 0..n) {
        if (deathRoll(start)) player1Wins++ else player2Wins++
    }

    val player1Percent:Double = (player1Wins/n.toDouble())*100
    val player2Percent:Double = (player2Wins/n.toDouble())*100

    println("n = $n")
    println("Player1 wins = $player1Wins ($player1Percent%)")
    println("Player2 wins = $player2Wins ($player2Percent%)")
}

fun deathRoll(start:Int):Boolean {
    var limit = start
    var isPlayer1 = true

    while (limit > 1) {
        limit = Random.nextInt(1,limit+1)
        isPlayer1 = !isPlayer1
    }

    return isPlayer1
}

fun deathRollWithPrintout(start:Int):Boolean {
    var limit = start
    var isPlayer1 = true

    while (limit > 1) {
        val interval = "(1-$limit)"
        limit = Random.nextInt(1,limit+1)
        if (isPlayer1) {
            println("Player1 rolls $limit $interval")
        }
        else {
            println("Player2 rolls $limit $interval")
        }
        isPlayer1 = !isPlayer1
    }

    return isPlayer1
}