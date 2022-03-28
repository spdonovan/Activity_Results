package com.example.activityresults

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

const val PICK_RAINBOW_COLOUR_INTENT = 1
const val RAINBOW_COLOUR_NAME = "RAINBOW_COLOUR_NAME"
const val RAINBOW_COLOUR = "RAINBOW_COLOUR"
const val DEFAULT_COLOUR = "#FFFFFF"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.submit_button).setOnClickListener {
            Intent(this, RainbowColourPickerActivity::class.java)
                .also { rainbowColourPickerIntent ->
                    startActivityForResult(
                        rainbowColourPickerIntent,
                        PICK_RAINBOW_COLOUR_INTENT
                    )
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_RAINBOW_COLOUR_INTENT &&
                resultCode == Activity.RESULT_OK) {
            val backgroundColor = data?.getIntExtra(RAINBOW_COLOUR,
            Color.parseColor(DEFAULT_COLOUR)) ?:
            Color.parseColor(DEFAULT_COLOUR)

            val colorName = data?.getStringExtra(RAINBOW_COLOUR_NAME) ?: ""
            val colorMessage = getString(R.string.colour_chosen_message, colorName)

            val rainbowColor = findViewById<TextView>(R.id.rainbow_colour)

            rainbowColor.setBackgroundColor(ContextCompat.getColor(this, backgroundColor))
            rainbowColor.text = colorMessage
            rainbowColor.isVisible = true
        }
    }
}