package com.anaara.kotlinbookchapter3

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submitButton.setOnClickListener {
            answerLabel.text = addTwoNumbers(firstNumber.text.toString(), secondNumber.text.toString())


        }
    }

    fun addTwoNumbers(firstValue: String, secondValue: String): String {
        val answerValue = firstValue + secondValue
        return  answerValue

    }
}
