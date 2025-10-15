package Armas

import Personagens.iPersonagem
import kotlin.random.Random

class AdagaSombria : iArma {
    override val nome = "Adaga Sombria"
    override fun danoBase() = 10
    override fun custoMana() = 10
    override fun requisito(personagem: iPersonagem) = personagem.destreza >= 12

    override fun efeitoEspecial(user: iPersonagem, alvo: iPersonagem) {
        val desprevenido = Random.nextBoolean()
        if (desprevenido) {
            val dano = danoBase() * 3
            alvo.vida -= dano
            println("${user.nome} aplica Ataque Furtivo em ${alvo.nome} causando $dano de dano!")
        }
    }
}
