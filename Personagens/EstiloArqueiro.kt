package Personagens

import Armas.iArma
import kotlin.random.Random

class EstiloArqueiro(private val arma: iArma) : iEstiloLuta {
    override fun atacar(user: iPersonagem, alvo: iPersonagem) {
        if (!arma.requisito(user)) {
            println("${user.nome} não pode usar ${arma.nome}.")
            return
        }
        if (Random.nextInt(100) < 25) {
            println("${user.nome} esquiva do ataque!")
            return
        }
        val dano = arma.danoBase() + user.destreza / 2
        alvo.vida -= dano
        println("${user.nome} ataca ${alvo.nome} com ${arma.nome} causando $dano de dano.")
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
