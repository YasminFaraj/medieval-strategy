package Batalha

import Personagens.iPersonagem

class Batalha(private val personagens: List<iPersonagem>) {

    fun iniciar() {
        var turno = 1
        while (personagens.count { it.estaVivo() } > 1) {
            println("\n--- Turno $turno ---")
            for (p in personagens.filter { it.estaVivo() }) {
                val alvo = personagens.filter { it != p && it.estaVivo() }.randomOrNull()
                if (alvo != null) {
                    p.atacar(alvo)
                }
                p.aplicarEfeitos()
            }
            turno++
        }
        val vencedor = personagens.firstOrNull { it.estaVivo() }
        println("\n--- Batalha Finalizada ---")
        println("Vencedor: ${vencedor?.nome ?: "Nenhum"}")
    }
}
