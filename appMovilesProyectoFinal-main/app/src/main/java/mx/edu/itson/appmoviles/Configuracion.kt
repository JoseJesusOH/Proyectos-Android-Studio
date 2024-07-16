package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Configuracion : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        auth = Firebase.auth

        val btn_ayuda: Button = findViewById(R.id.buttonAyuda)
        val iv_regresar: ImageView = findViewById(R.id.ivRegresarConfiguracion)
        val btn_editar_perfil: Button = findViewById(R.id.btnEditarPerfil)
        val btn_cambiar_perfil: Button = findViewById(R.id.btnCambiarPerfil)
        val btn_cerrar_sesion: Button = findViewById(R.id.btnCerrarSesion)
        val perfil = intent.getSerializableExtra("perfil") as PerfilUsuario



        btn_ayuda.setOnClickListener {
            var intent: Intent = Intent(this, Faq::class.java)
            startActivity(intent)
        }

        iv_regresar.setOnClickListener {
            var intent: Intent = Intent(this, Menu::class.java)
            intent.putExtra("perfil",perfil)
            startActivity(intent)

        }
        btn_cambiar_perfil.setOnClickListener {
            var intent: Intent = Intent(this, Perfiles::class.java)
            startActivity(intent)

        }
        btn_editar_perfil.setOnClickListener {
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            intent.putExtra("perfil",perfil)
            startActivity(intent)

        }

        btn_cerrar_sesion.setOnClickListener {
            auth.signOut()
            var intent: Intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }
    }

}