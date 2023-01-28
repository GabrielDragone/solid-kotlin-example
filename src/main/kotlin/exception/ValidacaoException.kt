package br.com.gabrieldragone.exception

data class ValidacaoException(val mensagem: String): RuntimeException(mensagem) {
}