package mx.edu.itson.appmoviles




import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
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
class Medallas : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var adapter: MedallasAdapter? = null
    var medallas: ArrayList<Int> = ArrayList<Int>()

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
        val view: View = inflater.inflate(layout.activity_medallas, container, false)

        agregarMedallas()
        adapter = MedallasAdapter(view.context, medallas)
        val gridView = view.findViewById<GridView>(R.id.medallas)
        gridView.adapter = adapter
       val regresar:ImageView=view.findViewById(R.id.buttonRegresar)
        regresar.setOnClickListener {
            // Obtener la instancia de la actividad actual y llamar setCurrentFragment
            val menuActivity = requireActivity() as Menu
            menuActivity.setCurrentFragment(FragmentPerfil())
        }

        return view
    }

    private fun agregarMedallas(){

        medallas.add(R.drawable.medalla1)
        medallas.add(R.drawable.medalla2)
        medallas.add(R.drawable.medalla3)
        medallas.add(R.drawable.medalla4)
        medallas.add(R.drawable.medalla5)
        medallas.add(R.drawable.medalla6)
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
    class MedallasAdapter: BaseAdapter{
        var context: Context? = null
        var medallas = ArrayList<Int>()

        constructor(context: Context, medallas: ArrayList<Int>){
            this.context = context
            this.medallas = medallas
        }


        override fun getCount(): Int {
            return medallas.size
        }

        override fun getItem(position: Int): Any {
            return medallas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var medallas = medallas[position]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.item_medalla_coleccionable_catalogo, null)

            var imagen: ImageView = vista.findViewById(R.id.imageView)

            imagen.setImageResource(medallas)
            imagen.setOnClickListener {
                var intento = Intent(context, PopUpMedallaInfo::class.java)
                context!!.startActivity(intento)
            }
        return vista
        }

    }
}