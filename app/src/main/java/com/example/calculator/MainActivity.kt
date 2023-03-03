package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.ViewAnimator


class MainActivity : AppCompatActivity() {
    //For manipulating the input/output label of our calculator
    private var outputLabel:TextView?=null
    //For handling the data 
    private var calculator:Calculator?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        outputLabel= findViewById<View>(R.id.textView1) as TextView
        calculator= Calculator()


    }

    //This function will be called whenever any number key is pressed to update the input screen
     fun getInput(view:View){
        val value=outputLabel!!.text as String
        val digit=view.contentDescription as String
        if(value[0]=='0')
        {
            outputLabel!!.text=digit
        }
        else
        {
            if(digit=="-"&&value!="0"&&calculator!!.operand1==0.0)
            {
                outputLabel!!.text=("-"+outputLabel!!.text as String)
            }
            else if(digit=="-")
            {
                outputLabel!!.text=(outputLabel!!.text as String)

            }
            else
            {
                outputLabel!!.text=(outputLabel!!.text as String+digit[0])
            }


        }

    }

    //Following two functions are to save the first and second operand before computing the output value
    private fun saveInput1(){
        try {
            val value=outputLabel!!.text as String
            calculator!!.operand1=value.toDouble()
        }
        catch (e:NumberFormatException)
        {
            calculator!!.operand1=0.0
        }
    }

    private fun saveInput2(){
        try {
            val value=outputLabel!!.text as String
            val i= value.indexOf(calculator!!.operator)
            val sub=value.substring(i+1)
            calculator!!.operand2=sub.toDouble()
        }
        catch (e:NumberFormatException)
        {
            calculator!!.operand2=0.0
        }

    }

    //Whenever any operator button is clicked then this function saves the first operand as well as the operator value
    fun saveOperation(view: View)
    {
        val out=outputLabel!!.text as String
        val value=view.contentDescription as String
        if(out=="0")
        {
            clearScreen(view)

        }
        else{
            saveInput1()
            outputLabel!!.text=(outputLabel!!.text as String+value[0])
            calculator!!.operator=value
        }

    }

    //To display the result value on output text label
    fun calculate(view:View){
        saveInput2()
        val number2digits:Double = String.format("%.2f", calculator!!.value).toDouble()
        outputLabel!!.text=number2digits.toString()
    }

    //Function to not only clear the screen but also operands
    fun clearScreen(view: View?) {
        calculator!!.clearOperands()
        outputLabel!!.text="0"
    }


}


