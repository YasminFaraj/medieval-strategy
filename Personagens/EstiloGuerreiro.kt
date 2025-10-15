package Personagens

import Armas.iArma

class EstiloGuerreiro(private val arma: iArma) : iEstiloLuta {
    override fun atacar(user: iPersonagem, alvo: iPersonagem) {
        if (!arma.requisito(user)) {
            println("${user.nome} não pode usar ${arma.nome}.")
            return
        }
        val dano = (arma.danoBase() + user.forca / 3)
        val danoReduzido = (dano * 0.8).toInt() // Pele Dura
        alvo.vida -= danoReduzido
        println("${user.nome} ataca ${alvo.nome} com ${arma.nome} causando $danoReduzido de dano (Pele Dura).")
        arma.efeitoEspecial(user, alvo)
    }

    override fun aplicarEfeitos(user: iPersonagem) {
        val iterator = user.efeitos.iterator()
        while (iterator.hasNext()) {
            val e = iterator.next()
            if (e.danoPorTurno > 0) {
                user.vida -= e.danoPorTurno
                println("${user.nome} sofre ${e.danoPorTurno} de dano por ${e.nome}.")
            }
            e.duracao--
            if (e.duracao <= 0) iterator.remove()
        }
    }
}
