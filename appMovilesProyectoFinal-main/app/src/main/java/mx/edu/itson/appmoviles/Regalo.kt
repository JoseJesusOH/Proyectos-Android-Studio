package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Regalo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalo)

        val perfil = intent.getSerializableExtra("perfil") as PerfilUsuario

        val iv_abrirRegalo: ImageView = findViewById(R.id.ivAbrirRegalo)

        iv_abrirRegalo.setOnClickListener {
            var intent: Intent = Intent(this, Regalo_abierto::class.java)
            intent.putExtra("perfil", perfil)
            startActivity(intent)
        }
    }
}