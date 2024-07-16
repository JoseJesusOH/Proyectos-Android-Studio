package mx.edu.itson.examen2app_orozcojose

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
        var gridView:GridView= findViewById(R.id.gridRegalos)
        val boton=intent.getStringExtra("click")
        var adaptador:RegalosAdapter
        var titulo: TextView = findViewById(R.id.tituloDetalle)
        rellenarArreglos()
        if(boton.equals("detalles")){
            titulo.setText("Detalles: $250")
            adaptador=RegalosAdapter(this,detalles)
            gridView.adapter=adaptador
        }
        if(boton.equals("globos")){
           titulo.setText("Globos: $300")
            adaptador=RegalosAdapter(this,globos)
            gridView.adapter=adaptador
        }
        if(boton.equals("peluches")){
            titulo.setText("Peluches: $200")
            adaptador=RegalosAdapter(this,peluches)
            gridView.adapter=adaptador
        }
        if(boton.equals("regalos")){
            titulo.setText("Regalos: $150")
            adaptador=RegalosAdapter(this,regalos)
            gridView.adapter=adaptador
        }
        if(boton.equals("tazas")){
            titulo.setText("Tazas: $200")
            adaptador=RegalosAdapter(this,tazas)
            gridView.adapter=adaptador
        }
    }
    fun rellenarArreglos(){
        regalos.add(Detalles(R.drawable.regaloazul,"Ragalo Azul", "150"))
        regalos.add(Detalles(R.drawable.regalobebe,"Ragalo Bebe", "250"))
        regalos.add(Detalles(R.drawable.regalocajas,"Ragalo Cajas", "350"))
        regalos.add(Detalles(R.drawable.regalocolores,"Ragalo Colores", "450"))
        regalos.add(Detalles(R.drawable.regalovarios,"Ragalo Varios", "400"))
        regalos.add(Detalles(R.drawable.regalos,"Ragalos", "200"))

        detalles.add(Detalles(R.drawable.cumplebotanas,"Detalle Botanas","250"))
        detalles.add(Detalles(R.drawable.cumplecheve,"Detalle Cheve","350"))
        detalles.add(Detalles(R.drawable.cumpleescolar,"Detalle Escolar","450"))
        detalles.add(Detalles(R.drawable.cumplepaletas,"Detalle Paletas","200"))
        detalles.add(Detalles(R.drawable.cumplevinos,"Detalle Vinos","300"))
        detalles.add(Detalles(R.drawable.cumplesnack,"Detalles Snack","350"))

        globos.add(Detalles(R.drawable.globos,"Globos","300"))
        globos.add(Detalles(R.drawable.globoamor,"Globos Amor","350"))
        globos.add(Detalles(R.drawable.globocumple,"Globos Cumpleaños","400"))
        globos.add(Detalles(R.drawable.globonum,"Globos Num","450"))
        globos.add(Detalles(R.drawable.globofestejo,"Globos Festejo","500"))
        globos.add(Detalles(R.drawable.globoregalo,"Globos Regalo","550"))

        peluches.add(Detalles(R.drawable.peluches,"Peluches","200"))
        peluches.add(Detalles(R.drawable.peluchemario,"Peluche Mario","250"))
        peluches.add(Detalles(R.drawable.pelucheminecraft,"Peluche Minecraft","300"))
        peluches.add(Detalles(R.drawable.peluchepeppa,"Peluche Peppa","350"))
        peluches.add(Detalles(R.drawable.peluchesony,"Peluche Sonny","400"))
        peluches.add(Detalles(R.drawable.peluchestich,"Peluche Tich","450"))
        peluches.add(Detalles(R.drawable.peluchevarios,"Peluches Varios","500"))

        tazas.add(Detalles(R.drawable.tazas,"Tazas","200"))
        tazas.add(Detalles(R.drawable.tazaabuela,"Taza Abuela","250"))
        tazas.add(Detalles(R.drawable.tazalove,"Taza Love","300"))
        tazas.add(Detalles(R.drawable.tazaquiero,"Taza Quiero","350"))
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
            var inflador=LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.activity_producto,null)
            var imagen:ImageView = vista.findViewById(R.id.iv_imagen)
            imagen.setImageResource(prod.image)
            imagen.setOnClickListener(){
                val intento = Intent(contexto,DetalleRegalos::class.java)
                intento.putExtra("nombre",prod.titulo)
                intento.putExtra("imagen",prod.image)
                intento.putExtra("precio",prod.precio)
                contexto!!.startActivity(intento)
            }
            return vista
        }

    }
}