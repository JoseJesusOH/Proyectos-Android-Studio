package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class RestablecerPasword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restablecer_pasword)


        val iv_regresar : ImageView = findViewById(R.id.iv_regresar_restablecer)
        val btn_restablecer : Button = findViewById(R.id.btn_restablecer_contraseña)

        iv_regresar.setOnClickListener{
            var intent: Intent = Intent(this, PaswordOlvidada::class.java)
            startActivity(intent)
        }

        btn_restablecer.setOnClickListener{
            var intent: Intent = Intent(this, Perfiles::class.java)
            startActivity(intent)
        }
    }
}