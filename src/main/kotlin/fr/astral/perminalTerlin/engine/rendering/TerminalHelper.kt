package fr.astral.perminalTerlin.engine.rendering

/**
 * Utility object that provides helper functions for terminal operations.
 */
object TerminalHelper {
    
    fun clearScreen() = print("\u001b[2J\u001b[H")

}