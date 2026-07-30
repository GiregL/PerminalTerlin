package fr.astral.perminalTerlin.game.world

/**
 * Represents a renderable object within a grid-based world.
 * Uses ANSI based codes to render the object.
 */
interface WorldRenderable {
    fun render(): String
}

enum class TileType(val representationChar: Char) {
    VOID(' '),
    WATER('~'),
    STONE('^'),
    SAND('~'),
    GRASS(',');
}

/**
 * Represents a slot that a tile contains.
 */
interface TileSlot {
    fun renderSlot(): Char
}

/**
 * Represents a tile within a grid-based world.
 *
 * A tile is characterized by its type and may optionally hold a slot.
 * The type determines the physical or logical attributes of the tile,
 * while the slot defines an additional functional component that may
 * be associated with the tile.
 *
 * @property type The type of the tile, determining its representation and behavior.
 * @property slot An optional slot associated with the tile to provide additional
 *                functionality or state.
 */
data class Tile(val type: TileType, val slot: TileSlot? = null): WorldRenderable {
    companion object {
        val EMPTY = Tile(TileType.VOID)
    }

    override fun render(): String {
        return "${type.representationChar}"
    }
}

/**
 * Represents a 2D grid-based world with a specific width and height.
 *
 * The world contains a grid of tiles, each identified by its type.
 * This class provides internal functionalities to manage and
 * manipulate the tiles within the grid.
 *
 * @property width The width of the world grid, representing the number of columns.
 * @property height The height of the world grid, representing the number of rows.
 */
class World(val width: Int, val height: Int) {
    private var tiles: Array<Tile> = Array(height * width) { Tile(TileType.VOID) }

    init {
        for (i in 0 until width * height) {
            val tileType: TileType = TileType.entries.toTypedArray().random()
            tiles[i] = Tile(tileType)
        }
    }

    /**
     * Converts a 2D coordinate to a 1D index in the tiles array.
     */
    private fun toArrayCoord(x: Int, y: Int): Int = y * width + x

    /**
     * Sets the tile at the specified coordinates within the grid.
     *
     * This method updates the tile at the given 2D coordinates (x, y)
     * to the specified tile. The coordinates must be within the bounds
     * of the grid, defined by the `width` and `height` of the world.
     * If the coordinates are out of bounds, an `IllegalArgumentException`
     * will be thrown.
     *
     * @param x The x-coordinate of the tile to be set, representing the column.
     * @param y The y-coordinate of the tile to be set, representing the row.
     * @param tile The tile to be set at the specified coordinates.
     * @throws IllegalArgumentException If the coordinates are out of the grid's bounds.
     */
    fun setTile(x: Int, y: Int, tile: Tile) {
        require(x in 0 until width && y in 0 until height) { "Coordinates are out of bounds" }
        tiles[toArrayCoord(x, y)] = tile
    }

    /**
     * Retrieves the tile at the specified coordinates within the grid.
     *
     * This method returns the tile at the given 2D coordinates (x, y)
     * if the coordinates are within the bounds of the grid, defined by
     * the `width` and `height` of the world. If the coordinates are out
     * of bounds, `null` is returned.
     *
     * @param x The x-coordinate of the tile to retrieve, representing the column.
     * @param y The y-coordinate of the tile to retrieve, representing the row.
     * @return The tile at the specified coordinates, or `null` if the coordinates are out of bounds.
     */
    fun getTile(x: Int, y: Int): Tile? {
        if (!(x in 0 until width && y in 0 until height)) {
            return null
        }
        return tiles[toArrayCoord(x, y)]
    }
}