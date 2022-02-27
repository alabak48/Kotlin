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

        // Do a dice roll when the app starts
        rollDice()
    }


    /**
     * Bacite kocku i ažurirajte zaslon s rezultatom.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

       val drawableResource = when (diceRoll) {
           1 -> R.drawable.dice_1
           2 -> R.drawable.dice_2
           3 -> R.drawable.dice_3
           4 -> R.drawable.dice_4
           5 -> R.drawable.dice_5
           else -> R.drawable.dice_6
       }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
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