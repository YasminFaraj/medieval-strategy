package Armas

import Personagens.iPersonagem

class ArcoElfico : iArma {
    override val nome = "Arco Élfico"
    override fun danoBase() = 12
    override fun custoMana() = 15
    override fun requisito(personagem: iPersonagem) = personagem.destreza >= 8

    override fun efeitoEspecial(user: iPersonagem, alvo: iPersonagem) {
        println("${user.nome} ataca todos os inimigos com Chuva de Flechas!")
    }
}
