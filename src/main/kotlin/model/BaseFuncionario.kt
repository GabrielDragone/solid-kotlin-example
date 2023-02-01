package model

import enum.Cargo
import java.math.BigDecimal
import java.time.LocalDate

// Classe abstrata criada para que fosse possivel herdar em Funcionario e Terceirizado, já que o data class do Kotlin
// não permite realizar a Herança, devido à alguns métodos gerados como hashCode, equals, copy e devido ao Kotlin precisar
// garantir o funcionamento das mesmas.
abstract class BaseFuncionario (
    open var nome: String,
    open var cpf: String,
    open var cargo: Cargo,
    open var salario: BigDecimal,
    open var dataUltimoReajuste: LocalDate? = null
) {
}