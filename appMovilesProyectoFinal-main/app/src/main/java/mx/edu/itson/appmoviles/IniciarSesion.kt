package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class IniciarSesion : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private var userRef = FirebaseDatabase.getInstance().getReference("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        auth = Firebase.auth

        val btnIniciarSesion: Button = findViewById(R.id.btn_iniciar_sesion)


        val tvolvide_Pass: TextView = findViewById(R.id.tvOlvidePass)
        val btnRegistrarse: Button = findViewById(R.id.btn_registrarse)


        btnIniciarSesion.setOnClickListener {
            valida_ingreso()
        }

        tvolvide_Pass.setOnClickListener {
            //var intent: Intent = Intent(this, PaswordOlvidada::class.java)
            var intent: Intent = Intent(this, PaswordOlvidada::class.java)
            startActivity(intent)
        }

        btnRegistrarse.setOnClickListener {
            var intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }


    }

    private fun valida_ingreso() {

        val etUsuario: EditText = findViewById(R.id.et_usuario_inicio)
        val etContrasenia: EditText = findViewById(R.id.et_contraseña_inicio)

        var usuario: String = etUsuario.text.toString()
        var contrasenia: String = etContrasenia.text.toString()

        if (!usuario.isNullOrBlank() && !contrasenia.isNullOrBlank()) {
            ingresarFirebase(usuario, contrasenia)
        } else {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
        }


    }

    private fun ingresarFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser

                    val uid = user?.uid.toString()

/*
                    var usuario = Usuario(
                        uid = uid,
                        correoElectronico = "",
                        nombreUsuario = "",
                        perfiles = arrayListOf(
                            PerfilUsuario(
                                "jose", 21, R.drawable.perfiloficial1,
                                arrayListOf(1, 2, 3, 4),
                                arrayListOf(0, 0, 0, 0)
                            ),
                            PerfilUsuario(
                                "giovanni", 37, R.drawable.perfiloficial2,
                                arrayListOf(1, 2, 3, 4),
                                arrayListOf(0, 0, 0, 0)
                            ),
                            PerfilUsuario(
                                "josegiovanni", 58, R.drawable.perfiloficial3,
                                arrayListOf(1, 2, 3, 4),
                                arrayListOf(0, 0, 0, 0)
                            )
                        )
                    )

 */


                    val intent: Intent = Intent(this, Perfiles::class.java)
                    startActivity(intent)


                    /*
                    userRef.child(uid).get().addOnSuccessListener { dataSnapshot ->
                        if (dataSnapshot.exists()){
                            val usuario = dataSnapshot.getValue(Usuario::class.java)
                            val intent: Intent = Intent(this, Perfiles::class.java)
                            intent.putExtra("usuario", usuario)
                            startActivity(intent)
                        }
                    }

                     */


                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }

    fun obterUsuario(uid: String) {

        userRef.child(uid).get().addOnSuccessListener { dataSnapshot ->
            if (dataSnapshot.exists()) {
                val usuario = dataSnapshot.getValue(Usuario::class.java)
                println("El usuario leido : ${usuario}")
            }
        }

    }


}