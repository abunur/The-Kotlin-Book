package com.anaara.kotlinbookchapter3

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    submitButton.setOnClickListener {

      val firstValue = firstNumber.text.toString().toIntOrNull()
      val secondValue = secondNumber.text.toString().toIntOrNull()
      val answerValue = addTwoNumbers(firstValue, secondValue)
      answerLabel.text = " = $answerValue"


    }
  }

  fun addTwoNumbers(firstValue: Int?, secondValue: Int?): Int {
    var answerValue = 0
    if (firstValue != null && secondValue != null) {
      answerValue = firstValue + secondValue
    }
    return answerValue

  }
}
