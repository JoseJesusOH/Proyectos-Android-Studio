package mx.edu.itson.appmoviles

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Perfiles : AppCompatActivity() {
    var perfiles: ArrayList<PerfilUsuario> = ArrayList<PerfilUsuario>()
    var adapter:PerfilAdapter? = null
    private lateinit var auth: FirebaseAuth

    //realtime database
    private var userRef = FirebaseDatabase.getInstance().getReference("usuarios")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfiles)

        auth = Firebase.auth

        val user = auth.currentUser

        val uid = user?.uid.toString()

        userRef.child(uid).get().addOnSuccessListener { dataSnapshot ->
            if (dataSnapshot.exists()){
                val usuario = dataSnapshot.getValue(Usuario::class.java)
                var perfilesUsuarioObtenido: ArrayList<PerfilUsuario> = usuario!!.perfiles
                perfilesUsuarioObtenido.add(0, PerfilUsuario("Agregar Perfil", 0, R.drawable.agregar))
                adapter = PerfilAdapter(this, perfilesUsuarioObtenido)
                var listView: GridView = findViewById(R.id.grvperfiles)
                listView.adapter=adapter

            }
        }


/*
        if(intent.hasExtra("usuario")){
            var usuario2=intent.getSerializableExtra("usuario") as Usuario
            var perfilesUsuarioObtenido: ArrayList<PerfilUsuario> =usuario2.perfiles
            perfilesUsuarioObtenido.add(0, PerfilUsuario("Agregar Perfil", 0, R.drawable.agregar))
            adapter = PerfilAdapter(this, perfilesUsuarioObtenido)
            var listView: GridView = findViewById(R.id.grvperfiles)
            listView.adapter=adapter
        }

 */
/*
        agregarPerfiles()
        */

        /*
        val agregar_perfil: ImageView = findViewById(R.id.iv_agregar_perfil)
        agregar_perfil.setOnClickListener{
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            startActivity(intent)
        }


        val Perfil1: ImageView = findViewById(R.id.iv_perfil_1)
        val Perfil2: ImageView = findViewById(R.id.iv_perfil_2)
        val Perfil3: ImageView = findViewById(R.id.iv_perfil_3)
        val agregar_perfil: ImageView = findViewById(R.id.iv_agregar_perfil)

        Perfil1.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        Perfil2.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        Perfil3.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        agregar_perfil.setOnClickListener{
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            startActivity(intent)
        }
 */
    }
    /*
    private fun agregarPerfiles() {
        perfiles.add(PerfilUsuario("Agregar Perfil",0,R.drawable.agregar))
    }

     */
    class PerfilAdapter : BaseAdapter {
        var context: Context? = null
        var catalogo = ArrayList<PerfilUsuario>()

        constructor(context: Context, catalogo: ArrayList<PerfilUsuario>) {
            this.context = context
            this.catalogo = catalogo
        }

        override fun getCount(): Int {
            return catalogo.size
        }

        override fun getItem(p0: Int): Any {
            return catalogo[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var perfil = catalogo[p0]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            // Si el perfil es una imagen, inflar la vista imagen
            if (p0== 0) {
                var vista2 = inflator.inflate(R.layout.perfil_item, null)
                var imagen: ImageView = vista2.findViewById(R.id.ivperfil)
                imagen.setImageResource(R.drawable.agregar)
                val height = context!!.resources.getDimension(R.dimen.image_height).toInt()
                imagen.layoutParams.height = height
                imagen.layoutParams.width = height
                var txv:TextView=vista2.findViewById(R.id.tvperfilnombre)
                txv.setText(perfil.nombre)
                var imagenFondo: ImageView = vista2.findViewById(R.id.ivperfilfondo)
                imagenFondo.setImageResource(R.drawable.perfil4)
                imagenFondo.setOnClickListener {
                    var intento = Intent(context, ConfigurarPerfil::class.java)
                    context!!.startActivity(intento)
                }
                imagen.setOnClickListener {
                    var intento = Intent(context, ConfigurarPerfil::class.java)
                    context!!.startActivity(intento)
                }
                return vista2
            }
            else {
                var vista = inflator.inflate(R.layout.perfil_item, null)
                var imagen: ImageView = vista.findViewById(R.id.ivperfil)
                var txv:TextView=vista.findViewById(R.id.tvperfilnombre)
                txv.setText(perfil.nombre)
                if (perfil.imagen!!.equals(R.drawable.perfilfull1)){
                    var imagenFondo: ImageView = vista.findViewById(R.id.ivperfilfondo)
                    imagenFondo.setImageResource(R.drawable.perfil1)
                    imagen.setImageResource(R.drawable.perfiloficial1)


                }
                if (perfil.imagen!!.equals(R.drawable.perfilfull2)){
                    var imagenFondo: ImageView = vista.findViewById(R.id.ivperfilfondo)
                    imagenFondo.setImageResource(R.drawable.perfil2)
                    imagen.setImageResource(R.drawable.perfiloficial2)
                }
                if (perfil.imagen!!.equals(R.drawable.perfilfull3)){
                    var imagenFondo: ImageView = vista.findViewById(R.id.ivperfilfondo)
                    imagenFondo.setImageResource(R.drawable.perfil3)
                    imagen.setImageResource(R.drawable.perfiloficial3)
                }
                //imagen.setImageResource(perfil.imagen!!)
                imagen.setOnClickListener {
                    var intento = Intent(context,Menu::class.java)
                    intento.putExtra("perfil",perfil)
                    context!!.startActivity(intento)
                }
                return vista

            }
        }

    }
}