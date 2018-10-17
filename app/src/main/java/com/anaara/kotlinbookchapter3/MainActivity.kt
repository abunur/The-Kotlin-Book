package com.anaara.kotlinbookchapter3

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    submitButton.setOnClickListener {
      try {
        val firstValue = firstNumber.text.toString().toInt()
        val secondValue = secondNumber.text.toString().toInt()
        val answerValue = addTwoNumbers(firstValue, secondValue)
        answerLabel.text = "$answerValue"
      } catch (e: NumberFormatException) {
        answerLabel.text = e.toString()
      }


    }
  }

  fun addTwoNumbers(firstValue: Int, secondValue: Int): Int {
    val answerValue = firstValue + secondValue
    return answerValue

  }
}
