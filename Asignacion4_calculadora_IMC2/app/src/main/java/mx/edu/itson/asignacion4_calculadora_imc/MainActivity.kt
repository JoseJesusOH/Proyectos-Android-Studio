package mx.edu.itson.asignacion4_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    //Variables
    var IMC: Double = 0.0
    var peso: Double = 0.0
    var altura: Double = 0.0
    var new = false
    var rango:String = "Rango"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular: Button = findViewById(R.id.btnCalcular)
        val tvIMC: TextView = findViewById(R.id.imc)
        val weight: EditText = findViewById(R.id.weight)
        val height: EditText = findViewById(R.id.height)
        val tvRango: TextView = findViewById(R.id.rango)

        //evento button clic o cliclisterer
        calcular.setOnClickListener {


            if (weight.text.isEmpty() || height.text.isEmpty()) {
                tvIMC.setText("Ingrese un valor")
            } else {
                peso = weight.text.toString().toDouble()
                altura = height.text.toString().toDouble()

                IMC = peso / altura.pow(2)
                if(IMC<18.5){
                    rango = "Bajo peso"
                    tvRango.setBackgroundResource(R.color.colorGreenish)
                }else if(IMC>=18.5 && IMC<=24.9){
                    rango = "Normal"
                    tvRango.setBackgroundResource(R.color.colorGreen)
                }else if (IMC>=25 && IMC<=29.9){
                    rango = "Sobrepeso"
                    tvRango.setBackgroundResource(R.color.colorYellow)
                }else if (IMC>=30 && IMC<=34.9){
                    rango = "Obesidad grado 1"
                    tvRango.setBackgroundResource(R.color.colorOrange)
                } else if (IMC>=35 && IMC<=39.9){
                    rango = "Obesidad grado 2"
                    tvRango.setBackgroundResource(R.color.colorRed)
                } else {
                    rango = "Obesidad grado 3"
                    tvRango.setBackgroundResource(R.color.colorBrown)
                }
                tvIMC.setText(String.format("%.1f", IMC))
                tvRango.setText(rango)

            }


        }
    }



}