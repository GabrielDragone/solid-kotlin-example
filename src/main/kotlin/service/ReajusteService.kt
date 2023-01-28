package service

import model.Funcionario
import java.math.BigDecimal

class ReajusteService(private val validacoes: List<ValidacaoReajuste>) { // Recebemos as validações no construtor. Perceba que não precisamos saber quais validações são.

    //private val PERCENTUAL_LIMITE = BigDecimal("0.4")

    fun reajustarSalarioDoFuncionario(funcionario: Funcionario, aumento: BigDecimal) {

        // 1ª Responsabilidade - Extraida pra classe de ValidacaoPercentualReajuste:
        /*val salarioAtual = funcionario.salario
        val percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP)

        if (percentualReajuste.compareTo(PERCENTUAL_LIMITE) > 0) {
            throw ValidacaoException("Reajuste não pode ser superior a 40% do salário!")
        }*/

        // 2ª Responsabilidade - Extraida pra classe de ValidacaoPeriodicidadeEntreReajustes:
        /*val dataUltimoReajuste = funcionario.dataUltimoReajuste
        val dataAtual = LocalDate.now()
        val mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual)
        if (mesesDesdeUltimoReajuste < 6) {
            throw ValidacaoException("Intervalos entre reajustes deve ser de no mínimo 6 meses!")
        }*/

        validacoes.forEach{v ->  v.validar(funcionario, aumento)} // Se passar por todas as validações, o salário do funcionário sera atualizada.

        val salarioReajustado = funcionario.salario.add(aumento)
        funcionario.atualizarSalario(salarioReajustado)
    }
}