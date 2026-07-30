package fr.astral.perminalTerlin.engine.rendering

import fr.astral.perminalTerlin.engine.scenes.Scene

/**
 * Renders the scene.
 */
class SceneRenderer(var scene: Scene) {
    fun render() {
        scene.renderContent()
    }
}