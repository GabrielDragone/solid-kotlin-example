package enum

enum class Cargo {
    ASSISTENTE {
        override fun getProximoCargo(): Cargo {
            return ANALISTA
        }
    },
    ANALISTA {
        override fun getProximoCargo(): Cargo {
            return ESPECIALISTA
        }
    },
    ESPECIALISTA {
        override fun getProximoCargo(): Cargo {
            return GERENTE
        }
    },
    GERENTE {
        override fun getProximoCargo(): Cargo {
            return GERENTE
        }
    };

    abstract fun getProximoCargo(): Cargo // abstract pra forçarmos a implementação em cima de cada Constantes acima.
}