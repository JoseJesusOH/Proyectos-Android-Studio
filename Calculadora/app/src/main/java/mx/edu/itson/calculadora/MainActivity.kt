package mx.edu.itson.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var numeroActual: String="0"
    var detonante:Boolean=false
    var operacionActual:Int=-1

   fun numerousActual():Unit{
       val uno: Button =findViewById(R.id.btn1)
       val dos: Button =findViewById(R.id.btn2)
       val tres: Button =findViewById(R.id.btn3)
       val cuatro: Button =findViewById(R.id.btn4)
       val cinco: Button =findViewById(R.id.btn5)
       val seis: Button =findViewById(R.id.btn6)
       val siete: Button =findViewById(R.id.btn7)
       val ocho: Button =findViewById(R.id.btn8)
       val nueve: Button =findViewById(R.id.btn9)
       val cero: Button =findViewById(R.id.btn0)
       val error: TextView =findViewById(R.id.txError)

       val numero: TextView =findViewById(R.id.txNumero)

       uno.setOnClickListener {
          if(detonante==false){

           if(numeroActual.length==1){
               if(numeroActual=="0"){
                   numeroActual="1"
               }
               else{
                   numeroActual=numeroActual+"1"
               }
           }else{
               numeroActual=numeroActual+"1"
           }
           numero.setText(numeroActual)
          }else{
              if(operacionActual==-1){
                  val mensaje2="Aun no ha seleccionado una operacion"
                  error.text = mensaje2
              }else {
                  detonante = false
                  numeroActual = "1"
                  numero.setText(numeroActual)
              }
          }
       }
       dos.setOnClickListener {

           if(detonante==false){

               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="2"
                   }
                   else{
                       numeroActual=numeroActual+"2"
                   }
               }else{
                   numeroActual=numeroActual+"2"
               }
               numero.setText(numeroActual)
           }else{
               if(operacionActual==-1){
                   val mensaje2="Aun no ha seleccionado una operacion"
                   error.text = mensaje2
               }else {
                   detonante = false
                   numeroActual = "2"
                   numero.setText(numeroActual)
               }
           }


       }
       tres.setOnClickListener {
           if(detonante==false){
               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="3"
                   }
                   else{
                       numeroActual=numeroActual+"3"
                   }
               }else{
                   numeroActual=numeroActual+"3"
               }
               numero.setText(numeroActual)
           }else{
               if(operacionActual==-1){
                   val mensaje2="Aun no ha seleccionado una operacion"
                   error.text = mensaje2
               }else{
               detonante=false
               numeroActual="3"
               numero.setText(numeroActual)
               }

           }


       }
       cuatro.setOnClickListener {

           if(detonante==false){
               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="4"
                   }
                   else{
                       numeroActual=numeroActual+"4"
                   }
               }else{
                   numeroActual=numeroActual+"4"
               }
               numero.setText(numeroActual)
           }else{
               if(operacionActual==-1){
                   val mensaje2="Aun no ha seleccionado una operacion"
                   error.text = mensaje2
               }else{
               detonante=false
               numeroActual="4"
               numero.setText(numeroActual)
               }
           }

       }
       cinco.setOnClickListener {
           if(detonante==false){
               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="5"
                   }
                   else{
                       numeroActual=numeroActual+"5"
                   }
               }else{
                   numeroActual=numeroActual+"5"
               }
               numero.setText(numeroActual)
           }else{
               if(operacionActual==-1){
                   val mensaje2="Aun no ha seleccionado una operacion"
                   error.text = mensaje2
               }else{
               detonante=false
               numeroActual="5"
               numero.setText(numeroActual)
               }
           }

       }
       seis.setOnClickListener {
           if(detonante==false){
               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="6"
                   }
                   else{
                       numeroActual=numeroActual+"6"
                   }
               }else{
                   numeroActual=numeroActual+"6"
               }
               numero.setText(numeroActual)
           }else{     if(operacionActual==-1){
               val mensaje2="Aun no ha seleccionado una operacion"
               error.text = mensaje2
           }else{
               detonante=false
               numeroActual="6"
               numero.setText(numeroActual)
           }
           }

       }
       siete.setOnClickListener {
           if(detonante==false){
               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="7"
                   }
                   else{
                       numeroActual=numeroActual+"7"
                   }
               }else{
                   numeroActual=numeroActual+"7"
               }
               numero.setText(numeroActual)
           }else{
               if(operacionActual==-1){
                   val mensaje2="Aun no ha seleccionado una operacion"
                   error.text = mensaje2
               }else{
               detonante=false
               numeroActual="7"
               numero.setText(numeroActual)
               }
           }

       }
       ocho.setOnClickListener {
           if(detonante==false){
               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="8"
                   }
                   else{
                       numeroActual=numeroActual+"8"
                   }
               }else{
                   numeroActual=numeroActual+"8"
               }
               numero.setText(numeroActual)
           }else{
               if(operacionActual==-1){
                   val mensaje2="Aun no ha seleccionado una operacion"
                   error.text = mensaje2
               }else{
               detonante=false
               numeroActual="8"
               numero.setText(numeroActual)
               }
           }

       }
       nueve.setOnClickListener {
           if(detonante==false){
               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="9"
                   }
                   else{
                       numeroActual=numeroActual+"9"
                   }
               }else{
                   numeroActual=numeroActual+"9"
               }
               numero.setText(numeroActual)
           }else{
               if(operacionActual==-1){
                   val mensaje2="Aun no ha seleccionado una operacion"
                   error.text = mensaje2
               }else{
               detonante=false
               numeroActual="9"
               numero.setText(numeroActual)
               }
           }

       }
       cero.setOnClickListener {
           if(detonante==false){
               if(numeroActual.length==1){
                   if(numeroActual=="0"){
                       numeroActual="0"
                   }
                   else{
                       numeroActual=numeroActual+"0"
                   }
               }else{
                   numeroActual=numeroActual+"O"
               }
               numero.setText(numeroActual)
           }else{
               if(operacionActual==-1){
                   val mensaje2="Aun no ha seleccionado una operacion"
                   error.text = mensaje2
               }else{
               detonante=false
               numeroActual="0"
               numero.setText(numeroActual)
               }
           }

       }
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numerousActual()
        operacion()
        resultado()
    }
    var numeroA:Double=0.0
    var numeroB:Double=0.0
    fun resultado():Unit{
        val result: Button =findViewById(R.id.btnResult)
        val borrar: Button =findViewById(R.id.btnBorrar)
        val error: TextView =findViewById(R.id.txError)
        val total: TextView =findViewById(R.id.txTotal)
        val numero: TextView =findViewById(R.id.txNumero)
        result.setOnClickListener {
            if(operacionActual==-1){
                val mensaje2="Aun no ha seleccionado una operacion"
                error.text = mensaje2
            }

            if(operacionActual==1){
                numeroA=total.text.substring(0,total.text.length-1).toDouble()
                numeroB=numero.text.toString().toDouble()
                total.setText((numeroA+numeroB).toString())
                numeroActual=(numeroA+numeroB).toString()
                numero.setText("0")
                detonante=true
                operacionActual=-1
            }

            if(operacionActual==2){
                numeroA=total.text.substring(0,total.text.length-1).toDouble()
                numeroB=numero.text.toString().toDouble()
                total.setText((numeroA-numeroB).toString())
                numeroActual=(numeroA-numeroB).toString()
                numero.setText("0")
                detonante=true
                operacionActual=-1
            }

            if(operacionActual==3){
                numeroA=total.text.substring(0,total.text.length-1).toDouble()
                numeroB=numero.text.toString().toDouble()
                total.setText((numeroA*numeroB).toString())
                numeroActual=(numeroA*numeroB).toString()
                numero.setText("0")
                detonante=true
                operacionActual=-1
            }
              if(operacionActual==4){
                  numeroA=total.text.substring(0,total.text.length-1).toDouble()
                  numeroB=numero.text.toString().toDouble()
                  if(numeroB==0.0){
                      error.text="No se puede dividir entre 0, borre lo realizado"
                  }else{
                      if(numeroA==0.0){
                          total.setText(("0").toString())
                          numeroActual=("0").toString()
                          operacionActual=-1
                          numero.setText("0")
                      }else{
                      total.setText((numeroA/numeroB).toString())
                      numeroActual=(numeroA/numeroB).toString()
                      operacionActual=-1
                      numero.setText("0")
                      }
                      detonante=true
                  }
            }
        }
        borrar.setOnClickListener {
            numero.setText("")
            total.setText("")
            error.setText("")
            numeroActual="0"
            operacionActual=-1;
            detonante=false
        }
    }

    fun operacion():Unit{
        val total: TextView =findViewById(R.id.txTotal)
        val error: TextView =findViewById(R.id.txError)
        val numero: TextView =findViewById(R.id.txNumero)
        val mas: Button =findViewById(R.id.btnMas)
        val menos: Button =findViewById(R.id.btnMenos)
        val dividir: Button =findViewById(R.id.btnDividir)
        val multiplicar: Button =findViewById(R.id.btnMultiplicar)
        mas.setOnClickListener {
            if(operacionActual==-1) {

                total.setText(numeroActual.plus("+") )
                operacionActual = 1
                numero.setText("0")
               numeroActual="0"
            }else{
                total.setText(total.text.substring(0,total.text.length-1).toString().plus("+") )
                operacionActual = 1
                numero.setText("0")
                numeroActual="0"
            }
            error.setText("")
        }
        menos.setOnClickListener {
            if(operacionActual==-1) {
                total.setText(numeroActual.plus("-") )
                operacionActual = 2
                numero.setText("0")
                numeroActual="0"
            }else{
                total.setText(total.text.substring(0,total.text.length-1).toString().plus("-") )
                operacionActual = 2
                numero.setText("0")
                numeroActual="0"

            }
            error.setText("")

        }

        multiplicar.setOnClickListener {
            if(operacionActual==-1) {
                total.setText(numeroActual.plus("*") )
                operacionActual=3
                numero.setText("0")
                numeroActual="0"
            }else{
                total.setText(total.text.substring(0,total.text.length-1).toString().plus("*") )
                operacionActual=3
                numero.setText("0")
                numeroActual="0"
            }
            error.setText("")

        }

        dividir.setOnClickListener {
            if(operacionActual==-1) {
                total.setText(numeroActual.plus("/") )
                operacionActual = 4
                numero.setText("0")
                numeroActual="0"
            }else{
                total.setText(total.text.substring(0,total.text.length-1).toString().plus("/") )
                operacionActual = 4
                numeroActual="0"
                numero.setText("0")
            }
            error.setText("")

        }
    }

}




