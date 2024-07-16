package mx.edu.itson.appmoviles

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentBiblioteca.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentBiblioteca : Fragment() {
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


        val view: View = inflater.inflate(R.layout.fragment_biblioteca, container, false)
        agregarHistorias()
        adapter = FragmentBiblioteca.BibliotecaObjetoAdapter(view.context,catalogo)
        var listView: GridView = view.findViewById(R.id.biblioteca)
        listView.adapter=adapter
        return view
        // Inflate the layout for this fragment
    }
    private fun agregarHistorias() {
        catalogo.add(
            BibliotecaObjeto(
                R.drawable.regaloprincesa,
                "El regalo de la princesa",
                0
            )
        )
        catalogo.add(
            BibliotecaObjeto(
                R.drawable.cenicienta,
                "Cenicienta",
                0
            )
        )
        catalogo.add(
            BibliotecaObjeto(
                R.drawable.pinocho,
                "Pinocho",
                0
            )
        )
        catalogo.add(
            BibliotecaObjeto(
                R.drawable.reinanieves,
                "La reina de las nieves",
                0
            )
        )
    }

    var catalogo: ArrayList<BibliotecaObjeto> = ArrayList<BibliotecaObjeto>()
    var adapter: FragmentBiblioteca.BibliotecaObjetoAdapter? = null
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentBiblioteca.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentBiblioteca().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    class BibliotecaObjetoAdapter : BaseAdapter {
        var context: Context? = null
        var historiasBiblioteca = ArrayList<BibliotecaObjeto>()

        constructor(context: Context, historiasBiblioteca : ArrayList<BibliotecaObjeto>) {
            this.context = context
            this.historiasBiblioteca  = historiasBiblioteca
        }

        override fun getCount(): Int {
            return historiasBiblioteca .size
        }

        override fun getItem(p0: Int): Any {
            return historiasBiblioteca [p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var historia = historiasBiblioteca [p0]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.activity_biblioteca_base, null)

            var imagen: ImageView = vista.findViewById(R.id.bibliotecaImagen)

            imagen.setImageResource(historia.image)
            var texto: TextView =vista.findViewById(R.id.tituloBiblioteca)
            texto.setText(historia.titulo)
            return vista
        }
    }
}