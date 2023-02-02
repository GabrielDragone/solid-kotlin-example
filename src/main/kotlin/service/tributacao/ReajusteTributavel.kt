package service.tributacao

import java.math.BigDecimal

interface ReajusteTributavel: Reajuste { // Além de forçar a implementação de valorImpostoDeRenda, classes que implementarem essa interface terão que implementar Reajuste.

    fun valorImpostoDeRenda(): BigDecimal

}