package Personagens

import Armas.iArma

class EstiloMago(private val arma: iArma) : iEstiloLuta {
    override fun atacar(user: iPersonagem, alvo: iPersonagem) {
        if (!arma.requisito(user)) {
            println("${user.nome} não pode usar ${arma.nome}.")
            return
        }
        if (user.mana < arma.custoMana()) {
            println("${user.nome} não tem mana suficiente para usar ${arma.nome}.")
            return
        }
        user.mana -= arma.custoMana()
        val dano = arma.danoBase() + user.inteligencia / 2
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
        user.mana += 10
        println("${user.nome} regenera 10 de mana (Mana atual: ${user.mana})")
    }
}
