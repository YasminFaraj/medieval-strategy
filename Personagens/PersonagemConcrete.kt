package Personagens

class PersonagemConcrete(
    override val nome: String,
    override var vida: Int,
    override var mana: Int,
    override val forca: Int,
    override val destreza: Int,
    override val inteligencia: Int,
    override var estilo: iEstiloLuta
) : iPersonagem {
    override val efeitos = mutableListOf<status.StatusEfeito>()
}
