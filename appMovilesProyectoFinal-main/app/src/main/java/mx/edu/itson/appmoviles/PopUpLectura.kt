package mx.edu.itson.appmoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics

class PopUpLectura : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_lectura)

        val medidasVentana: DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(medidasVentana);

        var ancho: Int = medidasVentana.widthPixels;
        var alto: Int = medidasVentana.heightPixels

        window.setLayout((ancho).toInt(), (alto*0.45).toInt())
    }
}