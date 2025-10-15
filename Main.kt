import Personagens.*
import Armas.*
import Batalha.Batalha

fun main() {
    val guerreiro = PersonagemConcrete(
        nome = "Thorfin",
        vida = 120,
        mana = 50,
        forca = 15,
        destreza = 8,
        inteligencia = 5,
        estilo = EstiloGuerreiro(EspadaLonga())
    )

    val arqueiro = PersonagemConcrete(
        nome = "ibiribob",
        vida = 90,
        mana = 80,
        forca = 8,
        destreza = 15,
        inteligencia = 7,
        estilo = EstiloArqueiro(ArcoElfico())
    )

    val mago = PersonagemConcrete(
        nome = "Ravena",
        vida = 70,
        mana = 150,
        forca = 5,
        destreza = 7,
        inteligencia = 18,
        estilo = EstiloMago(CajadoArcano())
    )

    val paladino = PersonagemConcrete(
        nome = "Sterfen",
        vida = 110,
        mana = 100,
        forca = 13,
        destreza = 10,
        inteligencia = 12,
        estilo = EstiloPaladino(MachadoGuerra())
    )

    val batalha = Batalha(listOf(guerreiro, arqueiro, mago, paladino))
    batalha.iniciar()
}
