package Armas

import Personagens.iPersonagem

interface iArma {
    val nome: String
    fun danoBase(): Int
    fun custoMana(): Int
    fun requisito(personagem: iPersonagem): Boolean
    fun efeitoEspecial(user: iPersonagem, alvo: iPersonagem)
}
