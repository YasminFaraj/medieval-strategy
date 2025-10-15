package Armas

import Personagens.iPersonagem
import status.StatusEfeito
import kotlin.random.Random

class EspadaLonga : iArma {
    override val nome = "Espada Longa"
    override fun danoBase() = 15
    override fun custoMana() = 0
    override fun requisito(personagem: iPersonagem) = personagem.forca >= 10

    override fun efeitoEspecial(user: iPersonagem, alvo: iPersonagem) {
        if (Random.nextInt(100) < 30) {
            alvo.aplicarEfeito(StatusEfeito("Sangramento", 3, 5))
            println("${user.nome} aplica Corte Profundo em ${alvo.nome}!")
        }
    }
}
