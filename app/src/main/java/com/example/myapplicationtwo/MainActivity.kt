package com.example.myapplicationtwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val ADDITION = "addition"
        const val SUBTRACTION = "subtraction"
        const val INPUT_ONE = "one"
        const val INPUT_TWO = "two"
        const val RESULT = "result"
        const val OPERATOR = "operator"
        const val RESULT_CODE = 104
    }

    private lateinit var oneValue : String
    private lateinit var twoValue : String
    private lateinit var operator : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        oneValue = intent.getStringExtra(INPUT_ONE)?: ""
        twoValue = intent.getStringExtra(INPUT_TWO)?: ""
        operator = intent.getStringExtra(OPERATOR)?: ""

        when(operator){

            ADDITION ->{
               var addResult = (oneValue.toInt() + twoValue.toInt()).toString()
                returnResult(addResult)
            }

            SUBTRACTION ->{
               var subResult = (oneValue.toInt() - twoValue.toInt()).toString()
                returnResult(subResult)
            }
        }
    }

    fun returnResult(result: String?) {
        val intent = Intent()
        intent?.putExtra(INPUT_ONE, oneValue)
        intent?.putExtra(INPUT_TWO, twoValue)
        intent?.putExtra(OPERATOR, operator)
        intent?.putExtra(RESULT, result)
        intent.setFlags(0)
        setResult(RESULT_CODE, intent)
        finish()
    }
}