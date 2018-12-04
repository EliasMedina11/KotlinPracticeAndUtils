package com.cursokotlin.pruebaskot

import android.util.Log
import java.util.*

class Functions {

    private fun showCase1() {

        fun function1() {}
        val result1 = function1()

        fun function2(): Unit {}
        val result2: Unit = function1()

        fun function3(param1: String, param2: String): String {

            return "$param1, $param2"
        }

        val result3 = function3("String 1", "String 2")
        fun function4(param: Int = 5) {}
        fun function5(param: Int?) {}
    }

    private fun showCase2() {

        fun printSum(num1: Int, num2: Int, printer: (result: Int) -> Unit) {
            printer(num1 + num2)
        }
        printSum(5, 5) { result ->
            Log.w("FUNCTIONS-2", "LAMBDA EXPRESSION PRINTING TH SUM RESULT (10) => $result")
        }

        // Si el callback recibe solo un parametro, podemos omitir ese "result"

        printSum(12, 12) {
            Log.w("FUNCTIONS-2", "LAMBDA EXPRESSION PRINTING TH SUM RESULT (24) => $it")
        }

        fun printSum2(num1: Int, num2: Int, printer: (result: Int, param1: Int, param2: Int) -> Unit) {
            printer(num1 + num2, num1, num2)
        }

        printSum2(7, 7){ result, param1, param2 ->
            Log.w("FUNCTIONS-2" , "LAMDA EXPRESSION PRINTING THE SUM RESULT (14) => $result")

        }

        printSum2(7, 7){ result, _, _ ->
            Log.w("FUNCTIONS-2" , "LAMDA EXPRESSION PRINTING THE SUM RESULT (14) => $result")

        }
    }

    private fun showCase3(){
        //Named arguments

        fun function1 (firstName: String , lastName: String , age: Int , city: String , dateOfBirth: Date){

        }

        function1("","",27,"",Date())
        function1(age = 27 , dateOfBirth = Date() , firstName = "Elias" , city = "Mendoza" , lastName = "Medina")
    }

    private fun showCase4(){

        fun sum (param1: Int , param2: Int): Int {
            return param1 + param2
        }
        fun sum2 (param1: Int , param2: Int) = param1 + param2
    }

    private fun showCase5(){
        // Variable number of arguments (Varargs)
        fun sumAll(vararg  numbers: Int) = numbers.sum()

        val result = sumAll(1,2,3,4,5,6,7,8,9,10)
    }

    private fun showCase6 () {
        //Extension functions

        //Si es declarada dentro de este metodo, solo tenemos acceso a el en este mismo contexto de funcion

        fun String.welcome () {
            Log.w("Functions-6", "Welcome to kotlin and to Extension Functions!")
        }
        "".welcome()
        "".hola()

    }
}
fun String.hola (){
    println("hola")
}