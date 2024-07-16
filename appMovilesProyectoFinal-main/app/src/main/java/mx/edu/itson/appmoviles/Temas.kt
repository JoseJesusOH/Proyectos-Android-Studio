package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class Temas : AppCompatActivity() {

    var btnDeportes: Button? = null
    var btnAnimales: Button? = null
    var btnMagia: Button? = null
    var btnVideojuegos: Button? = null
    var btnMusical: Button? = null
    var btnAventuras: Button? = null
    var t1 = 0
    var t2 = 0
    var t3 = 0
    var t4 = 0
    var t5 = 0
    var t6 = 0

    var uid: String? = null
    var numPerfil: String? = null
    var temasFavoritos = ArrayList<String>()

    private var userRef = FirebaseDatabase.getInstance().getReference("usuarios")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temas)

        uid = intent.getSerializableExtra("uid") as String
        numPerfil = intent.getSerializableExtra("numPerfil") as String


        val btn_listo: Button = findViewById(R.id.btn_listo)
        val btn_regresar: ImageView = findViewById(R.id.btn_regresar)

        btn_listo.setOnClickListener {

            userRef.child(uid!!).child("perfiles").child(numPerfil!!).child("temasFavoritos")

                .setValue(temasFavoritos)
            limpiarCategoria()

            var intent: Intent = Intent(this, Menu::class.java)
            enviarInfo(uid!!, numPerfil!!.toInt())
        }
        btn_regresar.setOnClickListener {
            limpiarCategoria()
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            startActivity(intent)
        }
    }

    fun agregaCategoria(view: View) {


        when (view.id) {

            R.id.btn_deportes -> {
                btnDeportes = findViewById(R.id.btn_deportes)

                if (t1 == 0) {
                    btnDeportes?.setBackgroundResource(R.drawable.botontemaselectable2)
                    btnDeportes?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)
                    btnDeportes?.setTextColor(getResources().getColor(R.color.dark_blue))
                    temasFavoritos.add("Deportes")
                    t1++
                } else {
                    t1 = 0
                    btnDeportes?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
                    btnDeportes?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
                    btnDeportes?.setTextColor(getResources().getColor(R.color.deep_gray))
                    temasFavoritos.remove("Deportes")
                }

            }
            R.id.btn_animales -> {
                btnAnimales = findViewById(R.id.btn_animales)

                if (t2 == 0) {
                    btnAnimales?.setBackgroundResource(R.drawable.botontemaselectable2)
                    btnAnimales?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)
                    btnAnimales?.setTextColor(getResources().getColor(R.color.dark_blue))
                    temasFavoritos.add("Animales")
                    t2++
                } else {
                    t2 = 0
                    btnAnimales?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
                    btnAnimales?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
                    btnAnimales?.setTextColor(getResources().getColor(R.color.deep_gray))
                    temasFavoritos.remove("Animales")
                }

            }
            R.id.btn_magia -> {
                btnMagia = findViewById(R.id.btn_magia)

                if (t3 == 0) {
                    btnMagia?.setBackgroundResource(R.drawable.botontemaselectable2)
                    btnMagia?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)
                    btnMagia?.setTextColor(getResources().getColor(R.color.dark_blue))
                    temasFavoritos.add("Magia")
                    t3++
                } else {
                    t3 = 0
                    btnMagia?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
                    btnMagia?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
                    btnMagia?.setTextColor(getResources().getColor(R.color.deep_gray))
                    temasFavoritos.remove("Magia")
                }
            }
            R.id.btn_videojuegos -> {
                btnVideojuegos = findViewById(R.id.btn_videojuegos)

                if (t4 == 0) {
                    btnVideojuegos?.setBackgroundResource(R.drawable.botontemaselectable2)
                    btnVideojuegos?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
                    btnVideojuegos?.setTextColor(getResources().getColor(R.color.dark_blue))
                    temasFavoritos.add("Videojuegos")
                    t4++
                } else {
                    t4 = 0
                    btnVideojuegos?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
                    btnVideojuegos?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
                    btnVideojuegos?.setTextColor(getResources().getColor(R.color.deep_gray))
                    temasFavoritos.remove("Videojuegos")
                }
            }
            R.id.btn_musical -> {
                btnMusical = findViewById(R.id.btn_musical)

                if (t5 == 0) {
                    btnMusical?.setBackgroundResource(R.drawable.botontemaselectable2)
                    btnMusical?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25F)
                    btnMusical?.setTextColor(getResources().getColor(R.color.dark_blue))
                    temasFavoritos.add("Musical")
                    t5++
                } else {
                    t5 = 0
                    btnMusical?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
                    btnMusical?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
                    btnMusical?.setTextColor(getResources().getColor(R.color.deep_gray))
                    temasFavoritos.remove("Aventuras")
                }
            }
            R.id.btn_aventuras -> {
                btnAventuras = findViewById(R.id.btn_aventuras)


                if (t6 == 0) {
                    btnAventuras?.setBackgroundResource(R.drawable.botontemaselectable2)
                    btnAventuras?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 23F)
                    btnAventuras?.setTextColor(getResources().getColor(R.color.dark_blue))
                    temasFavoritos.add("Aventuras")
                    t6++
                } else {
                    t6 = 0
                    btnAventuras?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
                    btnAventuras?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
                    btnAventuras?.setTextColor(getResources().getColor(R.color.deep_gray))
                    temasFavoritos.remove("Animales")
                }
            }
        }
    }

    fun limpiarCategoria() {

        btnDeportes = findViewById(R.id.btn_deportes)

        btnDeportes?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
        btnDeportes?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
        btnDeportes?.setTextColor(getResources().getColor(R.color.deep_gray))
        //temasFavoritos.remove("Deportes")

        btnAnimales = findViewById(R.id.btn_animales)


        btnAnimales?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
        btnAnimales?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
        btnAnimales?.setTextColor(getResources().getColor(R.color.deep_gray))
        //temasFavoritos.remove("Animales")

        btnMagia = findViewById(R.id.btn_magia)


        btnMagia?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
        btnMagia?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
        btnMagia?.setTextColor(getResources().getColor(R.color.deep_gray))
        //temasFavoritos.remove("Magia")

        btnVideojuegos = findViewById(R.id.btn_videojuegos)


        btnVideojuegos?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
        btnVideojuegos?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
        btnVideojuegos?.setTextColor(getResources().getColor(R.color.deep_gray))
        //temasFavoritos.remove("Videojuegos")

        btnMusical = findViewById(R.id.btn_musical)


        btnMusical?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
        btnMusical?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
        btnMusical?.setTextColor(getResources().getColor(R.color.deep_gray))
        //temasFavoritos.remove("Aventuras")

        btnAventuras = findViewById(R.id.btn_aventuras)



        btnAventuras?.setBackgroundDrawable(getResources().getDrawable(R.drawable.botontemaselectable))
        btnAventuras?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15F)
        btnAventuras?.setTextColor(getResources().getColor(R.color.deep_gray))
        //temasFavoritos.remove("Animales")
    }

    fun enviarInfo(uid: String, numPerfil: Int) {

        userRef.child(uid).get().addOnSuccessListener { dataSnapshot ->
            if (dataSnapshot.exists()) {
                val usuario = dataSnapshot.getValue(Usuario::class.java)
                var perfil: PerfilUsuario = usuario!!.perfiles.get(numPerfil)


                val intent: Intent = Intent(this, Menu::class.java)
                intent.putExtra("perfil", perfil)
                startActivity(intent)
            }
        }

    }
}