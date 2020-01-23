package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.NumberFormatException as NumberFormatException1


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Concatenate.setOnClickListener {
            try {
                val num1: Double = editText2.text.toString().toDouble()
                val num2: Double = editText.text.toString().toDouble()
                val sum: Double = num1 / num2
                textView2.text = sum.toString()
            } catch(e: NumberFormatException) {
                textView2.text = "Please input numbers"
            }

        }

        Add.setOnClickListener {
            //textView2.text = editText2.text.toString() + editText.text.toString()
            try {

                val num1: Double = editText2.text.toString().toDouble()
                val num2: Double = editText.text.toString().toDouble()
                val sum: Double = num1 / num2
                val iron: Double = sum - 4.01
                val bronze: Double = sum - 4.70
                val silver: Double = sum-5.12
                val gold: Double = sum-5.46
                val platinum: Double = sum-5.69
                val diamond: Double = sum-5.86
                val master: Double = sum-5.99
                val grandmaster: Double =  sum-6.05
                val challenger: Double = sum-7.01
                val result: String = "Iron =$iron \n" +
                        "Bronze =$bronze \n" +
                        "Silver = $silver \n" +
                        "Gold = $gold \n" +
                        "Platinum = $platinum \n" +
                        "Diamond = $diamond \n" +
                        "Masters = $master \n" +
                        "Grandmasters = $grandmaster \n" +
                        "Challenger = $challenger \n"
                textView.text = result
            } catch(e: NumberFormatException) {
                textView.text = "Please input numbers"
            }
        }

    }
}
