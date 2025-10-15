package Armas

import Personagens.iPersonagem
import status.StatusEfeito

class CajadoArcano : iArma {
    override val nome = "Cajado Arcano"
    override fun danoBase() = 8
    override fun custoMana() = 25
    override fun requisito(personagem: iPersonagem) = personagem.inteligencia >= 12

    override fun efeitoEspecial(user: iPersonagem, alvo: iPersonagem) {
        alvo.aplicarEfeito(StatusEfeito("Queimadura", 2, 10))
        println("${user.nome} aplica Bola de Fogo em ${alvo.nome}!")
    }
}
