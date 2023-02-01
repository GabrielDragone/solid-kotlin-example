package service

import enum.Cargo
import exception.ValidacaoException
import model.Funcionario

class PromocaoService {

    fun promover(funcionario: Funcionario, metaBatida: Boolean) {
        val cargoAtual = funcionario.cargo
        if (Cargo.GERENTE == cargoAtual) {
            throw ValidacaoException("Gerentes não podem ser promovidos!")
        }

        if (metaBatida) {
            val novoCargo = cargoAtual.getProximoCargo() // método abstrato dentro de enum, forçado a ser implementado em cada Constante
            funcionario.promover(novoCargo)
        } else {
            throw ValidacaoException("Funcionário não bateu a meta!")
        }

    }
}