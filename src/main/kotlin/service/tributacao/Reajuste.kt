package service.tributacao

import java.math.BigDecimal
import java.time.LocalDate

interface Reajuste {

    fun valor(): BigDecimal
    fun data(): LocalDate
//    fun valorImpostoDeRenda(): BigDecimal // Fazendo dessa forma, na classe Anuenio, não precisariamos forçar a implementação de algo que não fosse utilizado.

}