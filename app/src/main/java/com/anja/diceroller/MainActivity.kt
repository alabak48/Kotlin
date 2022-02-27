package com.anja.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

       when (diceRoll) {
           1 -> diceImage.setImageResource(R.drawable.dice_1)
           2 -> diceImage.setImageResource(R.drawable.dice_2)
           3 -> diceImage.setImageResource(R.drawable.dice_3)
           4 -> diceImage.setImageResource(R.drawable.dice_4)
           5 -> diceImage.setImageResource(R.drawable.dice_5)
           6 -> diceImage.setImageResource(R.drawable.dice_6)
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
}}