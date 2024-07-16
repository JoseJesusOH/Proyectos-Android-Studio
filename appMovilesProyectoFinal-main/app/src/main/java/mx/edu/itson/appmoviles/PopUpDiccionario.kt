package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics

class PopUpDiccionario: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_diccionario)

        val medidasVentana: DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(medidasVentana);

        var ancho: Int = medidasVentana.widthPixels;
        var alto: Int = medidasVentana.heightPixels

        window.setLayout((ancho*0.75).toInt(), (alto*0.35).toInt())



    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}