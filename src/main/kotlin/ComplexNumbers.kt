import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {

    operator fun plus(other: ComplexNumber) =
            ComplexNumber(real + other.real, imag + other.imag)

    operator fun minus(other: ComplexNumber) =
            ComplexNumber(real - other.real, imag - other.imag)

    operator fun times(other: ComplexNumber) =
            ComplexNumber(real * other.real - imag * other.imag,
                    imag * other.real + real * other.imag)

    operator fun div(other: ComplexNumber) =
            ComplexNumber((real * other.real + imag * other.imag) / other.abs.pow(2),
                    (imag * other.real - real * other.imag) / other.abs.pow(2))

    val abs = sqrt(real.pow(2) + imag.pow(2))

    fun conjugate() = ComplexNumber(real, -imag)
}

fun exponential(complexNumber: ComplexNumber) =
        ComplexNumber(real = E.pow(complexNumber.real)) *
                ComplexNumber(cos(complexNumber.imag), sin(complexNumber.imag))
