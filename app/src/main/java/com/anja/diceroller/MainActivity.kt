package com.anja.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * Ova aktivnost omogućuje korisniku da baci kocku i pogleda rezultat
 * na ekranu.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Bacite kocku i ažurirajte zaslon s rezultatom.
     */
    private fun rollDice() {
        // Kreiranje novog Dice objekta sa 6 strana s funckijom bacanja kocke.
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Ažurirajte zaslon s bacanjem kocke.
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

/**
 * Kreiranje klase Dice s brojčanim podacima. Klasa Dice s metodom roll
 * koja vraća/generira nasumičan broj od 1 do 6 koji se nalaze u varijabli numSides.
 */
private class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}