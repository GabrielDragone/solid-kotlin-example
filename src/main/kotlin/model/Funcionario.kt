package model

import enum.Cargo
import java.math.BigDecimal
import java.time.LocalDate

data class Funcionario (
//    override var nome: String, // A data class do Kotlin cria o hashCode, equals, toString e outros métodos baseados no construtor primário.
//    override var cpf: String,  // Por isso é necessário substituir (override) os campos da classe no construtor.
//    override var cargo: Cargo,
//    override var salario: BigDecimal,
//    override var dataUltimoReajuste: LocalDate? = null
//): BaseFuncionario(nome, cpf, cargo, salario, dataUltimoReajuste) {
    val dadosPessoais: DadosPessoais // Alterado na aula 04 - 05: Liskov Substitution Principle, utilizando composição pra dividir métodos em comum. Da maneira antiga com BaseFuncionariotambém daria certo
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
        this.dadosPessoais.salario = novoSalario
        this.dadosPessoais.dataUltimoReajuste = LocalDate.now()
    }

    fun promover(novoCargo: Cargo) {
        this.dadosPessoais.cargo = novoCargo
    }

}