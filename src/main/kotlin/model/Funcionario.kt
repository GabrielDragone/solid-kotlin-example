package br.com.gabrieldragone.model

import br.com.gabrieldragone.enum.Cargo
import br.com.gabrieldragone.exception.ValidacaoException
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

data class Funcionario (
    private val nome: String,
    private val cpf: String,
    private val cargo: Cargo,
    private var salario: BigDecimal,
    private var dataUltimoReajuste: LocalDate
) {

    private val ZERO_QUATRO = BigDecimal("0.4")

    fun reajustarSalario(aumento: BigDecimal) {
        val percentualReajuste = aumento.divide(this.salario, RoundingMode.HALF_UP)

        if (percentualReajuste.compareTo(ZERO_QUATRO) > 0) {
            throw ValidacaoException("Reajuste não pode ser superior a 40% do salário!")
        }

        this.salario = this.salario.add(aumento)
        this.dataUltimoReajuste = LocalDate.now()
    }

}