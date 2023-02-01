package model

import enum.Cargo
import java.math.BigDecimal
import java.time.LocalDate

data class Terceirizado (
//    override var nome: String, // A data class do Kotlin cria o hashCode, equals, toString e outros métodos baseados no construtor primário.
//    override var cpf: String,  // Por isso é necessário substituir (override) os campos da classe no construtor.
//    override var cargo: Cargo,
//    override var salario: BigDecimal,
//    override var dataUltimoReajuste: LocalDate? = null
    var empresa: String, // Só que diferente do Funcionario, essa classe terá um atributo.
//): BaseFuncionario(nome, cpf, cargo, salario, dataUltimoReajuste) {
    val dadosPessoais: DadosPessoais // Alterado na aula 04 - 05: Liskov Substitution Principle, utilizando composição pra dividir métodos em comum. Da maneira antiga com BaseFuncionariotambém daria certo
) {
}

