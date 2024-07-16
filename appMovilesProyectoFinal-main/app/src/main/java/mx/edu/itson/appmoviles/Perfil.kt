package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val imgConfiguracion: ImageView = findViewById(R.id.img_configuracion_perfil)

        imgConfiguracion.setOnClickListener{
            var intent: Intent = Intent(this, Configuracion::class.java)
            startActivity(intent)
        }
    }
}