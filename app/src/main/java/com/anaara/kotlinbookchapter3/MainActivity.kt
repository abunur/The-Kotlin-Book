/*
 * Copyright (c) 2018 Anaara LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.anaara.kotlinbookchapter3

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
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

      //drawing code
      val bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_4444)
      val canvas = Canvas(bitmap)

      // canvas background color
      canvas.drawARGB(255, 78, 168, 186);

      var paint = Paint()
      paint.setColor(Color.parseColor("#FFFFFF"))
      paint.setStrokeWidth(30F)
      paint.setStyle(Paint.Style.STROKE)
      paint.setAntiAlias(true)
      paint.setDither(true)

      // get device dimensions
      val displayMetrics = DisplayMetrics()
      windowManager.defaultDisplay.getMetrics(displayMetrics)
      // circle center
      System.out.println("Width : "+displayMetrics.widthPixels)
      var center_x = (displayMetrics.widthPixels/2).toFloat()
      var center_y = (displayMetrics.heightPixels/2).toFloat()
      var radius = 300F

      // draw circle
      canvas.drawCircle(center_x, center_y, radius, paint)
      // now bitmap holds the updated pixels

      // set bitmap as background to ImageView
      drawArea.background = BitmapDrawable(getResources(), bitmap)
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
