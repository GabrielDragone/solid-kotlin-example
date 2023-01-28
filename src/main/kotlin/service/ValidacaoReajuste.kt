package service

import model.Funcionario
import java.math.BigDecimal

interface ValidacaoReajuste {

    fun validar(funcionario: Funcionario, aumento: BigDecimal)

}
