package mx.edu.itson.appmoviles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//FragmentBuscar : Fragment(R.layout.fragment_buscar) {
class FragmentCatalogo : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    var adapter: HistoriaAdapter? = null


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
        val view: View = inflater.inflate(R.layout.fragment_catalogo, container, false)
        val perfil = arguments?.getSerializable("perfil") as PerfilUsuario
        val menu = Menu()
        var catalogo = menu.getOpciones()

        /*
        adapter = HistoriaAdapter(view.context, catalogo)
        var listView: GridView = view.findViewById(R.id.catalogo)
        listView.adapter=adapter
    */
        // Obtén la referencia al RecyclerView desde el diseño XML
        val recyclerView: RecyclerView = view.findViewById(R.id.catalogo)

// Crea un GridLayoutManager para organizar los elementos en una cuadrícula de 2 columnas
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager

// Crea un adaptador personalizado que extienda de RecyclerView.Adapter, y pásalo al RecyclerView
        val adapter = HistoriaAdapter(requireContext(), catalogo as ArrayList<Historia>, perfil  )
        recyclerView.adapter = adapter

        return view
    }


    class HistoriaAdapter(private val context: Context, private val catalogo: ArrayList<Historia>, private val perfil: PerfilUsuario) :
        RecyclerView.Adapter<HistoriaAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context)
                .inflate(R.layout.item_medalla_coleccionable_catalogo, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val historia = catalogo[position]
            val height = context.resources.getDimension(R.dimen.image_heightCatalogo).toInt()
            val width = context.resources.getDimension(R.dimen.image_widthCatalogo).toInt()

            holder.imagen.setImageResource(historia.image!!.toInt())
            holder.imagen.layoutParams.height = height
            holder.imagen.layoutParams.width = width
            if (((position % 2) == 0) && (position != 0)) {
                val marginTop = context.resources.getDimension(R.dimen.imageTopCatalogo2).toInt()
                val params = holder.imagen.layoutParams as ViewGroup.MarginLayoutParams
                params.setMargins(0, marginTop, 0, 0)
                holder.imagen.layoutParams = params
            } else if ((position == 1) || ((position % 2) != 0)) {
                val marginTop = context.resources.getDimension(R.dimen.imageTopCatalogo).toInt()
                val params = holder.imagen.layoutParams as ViewGroup.MarginLayoutParams
                params.setMargins(0, marginTop, 0, 0)
                holder.imagen.layoutParams = params
            }
            holder.imagen.setOnClickListener {
                var intento = Intent(context, HistoriaInfo::class.java)
                intento.putExtra("perfil", perfil)
                intento.putExtra("historia", historia)
                /*
                intento.putExtra("image", historia.image)
                intento.putExtra("titulo", historia.titulo)
                intento.putExtra("autor", historia.autor)
                intento.putExtra("numPaginas", historia.numPaginas)
                intento.putExtra("sinopsis", historia.sinopsisi)
                */
                context.startActivity(intento)
            }
        }

        override fun getItemCount(): Int {
            return catalogo.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imagen: ImageView = itemView.findViewById(R.id.imageView)
        }
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
            FragmentCatalogo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}