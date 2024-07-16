package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FinLectura : AppCompatActivity() {

    var perfil: PerfilUsuario? = null
    var historia: Historia? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fin_lectura)
        perfil = intent.getSerializableExtra("perfil") as PerfilUsuario
        historia = intent.getSerializableExtra("historia") as Historia

        val btn_estoy_listo: Button = findViewById(R.id.btnestoyListo)

        btn_estoy_listo.setOnClickListener {
            var intent: Intent = Intent(this,Actividad::class.java)
            intent.putExtra("perfil",perfil)
            intent.putExtra("historia",historia)
            startActivity(intent)
        }

        val btn_ahora_no: Button = findViewById(R.id.btnAhoraNo)

        btn_ahora_no.setOnClickListener {
            var intent: Intent = Intent(this,Menu::class.java)
            intent.putExtra("perfil", perfil)
            startActivity(intent)
        }
    }
}