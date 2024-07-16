package mx.edu.itson.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var uno:Button=findViewById(R.id.btn1)
    var dos:Button=findViewById(R.id.btn2)
    var tres:Button=findViewById(R.id.btn3)
    var cuatro:Button=findViewById(R.id.btn4)
    var cinco:Button=findViewById(R.id.btn5)
    var seis:Button=findViewById(R.id.btn6)
    var siete:Button=findViewById(R.id.btn7)
    var ocho:Button=findViewById(R.id.btn8)
    var nueve:Button=findViewById(R.id.btn9)
    var cero:Button=findViewById(R.id.btn0)

    var result:Button=findViewById(R.id.btnResult)
    var borrar:Button=findViewById(R.id.btnBorrar)

    var mas:Button=findViewById(R.id.btnMas)
    var menos:Button=findViewById(R.id.btnMenos)
    var dividir:Button=findViewById(R.id.btnDividir)
    var multiplicar:Button=findViewById(R.id.btnMultiplicar)

    var total:TextView=findViewById(R.id.txTotal)
    var numero:TextView=findViewById(R.id.txNumero)
    var error:TextView=findViewById(R.id.txError)
    /*
    1=Suma
    2=Resta
    3=Multiplicacion
    4=Division
    -1=Sin operacion selecionada
     */
    var operacionActual:Int=-1;
    var numeroActual: String="0";
    var numeroPosterior: String="0";
    var numeroA: Double=0.0;
    var numeroB: Double=0.0;

    var valorActual:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numerousActual()
        mas.setOnClickListener {
           if(operacionActual==-1) {
               total.setText(numeroActual + "+")
               operacionActual = 1
               numero.setText("0")
           }else
               if(numero.toString()=="0"){
                   total.setText(numeroActual+"*")
                   operacionActual=1

               }
        }
        menos.setOnClickListener {
            if(operacionActual==-1) {
                total.setText(numeroActual + "-")
                operacionActual = 2
                numero.setText("0")
            }else
                if(numero.toString()=="0"){
                    total.setText(numeroActual+"*")
                    operacionActual=2

                }
        }

        multiplicar.setOnClickListener {

            if(operacionActual==-1) {
                total.setText(numeroActual+"*")
                operacionActual=3
                numero.setText("0")
            }
            else
                if(numero.toString()=="0"){
                    total.setText(numeroActual+"*")
                    operacionActual=3

            }

        }

        dividir.setOnClickListener {
            if(operacionActual==-1) {
                total.setText(numeroActual + "/")
                operacionActual = 4
                numero.setText("0")
            }else
                if(numero.toString()=="0"){
                    total.setText(numeroActual+"*")
                    operacionActual=4
                }
        }
        result.setOnClickListener {
          if(operacionActual==1){
              total.setText((total.toString().substring(0,  numeroActual.length - 1).toDouble()+numero.toString().toDouble()).toString())
              operacionActual=-1
          }
            if(operacionActual==2){
                total.setText((total.toString().substring(0,  numeroActual.length - 1).toDouble()-numero.toString().toDouble()).toString())
                operacionActual=-1
            }
            if(operacionActual==3){
                total.setText((total.toString().substring(0,  numeroActual.length - 1).toDouble()*numero.toString().toDouble()).toString())
                operacionActual=-1
            }
            if(operacionActual==4){
                if(numero.toString().toDouble()==0.0){
                    error.setText("No se puede dividir por cero")
                }
                total.setText((total.toString().substring(0,  numeroActual.length - 1).toDouble()/numero.toString().toDouble()).toString())
                operacionActual=-1
            }
            if(operacionActual==-1){
                error.setText("Aun no ha seleccionado una operacion")

            }
        }
        borrar.setOnClickListener {
         numero.setText("")
            total.setText("")
            error.setText("")
            numeroActual="0"
        }

    }
    private fun numerousActual():Unit{
        uno.setOnClickListener {
            numeroActual+"1"
        }
        dos.setOnClickListener {
            numeroActual+"2"
        }
        tres.setOnClickListener {
            numeroActual+ "3"
        }
        cuatro.setOnClickListener {
            numeroActual+"4"
        }
        cinco.setOnClickListener {
            numeroActual+"5"
        }
        seis.setOnClickListener {
            numeroActual+"6"
        }
        siete.setOnClickListener {
            numeroActual+ "7"
        }
        ocho.setOnClickListener {
            numeroActual+ "8"
        }
        nueve.setOnClickListener {
            numeroActual+ "9"        }
        cero.setOnClickListener {
            if(numeroActual.length==1){
                if(numeroActual=="0"){
                    numeroActual="0"
                }
            }else{
                numeroActual+ "0"
            }
        }
        numero.setText(numeroActual)
    }



}