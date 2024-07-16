package mx.edu.itson.appmoviles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentBuscar.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentBuscar : Fragment() {
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

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_buscar, container, false)
        agregarCategorias()
        adapter = CategoriaObjetoAdapter(view.context, catalogo)
        var listView: ListView = view.findViewById(R.id.categorias)
        listView.adapter = adapter
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentBuscar.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentBuscar().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    var catalogo: ArrayList<CategoriaObjeto> = ArrayList<CategoriaObjeto>()
    var adapter: CategoriaObjetoAdapter? = null


    private fun agregarCategorias() {
        catalogo.clear()

        catalogo.add(
            CategoriaObjeto("Fantasia", R.drawable.fantasia)
        )
        catalogo.add(
            CategoriaObjeto("Misterio", R.drawable.misterio)
        )
        catalogo.add(
            CategoriaObjeto("Ciencia Ficción", R.drawable.cienciaficion)
        )

        catalogo.add(
            CategoriaObjeto("Magia", R.drawable.otonotemporada)
        )
        catalogo.add(
            CategoriaObjeto("Animales", R.drawable.animales)
        )
        catalogo.add(
            CategoriaObjeto("Aventura", R.drawable.aventura)
        )


    }

    class CategoriaObjetoAdapter : BaseAdapter {
        var context: Context? = null
        var catalogo = ArrayList<CategoriaObjeto>()

        constructor(context: Context, categoriaObjeto: ArrayList<CategoriaObjeto>) {
            this.context = context
            this.catalogo = categoriaObjeto
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
            var historia = catalogo[p0]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.activity_categoria_base, null)

            var imagen: ImageView = vista.findViewById(R.id.categoria)
            var text: TextView = vista.findViewById(R.id.txtCategoria)
            imagen.setImageResource(historia.imagen)
            text.setText(historia.titulo)
            text.setOnClickListener {
                //var intent = Intent(context,FragmentCategoria::class.java)
                //intent.putExtra("palabra", text.toString())
                //context!!.startActivity(intent)
            }

            return vista
        }
    }


}