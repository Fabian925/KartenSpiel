enum class Schlag {
    FUENF,
    SECHS,
    SIEBEN,
    ACHT,
    NEUN,
    ZEHN,
    UNTER,
    OBER,
    KOENIG,
    ASS
}

enum class Trumpf {
    EICHEL, LAUB, SCHELL, HERZ
}

class Karte(var schlag: Schlag, var trumpf: Trumpf){

    override fun toString(): String {
        return this.schlag.toString() + " " + this.trumpf.toString()
    }
}

class KartenStapel() {
    private var kartenStapel: MutableList<Karte> = MutableList(40, { i -> Karte(Schlag.entries.get(i % 10), Trumpf.entries.get(i / 10))})

    fun mischen() {
        this.kartenStapel.shuffle()
    }

    fun karteZiehen(anzahl: Int): List<Karte> {
        val ret: MutableList<Karte> = MutableList(anzahl) { i ->
            val ersteKarte: Karte = this.kartenStapel.first
            this.kartenStapel.removeFirst()
            ersteKarte
        }
        return ret
    }
}
