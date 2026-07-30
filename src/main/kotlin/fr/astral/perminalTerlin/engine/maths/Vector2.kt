package fr.astral.perminalTerlin.engine.maths

import kotlin.math.sqrt

/**
 * A generic two-dimensional vector data class that represents a point or a direction
 * in a 2D space, utilizing numeric types.
 *
 * @property x The x-coordinate of the vector.
 * @property y The y-coordinate of the vector.
 */
data class Vector2(val x: Double = 0.0, val y: Double = 0.0) {

    /**
     * Computes the squared length (magnitude) of the vector.
     * This is the sum of the squares of its x and y components.
     *
     * @return The squared length of the vector as a Double.
     */
    fun squaredLength(): Double = x * x + y * y

    /**
     * Computes the length (magnitude) of the vector.
     * This is the square root of the sum of the squares of its x and y components.
     *
     * @return The length of the vector as a Double.
     */
    fun length(): Double = sqrt(squaredLength())

    /**
     * Normalizes this vector, making it a unit vector (length of 1).
     * If the vector is zero, it returns a zero vector.
     *
     * @return A new vector that is the normalized version of this vector.
     */
    fun normalize(): Vector2 = this / this.length()

    /**
     * Adds another vector to this vector.
     *
     * @param other The vector to add.
     * @return A new vector that is the result of the addition.
     */
    operator fun plus(other: Vector2): Vector2 = Vector2(x + other.x, y + other.y)

    /**
     * Subtracts another vector from this vector.
     *
     * @param other The vector to subtract.
     * @return A new vector that is the result of the subtraction.
     */
    operator fun minus(other: Vector2): Vector2 = Vector2(x - other.x, y - other.y)

    /**
     * Multiplies this vector by a scalar value.
     *
     * @param scalar The scalar value to multiply the vector components by.
     * @return A new vector where each component is the product of the scalar value and the corresponding component of this vector.
     */
    operator fun times(scalar: Double): Vector2 = Vector2(x * scalar, y * scalar)

    /**
     * Performs a component-wise multiplication of this vector with another vector.
     *
     * @param other The vector with which to multiply the components of this vector.
     * @return A new vector where each component is the product of the corresponding components of this vector and the other vector.
     */
    operator fun times(other: Vector2): Vector2 = Vector2(x * other.x, y * other.y)

    /**
     * Divides this vector by a scalar value.
     *
     * @param scalar The scalar value to divide the vector components by.
     * @return A new vector where each component is the quotient of the corresponding component of this vector and the scalar value.
     */
    operator fun div(scalar: Double): Vector2 = Vector2(x / scalar, y / scalar)

    /**
     * Negates this vector.
     *
     * @return A new vector where each component is the negation of the corresponding component of this vector.
     */
    operator fun unaryMinus(): Vector2 = Vector2(-x, -y)
}
