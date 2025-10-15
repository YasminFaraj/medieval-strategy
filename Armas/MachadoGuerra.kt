package Armas

import Personagens.iPersonagem
import status.StatusEfeito
import kotlin.random.Random

class MachadoGuerra : iArma {
    override val nome = "Machado de Guerra"
    override fun danoBase() = 18
    override fun custoMana() = 5
    override fun requisito(personagem: iPersonagem) = personagem.forca >= 15

    override fun efeitoEspecial(user: iPersonagem, alvo: iPersonagem) {
        if (Random.nextInt(100) < 25) {
            alvo.aplicarEfeito(StatusEfeito("Atordoado", 1, 0))
            println("${user.nome} aplica Golpe Esmagador em ${alvo.nome}!")
        }
    }
}
