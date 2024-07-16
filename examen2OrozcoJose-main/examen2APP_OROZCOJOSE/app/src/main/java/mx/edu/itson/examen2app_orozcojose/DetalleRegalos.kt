package mx.edu.itson.examen2app_orozcojose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetalleRegalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_regalos)

        val imagen = intent.getIntExtra("imagen",0)
        val imageView:ImageView = findViewById(R.id.iv_regalo_imagen)
        imageView.setImageResource(imagen)

        val nombre = intent.getStringExtra("nombre" )
        val nombreText:TextView = findViewById(R.id.tv_regalo_nombre)
        nombreText.setText(nombre+" :")

        val precio = intent.getStringExtra("precio" )
        val precioText:TextView = findViewById(R.id.tv_regalo_precio)
        precioText.setText(" $"+precio+".0")

    }
}