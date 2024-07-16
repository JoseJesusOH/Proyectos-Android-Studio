package mx.edu.itson.practica8

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

class Regalos : AppCompatActivity() {
    var regalos=ArrayList<Detalles>()
    var detalles=ArrayList<Detalles>()
    var peluches=ArrayList<Detalles>()
    var tazas=ArrayList<Detalles>()
    var globos=ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)
        var gridView: GridView = findViewById(R.id.gridRegalos)
        val boton=intent.getStringExtra("click")
        var adaptador:RegalosAdapter
        var titulo: TextView = findViewById(R.id.tituloDetalle)
        rellenarArreglos()
        if(boton.equals("detalles")){
            titulo.setText("Detalles: ")
            adaptador=RegalosAdapter(this,detalles)
            gridView.adapter=adaptador
        }
        if(boton.equals("globos")){
            titulo.setText("Globos: ")
            adaptador=RegalosAdapter(this,globos)
            gridView.adapter=adaptador
        }
        if(boton.equals("peluches")){
            titulo.setText("Peluches: ")
            adaptador=RegalosAdapter(this,peluches)
            gridView.adapter=adaptador
        }
        if(boton.equals("regalos")){
            titulo.setText("Regalos: ")
            adaptador=RegalosAdapter(this,regalos)
            gridView.adapter=adaptador
        }
        if(boton.equals("tazas")){
            titulo.setText("Tazas: ")
            adaptador=RegalosAdapter(this,tazas)
            gridView.adapter=adaptador
        }
    }
    fun rellenarArreglos(){
        regalos.add(Detalles(R.drawable.regaloazul, "80"))
        regalos.add(Detalles(R.drawable.regalobebe, "290"))
        regalos.add(Detalles(R.drawable.regalocajas, "140"))
        regalos.add(Detalles(R.drawable.regalocolores, "85"))
        regalos.add(Detalles(R.drawable.regalovarios, "75"))
        regalos.add(Detalles(R.drawable.regalos, "100"))

        detalles.add(Detalles(R.drawable.cumplebotanas,"280"))
        detalles.add(Detalles(R.drawable.cumplecheve,"320"))
        detalles.add(Detalles(R.drawable.cumpleescolar,"330"))
        detalles.add(Detalles(R.drawable.cumplepaletas,"190"))
        detalles.add(Detalles(R.drawable.cumplevinos,"370"))
        detalles.add(Detalles(R.drawable.cumplesnack,"150"))

        globos.add(Detalles(R.drawable.globos,"240"))
        globos.add(Detalles(R.drawable.globoamor,"240"))
        globos.add(Detalles(R.drawable.globocumple,"820"))
        globos.add(Detalles(R.drawable.globonum,"760"))
        globos.add(Detalles(R.drawable.globofestejo,"260"))
        globos.add(Detalles(R.drawable.globoregalo,"450"))

        peluches.add(Detalles(R.drawable.peluches,"100"))
        peluches.add(Detalles(R.drawable.peluchemario,"320"))
        peluches.add(Detalles(R.drawable.pelucheminecraft,"320"))
        peluches.add(Detalles(R.drawable.peluchepeppa,"290"))
        peluches.add(Detalles(R.drawable.peluchesony,"330"))
        peluches.add(Detalles(R.drawable.peluchestich,"280"))
        peluches.add(Detalles(R.drawable.peluchevarios,"195"))

        tazas.add(Detalles(R.drawable.tazas,"280"))
        tazas.add(Detalles(R.drawable.tazaabuela,"120"))
        tazas.add(Detalles(R.drawable.tazalove,"120"))
        tazas.add(Detalles(R.drawable.tazaquiero,"260"))
    }
    class RegalosAdapter: BaseAdapter {

        var productos = ArrayList<Detalles>()
        var contexto: Context? =null

        constructor(contexto: Context, pelicula: ArrayList<Detalles>){
            this.productos = pelicula
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflador= LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.activity_detalle_regalos,null)
            var imagen: ImageView = vista.findViewById(R.id.iv_regalo_imagen)
            imagen.setImageResource(prod.image)
            imagen.setOnClickListener(){
                val intento = Intent(contexto,DetalleRegalos::class.java)
                intento.putExtra("imagen",prod.image)
                intento.putExtra("precio",prod.precio)
                contexto!!.startActivity(intento)
            }
            return vista
        }

    }
}