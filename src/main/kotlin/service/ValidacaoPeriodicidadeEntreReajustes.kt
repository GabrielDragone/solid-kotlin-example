package service

import exception.ValidacaoException
import model.Funcionario
import java.math.BigDecimal
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class ValidacaoPeriodicidadeEntreReajustes: ValidacaoReajuste {

    override fun validar(funcionario: Funcionario, aumento: BigDecimal) { // apesar do aumento não estar sendo utilizado no método, mantive pra salvar o exemplo dado pelo professor.
        val dataUltimoReajuste = funcionario.dataUltimoReajuste
        val dataAtual = LocalDate.now()
        val mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual)

        if (mesesDesdeUltimoReajuste < 6) {
            throw ValidacaoException("Intervalos entre reajustes deve ser de no mínimo 6 meses!")
        }
    }

}