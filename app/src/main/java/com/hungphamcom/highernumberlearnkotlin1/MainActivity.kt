package com.hungphamcom.highernumberlearnkotlin1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButtons()
        button1.setOnClickListener {
            checkAnswer(true)
            assignNumbersToButtons()
        }

        button2.setOnClickListener{
            checkAnswer(false)
            assignNumbersToButtons()
        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean){
        val leftNum = button1.text.toString().toInt()
        val rightNum = button2.text.toString().toInt()
        val isAnswerCorrect: Boolean =if(isLeftButtonSelected)leftNum>rightNum else rightNum>leftNum
        if (isAnswerCorrect) {
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum: Int = r.nextInt(10)
        var rightNum=leftNum
        while (rightNum==leftNum){
            rightNum = r.nextInt(10)
        }
        button1.text= leftNum.toString()
        button2.text= rightNum.toString()

    }
}