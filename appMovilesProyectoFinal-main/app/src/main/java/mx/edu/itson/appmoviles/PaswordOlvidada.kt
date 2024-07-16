package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PaswordOlvidada : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasword_olvidada)

        auth = Firebase.auth

        val btnChecar: Button = findViewById(R.id.btn_checar)

        btnChecar.setOnClickListener {
            //var intent: Intent = Intent(this, RestablecerPasword::class.java)
            //startActivity(intent)

            val et_usuario_contra_olvidada: EditText = findViewById(R.id.et_usuario_contra_olvidada)

            var usuario: String = et_usuario_contra_olvidada.text.toString()

            if (!usuario.isNullOrBlank()) {

                auth.sendPasswordResetEmail(usuario).addOnCompleteListener{ task ->

                    if(task.isSuccessful){
                        Toast.makeText(this,"Se envio un correo a $usuario",Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this,"Error al enviar correo",Toast.LENGTH_SHORT).show()
                    }

                }

            } else {
                Toast.makeText(this, "Ingrese correo electronico valido", Toast.LENGTH_SHORT).show()
            }
        }

        val ivRegresar: ImageView = findViewById(R.id.ivRegresarPass)

        ivRegresar.setOnClickListener {
            var intent: Intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }


    }
}