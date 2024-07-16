package mx.edu.itson.appmoviles

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import mx.edu.itson.appmoviles.R.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentPerfil.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentPerfil : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(layout.fragment_perfil, container, false)


        val perfil = arguments?.getSerializable("perfil") as PerfilUsuario

        val tvNombre: TextView = view.findViewById(R.id.tvNombreUsuarioPerfil)
        tvNombre.setText(perfil.nombre.toString())

        val imgPerfil: ImageView = view.findViewById(R.id.ivPerfilImagen)
        imgPerfil.setImageResource(perfil.imagen!!.toInt())

        val ivConfiguracion: ImageView = view.findViewById(R.id.img_configuracion)

        ivConfiguracion.setOnClickListener {
            // Crea un Intent para llamar la Activity
            val intent = Intent(activity, Configuracion::class.java)
            intent.putExtra("perfil",perfil)
            startActivity(intent)
        }
        val ivMedallas:ImageView= view.findViewById(R.id.medallasPerfil)

        ivMedallas.setOnClickListener {
            // Obtener la instancia de la actividad actual y llamar setCurrentFragment
            val menuActivity = requireActivity() as Menu
            menuActivity.setCurrentFragment(Medallas())
        }
        val ivColecion:ImageView= view.findViewById(R.id.coleccionablesPerfil)
        ivColecion.setOnClickListener {
            // Obtener la instancia de la actividad actual y llamar setCurrentFragment
            val menuActivity = requireActivity() as Menu
            menuActivity.setCurrentFragment(ColeccionBase())
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentPerfil.
         */
        // TODO: Rename and change types and number of parameters


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentPerfil().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}