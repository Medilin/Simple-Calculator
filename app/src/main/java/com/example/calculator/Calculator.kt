package com.example.calculator
//Helper class to implement calculator functionality
class Calculator {
    var operand1=0.0
    var operand2=0.0
    var operator="!"
    private var nValue=0.0
    val value:Double
            get(){
                computeValue()
                return nValue
            }

    fun clearOperands(){
        operand1=0.0
        operand2=0.0
    }

    private fun computeValue(){
        nValue=0.0
        nValue=
            if(operator.contentEquals("+"))
                operand1 + operand2
            else if(operator.contentEquals("-"))
                operand1 - operand2
            else if(operator.contentEquals("/")&&operand2!=0.0)
                operand1 / operand2
            else if(operator.contentEquals("%"))
                operand1 % operand2
            else
                operand1*operand2

    }

}