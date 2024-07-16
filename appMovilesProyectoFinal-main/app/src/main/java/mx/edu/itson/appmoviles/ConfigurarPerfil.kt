package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class ConfigurarPerfil : AppCompatActivity() {

    var et_configura_nombre: EditText? = null
    var et_configura_edad: TextView? = null
    var imagenesPerfil = ArrayList<Int>()
    var imagenPerfil: Int = 1
    private lateinit var auth: FirebaseAuth


    //realtime database
    private var userRef = FirebaseDatabase.getInstance().getReference("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_perfil)
        auth = Firebase.auth


        val iv_regresar: ImageView = findViewById(R.id.iv_regresar_configurar_perfil)
        val btn_siguiente: Button = findViewById(R.id.btnSiguienteConfiPerfil)
        val mas_edad: ImageView = findViewById(R.id.ivMasEdad)
        val menos_edad: ImageView = findViewById(R.id.ivMenosEdad)
        val siguiente_imagen_perfil: ImageView = findViewById(R.id.ivSiguienteImgPerfil)
        val anterior_imagen_perfil: ImageView = findViewById(R.id.ivAnteriorImgPerfil)
        val imagen_perfil: ImageView = findViewById(R.id.ivImagenPerfil)

        if(intent.hasExtra("perfil")){
            et_configura_nombre= findViewById(R.id.et_configura_nombre)
            et_configura_edad = findViewById(R.id.tv_configurar_edad)
            val perfil = intent.getSerializableExtra("perfil") as PerfilUsuario
            et_configura_nombre?.setText(perfil.nombre.toString())
            et_configura_edad?.setText(perfil.edad.toString())



        }


        cargarImgPerfiles()


        siguiente_imagen_perfil.setOnClickListener {
            imagenPerfil++
            if (imagenPerfil > (imagenesPerfil.size - 1)) {
                imagenPerfil = 0
            }

            imagen_perfil.setImageResource(imagenesPerfil.get(imagenPerfil))

        }

        anterior_imagen_perfil.setOnClickListener {
            imagenPerfil--
            if (imagenPerfil < 0) {
                imagenPerfil = 2
            }

            imagen_perfil.setImageResource(imagenesPerfil.get(imagenPerfil))
        }


        mas_edad.setOnClickListener {
            et_configura_edad = findViewById(R.id.tv_configurar_edad)
            var edadUser = et_configura_edad?.text.toString().toInt()
            edadUser++
            et_configura_edad?.setText(edadUser.toString())
        }

        menos_edad.setOnClickListener {
            et_configura_edad = findViewById(R.id.tv_configurar_edad)
            var edadUser = et_configura_edad?.text.toString().toInt()
            if (edadUser > 4) {
                edadUser--
            }

            et_configura_edad?.setText(edadUser.toString())
        }

        iv_regresar.setOnClickListener {
            var intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }

        btn_siguiente.setOnClickListener {


            var uid = auth.uid.toString()

            validaPerfil(uid)
            limpiarCapmpos()


        }


    }


    private fun validaPerfil(uid: String) {
        et_configura_nombre = findViewById(R.id.et_configura_nombre)
        et_configura_edad = findViewById(R.id.tv_configurar_edad)

        var nombre: String = et_configura_nombre?.text.toString()
        var edad: String = et_configura_edad?.text.toString()


        if (!nombre.isNullOrBlank() && !edad.isNullOrBlank()) {
            agregarPerfilFirebase(nombre, edad.toInt(), imagenPerfil, uid)
        } else {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun agregarPerfilFirebase(nombre: String, edad: Int, imagen: Int, uid: String) {

        var imagen2 = 0

        when (imagen) {
            0 -> imagen2 = R.drawable.perfilfull1
            1 -> imagen2 = R.drawable.perfilfull2
            2 -> imagen2 = R.drawable.perfilfull3
        }


        userRef.child(uid).child("perfiles")
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val perfilesList = mutableListOf<PerfilUsuario>()
                    for (ds in dataSnapshot.children) {
                        val nombre = ds.child("nombre").value as String
                        val edad = ds.child("edad").value as Long
                        val imagen = ds.child("imagen").value as Long
                        val perfilUsuario = PerfilUsuario(nombre, edad.toInt(), imagen.toInt())

                        perfilesList.add(perfilUsuario)
                    }

                    perfilesList.add(PerfilUsuario(nombre, edad, imagen2))
                    var numPerfil = perfilesList.size - 1

                    val perfil = HashMap<String, Any>()
                    perfil["nombre"] = nombre
                    perfil["edad"] = edad
                    perfil["imagen"] = imagen2
                    perfil["numPerfil"] = numPerfil

                    if(intent.hasExtra("perfil")){

                        val perfilUp = intent.getSerializableExtra("perfil") as PerfilUsuario
                        val perfil = HashMap<String, Any>()
                        perfil["nombre"] = nombre
                        perfil["edad"] = edad
                        perfil["imagen"] = imagen2
                        perfil["numPerfil"] = perfilUp.numPerfil!!.toInt()
                        userRef.child(uid).child("perfiles").child(perfilUp.numPerfil.toString())
                            .updateChildren(perfil).addOnSuccessListener {
                                // El registro ha sido actualizado correctamente
                            }
                            .addOnFailureListener {
                                // Se produjo un error al actualizar el registro
                            }
                        //userRef.child(uid).child("perfiles").updateChildren(perfilesList)

                        enviarInfo(uid, perfilUp.numPerfil.toString())

                    }else{
                        userRef.child(uid).child("perfiles").child(numPerfil.toString())
                            .updateChildren(perfil).addOnSuccessListener {
                                // El registro ha sido actualizado correctamente
                            }
                            .addOnFailureListener {
                                // Se produjo un error al actualizar el registro
                            }
                        //userRef.child(uid).child("perfiles").updateChildren(perfilesList)

                        enviarInfo(uid, numPerfil.toString())
                    }




                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })


    }

    fun cargarImgPerfiles() {
        imagenesPerfil.add(R.drawable.perfilfull1)
        imagenesPerfil.add(R.drawable.perfilfull2)
        imagenesPerfil.add(R.drawable.perfilfull3)
    }

    fun enviarInfo(uid: String, numPerfil: String) {
        val intent: Intent = Intent(this, Temas::class.java)
        intent.putExtra("uid", uid)
        intent.putExtra("numPerfil", numPerfil)
        startActivity(intent)
    }

    fun limpiarCapmpos() {
        var nombre: String = et_configura_nombre?.text.toString()
        var edad: String = et_configura_edad?.text.toString()
        imagenPerfil = 1

    }
}