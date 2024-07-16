package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Actividad_Fallida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_fallida)

        val perfil = intent.getSerializableExtra("perfil") as PerfilUsuario
        val historia = intent.getSerializableExtra("historia") as Historia

        val btn_ahoraNO: Button = findViewById(R.id.btnAhoraNo)
        val btn_seguirpracticando: Button = findViewById(R.id.btnSeguirPracticando)

        btn_ahoraNO.setOnClickListener {
            var intent: Intent = Intent(this, Menu::class.java)
            intent.putExtra("perfil", perfil)
            startActivity(intent)
        }

        btn_seguirpracticando.setOnClickListener {
            var intent: Intent = Intent(this, Actividad::class.java)
            intent.putExtra("perfil", perfil)
            intent.putExtra("historia", historia)
            startActivity(intent)
        }
    }
}