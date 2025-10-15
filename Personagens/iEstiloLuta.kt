package Personagens

public interface iEstiloLuta {
    fun atacar(user: iPersonagem, alvo: iPersonagem)
    fun aplicarEfeitos(user: iPersonagem)
}
