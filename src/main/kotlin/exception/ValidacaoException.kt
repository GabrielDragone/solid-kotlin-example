package exception

data class ValidacaoException(val mensagem: String): RuntimeException(mensagem) {
}