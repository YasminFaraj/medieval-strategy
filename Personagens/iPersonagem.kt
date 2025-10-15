package Personagens

import status.StatusEfeito

interface iPersonagem {
    val nome: String
    var vida: Int
    var mana: Int
    val forca: Int
    val destreza: Int
    val inteligencia: Int
    val efeitos: MutableList<StatusEfeito>
    var estilo: iEstiloLuta

    fun atacar(inimigo: iPersonagem) {
        estilo.atacar(this, inimigo)
    }

    fun aplicarEfeitos() {
        estilo.aplicarEfeitos(this)
    }

    fun aplicarEfeito(efeito: StatusEfeito) {
        efeitos.add(efeito)
    }

    fun estaVivo(): Boolean = vida > 0
}
