package mx.edu.itson.appmoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics

class PopUpMedallaInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_medalla_info)

        val medidasVentana: DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(medidasVentana);

        var ancho: Int = medidasVentana.widthPixels;
        var alto: Int = medidasVentana.heightPixels

        window.setLayout((ancho*0.80).toInt(), (alto*0.15).toInt())
    }
}