package fr.astral.perminalTerlin.engine

class GameRunner(val render: () -> Unit, val update: () -> Unit, val shouldExit: () -> Boolean) {
    fun run() {
        var run = true
        while (run) {

            render()

            update()
            run = shouldExit()
        }
    }
}