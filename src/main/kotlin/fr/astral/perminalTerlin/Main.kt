package fr.astral.perminalTerlin

import fr.astral.perminalTerlin.engine.rendering.SceneRenderer
import fr.astral.perminalTerlin.game.scenes.WorldScene
import fr.astral.perminalTerlin.game.world.World

fun gameLoop(logic: () -> Unit) {
    while (true) {

        val read = readln()
        if (read.trim().isEmpty()) {
            break;
        }
        logic()
    }
    print("Leaving game.")
}

fun main() {
    val world = World(75, 30)
    val scene = WorldScene(world)
    val renderer = SceneRenderer(scene)

    gameLoop {
        renderer.render()
    }

}