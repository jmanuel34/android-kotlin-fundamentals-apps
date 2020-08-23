/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    lateinit var diceImage1: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage=findViewById(R.id.dice_image)
        diceImage1=findViewById((R.id.dice_image1))
        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val borrarButton: Button = findViewById(R.id.clear_button)
        borrarButton.setOnClickListener {borrarButton()}
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollDice() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random().toInt()
        var randomInt1 = (1..6).random().toInt()
        while(randomInt==randomInt1 )
            randomInt1=(1..6).random()
        asignarImagen(randomInt, diceImage)
        asignarImagen(randomInt1, diceImage1)
/*
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
  */
 //       val diceImage: ImageView = findViewById(R.id.dice_image)

    }
    private fun asignarImagen(randomInt: Int, diceImage:ImageView ):Unit {
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
    private fun borrarButton() {
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage1.setImageResource(R.drawable.empty_dice)
    }


}
