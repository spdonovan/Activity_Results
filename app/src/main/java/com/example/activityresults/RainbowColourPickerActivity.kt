package com.example.activityresults

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class RainbowColourPickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rainbow_colour_picker)

        val colourPickerClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.red_button -> setRainbowColour(
                    getString(R.string.red), R.color.red)
                R.id.orange_button -> setRainbowColour(
                    getString(R.string.orange), R.color.orange)
                R.id.yellow_button -> setRainbowColour(
                    getString(R.string.yellow), R.color.yellow)
                R.id.green_button -> setRainbowColour(
                    getString(R.string.green), R.color.green)
                R.id.blue_button -> setRainbowColour(
                    getString(R.string.blue), R.color.blue)
                R.id.indigo_button -> setRainbowColour(
                    getString(R.string.indigo), R.color.indigo)
                R.id.violet_button -> setRainbowColour(
                    getString(R.string.violet), R.color.violet)
                else -> {
                    Toast.makeText(this, getString(R.string.unexpected_colour), Toast.LENGTH_LONG).show()
                }
            }
        }
        findViewById<View>(R.id.red_button).setOnClickListener(colourPickerClickListener)
        findViewById<View>(R.id.orange_button).setOnClickListener(colourPickerClickListener)
        findViewById<View>(R.id.yellow_button).setOnClickListener(colourPickerClickListener)
        findViewById<View>(R.id.green_button).setOnClickListener(colourPickerClickListener)
        findViewById<View>(R.id.blue_button).setOnClickListener(colourPickerClickListener)
        findViewById<View>(R.id.indigo_button).setOnClickListener(colourPickerClickListener)
        findViewById<View>(R.id.violet_button).setOnClickListener(colourPickerClickListener)
    }

    private fun setRainbowColour(colourName: String, colour: Int) {
        Intent().let { pickedColourIntent ->
            pickedColourIntent.putExtra(RAINBOW_COLOUR_NAME, colourName)
            pickedColourIntent.putExtra(RAINBOW_COLOUR, colour)

            setResult(Activity.RESULT_OK, pickedColourIntent)
            finish()
        }
    }
}