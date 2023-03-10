package service

import exception.ValidacaoException
import model.Funcionario
import java.math.BigDecimal
import java.math.RoundingMode

class ValidacaoPercentualReajuste(): ValidacaoReajuste {

    private val PERCENTUAL_LIMITE = BigDecimal("0.4")

    override fun validar(funcionario: Funcionario, aumento: BigDecimal) {
        val salarioAtual = funcionario.salario
        val percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP)

        if (percentualReajuste.compareTo(PERCENTUAL_LIMITE) > 0) {
            throw ValidacaoException("Reajuste não pode ser superior a 40% do salário!")
        }
    }

}