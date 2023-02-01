package model

import enum.Cargo
import java.math.BigDecimal
import java.time.LocalDate

data class DadosPessoais(
    var nome: String,
    var cpf: String,
    var cargo: Cargo,
    var salario: BigDecimal,
    var dataUltimoReajuste: LocalDate? = null
) {
}