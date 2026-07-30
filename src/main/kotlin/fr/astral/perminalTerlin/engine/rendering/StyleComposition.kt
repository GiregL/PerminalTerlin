package fr.astral.perminalTerlin.engine.rendering

interface StyleComposable {
    fun render(): String
}

data class StyleComposition(val styles: List<StyleComposable>): StyleComposable {
    companion object {
        val EMPTY = StyleComposition(emptyList())
        fun of(elem: StyleComposable): StyleComposition = StyleComposition(listOf(elem))
    }

    override fun render(): String {
        return styles.joinToString("") { it.render() }
    }

    operator fun plus(other: StyleComposable) = StyleComposition(styles + other)
}

/**
 * Represents a set of predefined background colors that can be used for styling terminal outputs.
 * Each background color is associated with a specific ANSI color code as a string.
 *
 * The `BackgroundColor` enum implements the `StyleComposable` interface, allowing it to be
 * rendered as part of a style composition in terminal-based UIs or text rendering.
 *
 * @property code The ANSI representation of the background color.
 */
enum class BackgroundColor(private val code: String): StyleComposable {
    BLACK("\u001b[40m"),
    RED("\u001b[41m"),
    GREEN("\u001b[42m"),
    YELLOW("\u001b[43m"),
    BLUE("\u001b[44m"),
    MAGENTA("\u001b[45m"),
    CYAN("\u001b[46m"),
    WHITE("\u001b[47m"),

    BRIGHT_BLACK("\u001b[100m"),
    BRIGHT_RED("\u001b[101m"),
    BRIGHT_GREEN("\u001b[102m"),
    BRIGHT_YELLOW("\u001b[103m"),
    BRIGHT_BLUE("\u001b[104m"),
    BRIGHT_MAGENTA("\u001b[105m"),
    BRIGHT_CYAN("\u001b[106m"),
    BRIGHT_WHITE("\u001b[107m"),

    RESET("\u001b[0m");

    override fun render(): String = code

    operator fun plus(other: BackgroundColor): StyleComposition = StyleComposition(listOf(this, other))
    operator fun plus(other: ForegroundColor): StyleComposition = StyleComposition(listOf(this, other))
}

enum class ForegroundColor(private val code: String): StyleComposable {
    BLACK("\u001b[30m"),
    RED("\u001b[31m"),
    GREEN("\u001b[32m"),
    YELLOW("\u001b[33m"),
    BLUE("\u001b[34m"),
    MAGENTA("\u001b[35m"),
    CYAN("\u001b[36m"),
    WHITE("\u001b[37m"),

    BRIGHT_BLACK("\u001b[90m"),
    BRIGHT_RED("\u001b[91m"),
    BRIGHT_GREEN("\u001b[92m"),
    BRIGHT_YELLOW("\u001b[93m"),
    BRIGHT_BLUE("\u001b[94m"),
    BRIGHT_MAGENTA("\u001b[95m"),
    BRIGHT_CYAN("\u001b[96m"),
    BRIGHT_WHITE("\u001b[97m"),

    RESET("\u001b[0m");

    override fun render(): String = code

    operator fun plus(other: BackgroundColor): StyleComposition = StyleComposition(listOf(this, other))
    operator fun plus(other: ForegroundColor): StyleComposition = StyleComposition(listOf(this, other))
}