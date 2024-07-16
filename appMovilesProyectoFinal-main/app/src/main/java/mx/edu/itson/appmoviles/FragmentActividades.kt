package mx.edu.itson.appmoviles

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentActividades.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentActividades : Fragment() {
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
        val view: View = inflater.inflate(R.layout.fragment_actividades, container, false)
        agregarCategorias()
        agregarHistorias()
        adapter = FragmentActividades.CategoriaObjetoAdapter(view.context, catalogo)
        var listView: GridView = view.findViewById(R.id.gvPorCategoria)
        listView.adapter=adapter

        val adapter2 = BibliotecaObjetoAdapter(catalogo1)
        val recyclerView:RecyclerView = view.findViewById(R.id.gvActividadesHistoria)
        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter2
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ActividadesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentActividades().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    var catalogo: ArrayList<CategoriaObjeto> = ArrayList<CategoriaObjeto>()
    var adapter: CategoriaObjetoAdapter? = null
    var catalogo1: ArrayList<BibliotecaObjeto> = ArrayList<BibliotecaObjeto>()



    private fun agregarCategorias() {
        catalogo.add(
            CategoriaObjeto("Pronunciación",R.drawable.pronunciacion)
        )
        catalogo.add(
            CategoriaObjeto("Deletreo",R.drawable.deletreo)
        )
    }

    private fun agregarHistorias() {
        catalogo1.add(
            BibliotecaObjeto(
                R.drawable.regaloprincesa,
                "El regalo de la princesa",
                0
            )
        )
        catalogo1.add(
            BibliotecaObjeto(
                R.drawable.cenicienta,
                "Cenicienta",
                0
            )
        )
        catalogo1.add(
            BibliotecaObjeto(
                R.drawable.pinocho,
                "Pinocho",
                0
            )
        )
        catalogo1.add(
            BibliotecaObjeto(
                R.drawable.reinanieves,
                "La reina de las nieves",
                0
            )
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
            var text: TextView =vista.findViewById(R.id.txtCategoria)
            imagen.setImageResource(historia.imagen)
            text.setText(historia.titulo)

            return vista
        }
    }

    class BibliotecaObjetoAdapter(private val historiasBiblioteca: ArrayList<BibliotecaObjeto>) :
        RecyclerView.Adapter<BibliotecaObjetoAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imagen: ImageView = itemView.findViewById(R.id.bibliotecaImagen)
            val texto: TextView = itemView.findViewById(R.id.tituloBiblioteca)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_biblioteca_base, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val historia = historiasBiblioteca[position]
            holder.imagen.setImageResource(historia.image)
            holder.texto.text = historia.titulo
        }

        override fun getItemCount(): Int {
            return historiasBiblioteca.size
        }
    }
}