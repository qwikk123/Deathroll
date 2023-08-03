import kotlin.random.Random

fun main(args: Array<String>) {
    var winner = deathRoll(1000)
    println("Winner = Player$winner")
}

fun deathRoll(start:Int):Int {
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

    return if (isPlayer1) 1 else 2
}