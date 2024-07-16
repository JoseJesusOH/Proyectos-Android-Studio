package mx.edu.itson.asignacion4_calculadoraimc_apellido

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    var IMC: Double = 0.0
    var peso: Double = 0.0
    var altura: Double = 0.0
    var new = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcularBoton: Button = findViewById(R.id.btnCalcular)
        val txvIMC: TextView = findViewById(R.id.tvIMC)
        val txvRange: TextView = findViewById(R.id.tvRange)

        val entradaPeso: EditText = findViewById(R.id.etPeso)
        val entradaEstatura: EditText = findViewById(R.id.etEstatura)


        calcularBoton.setOnClickListener {


            if (entradaPeso.text.isEmpty() || entradaEstatura.text.isEmpty()) {
                txvIMC.setText("No se ha introducido el peso o la estatura.")
            } else {
                peso = entradaPeso.text.toString().toDouble()
                altura = entradaEstatura.text.toString().toDouble()

                IMC = peso / altura.pow(2)
                if(IMC<18.5){
                    txvIMC.setText(String.format("%.2f", IMC))
                  txvRange.setText("Bajo Peso")
                    txvRange.setBackgroundResource(R.color.purple_200)
                }
                else if(IMC>=18.5 && IMC<=24.9){
                    txvIMC.setText(String.format("%.2f", IMC))
                    txvRange.setText("Normal")
                    txvRange.setBackgroundResource(R.color.colorGreen)
                }
                else if(IMC>=25 && IMC<=29.9){
                    txvIMC.setText(String.format("%.2f", IMC))
                    txvRange.setText("Sobrepeso")
                    txvRange.setBackgroundResource(R.color.colorYellow)
                }
                else if(IMC>=30 && IMC<=34.9){
                    txvIMC.setText(String.format("%.2f", IMC))
                    txvRange.setText("Obesidad Grado 1")
                    txvRange.setBackgroundResource(R.color.colorOrange)
                }
                else if(IMC>=35 && IMC<=39.9){
                    txvIMC.setText(String.format("%.2f", IMC))
                    txvRange.setText("Obesidad Grado 2")
                    txvRange.setBackgroundResource(R.color.colorBrown)
                }
                else if(IMC>=40){
                    txvIMC.setText(String.format("%.2f", IMC))
                    txvRange.setText("Obesidad Grado 3")
                    txvRange.setBackgroundResource(R.color.colorRed)
                }
            }
        }
    }

}