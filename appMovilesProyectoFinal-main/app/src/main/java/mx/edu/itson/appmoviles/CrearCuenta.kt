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
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CrearCuenta : AppCompatActivity() {

    var et_crear_nombre: EditText? = null
    var et_crear_correo: EditText? = null
    var et_crear_contra: EditText? = null
    var et_crear_contra_confirmar: EditText? = null


    //realtime database
    private var userRef = FirebaseDatabase.getInstance().getReference("usuarios")

    //logeo
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        auth = Firebase.auth

        val ivRegresar: ImageView = findViewById(R.id.ivRegresarCrear)
        val btnRegistrase: Button = findViewById(R.id.btnCrearRegistrarse)

        ivRegresar.setOnClickListener {
            var intent: Intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }

        btnRegistrase.setOnClickListener {
            //var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            //startActivity(intent)
            valida_registro()
        }
    }

    private fun valida_registro() {

        et_crear_nombre = findViewById(R.id.etCrearNombre)
        et_crear_correo = findViewById(R.id.etCrearCorreoE)
        et_crear_contra = findViewById(R.id.etCrearContrasenia)
        et_crear_contra_confirmar = findViewById(R.id.etCrearContraseniaConfirmar)

        var nombre: String = et_crear_nombre?.text.toString()
        var correo: String = et_crear_correo?.text.toString()
        var contra1: String = et_crear_contra?.text.toString()
        var contra2: String = et_crear_contra_confirmar?.text.toString()

        val usuario = Usuario(

            nombre,
            correo
        )

        if (!nombre.isNullOrBlank() && !correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank()
        ) {
            if (contra1 == contra2) {
                registrarFirebase(correo, contra1)
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser


                    Toast.makeText(
                        baseContext,
                        "${user?.email} Se ha creado correctamente, puede inciar sesión.",
                        Toast.LENGTH_SHORT
                    ).show()
                    var uid = user?.uid.toString()
                    saveMarkFromForm(uid)
                    userRef.addChildEventListener(object : ChildEventListener {
                        override fun onCancelled(databaseError: DatabaseError) {}
                        override fun onChildMoved(
                            dataSnapshot: DataSnapshot,
                            previusName: String?
                        ) {
                        }

                        override fun onChildChanged(
                            dataSnapshot: DataSnapshot,
                            previusName: String?
                        ) {
                        }

                        override fun onChildRemoved(snapshot: DataSnapshot) {}

                        override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
                            //val usuario = dataSnapshot.getValue(User::class.java)
                            //if (usuario != null) writeMark(usuario)
                        }

                    })
                    limpiarCampos()


                    //updateUI(user)
                } else if (task.exception.toString() == "com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account.") {

                    Toast.makeText(
                        baseContext, "Correo ya registrado",
                        Toast.LENGTH_SHORT
                    ).show()


                } else {

                    Toast.makeText(
                        baseContext, task.exception.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }

    private fun limpiarCampos() {
        et_crear_contra?.setText("")
        et_crear_nombre?.setText("")
        et_crear_correo?.setText("")
        et_crear_contra_confirmar?.setText("")
    }

    private fun saveMarkFromForm(uid: String) {

        et_crear_nombre = findViewById(R.id.etCrearNombre)
        et_crear_correo = findViewById(R.id.etCrearCorreoE)


        val usuario = Usuario(
            uid = uid,
            correoElectronico = et_crear_correo?.text.toString(),
            nombreUsuario = et_crear_nombre?.text.toString(),

        )


        userRef.child(uid).setValue(usuario)

        val intent: Intent = Intent(this, ConfigurarPerfil::class.java)
        intent.putExtra("uid", uid)
        startActivity(intent)
    }

    /*
    private fun writeMark(mark: User){
        var listV: TextView = findViewById(R.id.list_textView) as TextView
        val text = listV .text.toString() + mark.toString() + "\n"
        listV.text = text
    }

     */
}