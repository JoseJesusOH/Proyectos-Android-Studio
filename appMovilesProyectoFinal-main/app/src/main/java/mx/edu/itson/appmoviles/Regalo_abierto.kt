package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Regalo_abierto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalo_abierto)

        val perfil = intent.getSerializableExtra("perfil") as PerfilUsuario

        val iv_continuarRegaloA: Button = findViewById(R.id.btnContinuarRegaloAbierto)

        iv_continuarRegaloA.setOnClickListener {
            var intent: Intent = Intent(this, Menu::class.java)
            intent.putExtra("perfil", perfil)
            startActivity(intent)
        }
    }
}