package mx.edu.itson.practica8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        var buttonDetalles: Button =findViewById(R.id.btn_detalles)
        buttonDetalles.setOnClickListener {
            var intento= Intent(this, Regalos::class.java)
            intento.putExtra("click","detalles")
            this.startActivity(intento)
        }
        var buttonGlobos: Button =findViewById(R.id.btn_globos)
        buttonGlobos.setOnClickListener {
            var intento= Intent(this, Regalos::class.java)
            intento.putExtra("click","globos")
            this.startActivity(intento)
        }
        var buttonPeluches: Button =findViewById(R.id.btn_peluches)
        buttonPeluches.setOnClickListener {
            var intento= Intent(this, Regalos::class.java)
            intento.putExtra("click","peluches")
            this.startActivity(intento)
        }
        var buttonRegalos: Button =findViewById(R.id.btn_regalos)
        buttonRegalos.setOnClickListener {
            var intento= Intent(this, Regalos::class.java)
            intento.putExtra("click","regalos")
            this.startActivity(intento)
        }
        var buttonTazas: Button =findViewById(R.id.btn_tazas)
        buttonTazas.setOnClickListener {
            var intento= Intent(this, Regalos::class.java)
            intento.putExtra("click","tazas")
            this.startActivity(intento)
        }
    }
}