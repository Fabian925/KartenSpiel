import java.util.*

class WattenSpiel {

    private var kartenImSpiel: LinkedList<Karte> = LinkedList();
    private var kartenStapel = KartenStapel()
    private var angesagteKarte: Karte? = null
    private var spieler: List<Spieler>? = null;

    constructor() {
        kartenStapel.mischen()
    }

    fun spielerRegistrieren(spieler: List<Spieler>) {
        this.spieler = LinkedList(spieler)
    }

    private fun ansagen(schlag: Schlag, trumpf: Trumpf) {
       angesagteKarte = Karte(schlag, trumpf)
    }

    private fun getGewonnen(): Int {
        if(kartenImSpiel[0].schlag > kartenImSpiel[1].schlag)
            return 0
        if(kartenImSpiel[0].schlag < kartenImSpiel[1].schlag)
            return 1
        return -1
    }

    private fun kartenAusteilen() {
        spieler!![0].addKartenOnHand(kartenStapel.karteZiehen(2))
        spieler!![1].addKartenOnHand(kartenStapel.karteZiehen(2))
        spieler!![0].addKartenOnHand(kartenStapel.karteZiehen(3))
        spieler!![1].addKartenOnHand(kartenStapel.karteZiehen(3))
    }

    fun cliSpielStarten() {
        val spieler1: Spieler = Spieler("Fabian")
        val spieler2: Spieler = Spieler("Florian")
        println("Spiel hat begonnen: 2er-Watten")
        println("Stapel wird gemischt")

        this.spielerRegistrieren(listOf(spieler1, spieler2))
        this.kartenAusteilen()
        var runde = 1
        while (runde < 6) {
            println("Runde: $runde")
            println("Spieler ${spieler!![0].name} ist dran")
            var i = 0;
            for (karte in spieler!![0].getHand()) {
                println("$i: ${karte.schlag}, ${karte.trumpf}")
                i++
            }

            kartenImSpiel.add(0, spieler!![0].spieleKarte(readln().toInt()))

            println("Spieler ${spieler!![1].name} ist dran")
            i = 0;
            for (karte in spieler!![1].getHand()) {
                println("$i: ${karte.schlag}, ${karte.trumpf}")
                i++
            }

            kartenImSpiel.add(1, spieler!![1].spieleKarte(readln().toInt()))

            when (this.getGewonnen()) {
                0 -> println("${spieler!![0].name} hat gewonnen")

                1 -> println("${spieler!![1].name} hat gewonnen")

                -1 -> println("Gleichstand")
            }
            runde++
        }

    }
}
