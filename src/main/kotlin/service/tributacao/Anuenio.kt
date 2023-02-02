package service.tributacao

import java.math.BigDecimal
import java.time.LocalDate

class Anuenio(val valor: BigDecimal, val data: LocalDate): Reajuste {
    override fun valor(): BigDecimal {
        return this.valor
    }

    override fun data(): LocalDate {
        return this.data
    }

//    override fun valorImpostoDeRenda(): BigDecimal { // Vamos supor que nesse cenário não é necessário utilizar o
//        return BigDecimal.ZERO // método valorImpostoDeRenda que foi implementado devido à interface Reajuste. Logo,
//    }                          // essa classe está sendo forçada a implementar algo que não será utilizado.
}