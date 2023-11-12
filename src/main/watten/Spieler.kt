import java.util.LinkedList

class Spieler(var name: String) {
    private var hand: LinkedList<Karte> = LinkedList()

    fun addKartenOnHand(karten: List<Karte>) {
        for(karte in karten)
            hand.add(karte)
    }

    fun spieleKarte(index: Int): Karte {
        val ret = hand.get(index)
        hand.removeAt(index)
        return ret
    }

    //TODO
    fun bieten() {

    }

    fun getHand(): List<Karte>{
        return hand
    }

    fun karteAnsagen(index: Int): Karte {
        return hand.get(index)
    }
}