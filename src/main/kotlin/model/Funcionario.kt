package model

import enum.Cargo
import exception.ValidacaoException
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

data class Funcionario (
    private val nome: String,
    private val cpf: String,
    var cargo: Cargo,
    var salario: BigDecimal,
    var dataUltimoReajuste: LocalDate
) {

    // Trecho abaixo extraido pra ReajusteService:
    /*private val ZERO_QUATRO = BigDecimal("0.4")

    fun reajustarSalario(aumento: BigDecimal) { // Responsabilidade de reajustarSalario não é do Funcionario, pois ele não precisa saber como o reajuste é feito.
        val percentualReajuste = aumento.divide(this.salario, RoundingMode.HALF_UP)

        if (percentualReajuste.compareTo(ZERO_QUATRO) > 0) {
            throw ValidacaoException("Reajuste não pode ser superior a 40% do salário!")
        }

        this.salario = this.salario.add(aumento)
        this.dataUltimoReajuste = LocalDate.now()
    }*/

    fun atualizarSalario(novoSalario: BigDecimal) {  // A responsabilidade da classe será apenas de atualizar o registro.
        this.salario = novoSalario
        this.dataUltimoReajuste = LocalDate.now()
    }

    fun promover(novoCargo: Cargo) {
        this.cargo = novoCargo
    }

}