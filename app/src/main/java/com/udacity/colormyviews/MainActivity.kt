package com.udacity.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.udacity.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListeners()

    }

    private fun setListeners() {
        val clikableViews: List<View> = binding.run {
            listOf(
                boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, constraintLayout,
                redButton, yellowButton, greenButton
            )
        }
        for (item in clikableViews) {
            item.setOnClickListener {makeColored(it)}
        }
    }

    fun makeColored(view: View) {
        when (view) {

            // Boxes using Color class colors for background
            binding.boxOneText -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText-> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            binding.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            binding.redButton -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            binding.yellowButton -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            binding.greenButton -> binding.boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
