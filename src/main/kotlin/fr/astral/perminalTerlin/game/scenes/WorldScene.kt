package fr.astral.perminalTerlin.game.scenes

import fr.astral.perminalTerlin.engine.scenes.Scene
import fr.astral.perminalTerlin.game.world.Tile
import fr.astral.perminalTerlin.game.world.World

class WorldScene(val world: World): Scene {

    override fun renderContent() {
        val buff = StringBuffer()

        for (y in 0 until world.height) {
            for (x in 0 until world.width) {
                val tile = world.getTile(x, y) ?: Tile.EMPTY

                buff.append(tile.render())
            }

            buff.append("\n")
        }

        print(buff.toString())
    }
}