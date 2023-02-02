package service.tributacao

import java.math.BigDecimal
import java.time.LocalDate

//class Promocao(val valor: BigDecimal, val data: LocalDate): Reajuste { // Segregação de Interface, passando para ReajusteTributavel que implementa Reajuste
class Promocao(val valor: BigDecimal, val data: LocalDate): ReajusteTributavel {
    override fun valor(): BigDecimal {
        return this.valor
    }

    override fun data(): LocalDate {
        return this.data
    }

    override fun valorImpostoDeRenda(): BigDecimal {
        return valor.multiply(BigDecimal("0.1"))
    }
}