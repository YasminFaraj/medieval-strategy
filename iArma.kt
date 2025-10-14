public interface iArma{
    fun dano() : Int
    fun efeitoEspecial(personagem: iPersonagem, inimigo: iPersonagem)
    fun custoMana() : Int
    fun requisito(personagem: iPersonagem) : Boolean
}