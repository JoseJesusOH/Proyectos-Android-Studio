package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
class HistoriaInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia_info)

        val iv_iamgen_historia: ImageView = findViewById(R.id.iv_historia_imagen)
        val tv_titulo_historia: TextView = findViewById(R.id.tv_titulo_historia)
        val tv_autor_historia: TextView = findViewById(R.id.tv_autor_historia)
        val tv_paginas_historia: TextView = findViewById(R.id.tv_total_paginas_historia)
        val tv_sinopsis_historia: TextView = findViewById(R.id.tv_psinopsis_historia)

        if(intent.hasExtra("historia")){
            val historia = intent.getSerializableExtra("historia") as Historia
            iv_iamgen_historia.setImageResource(historia.image!!.toInt())
            tv_titulo_historia.text = historia.titulo
            tv_autor_historia.text = historia.autor
            tv_paginas_historia.text = historia.numPaginas
            tv_sinopsis_historia.text = historia.sinopsisi
        }

        val imageView: ImageView=findViewById(R.id.imageView4Play)
        imageView.setOnClickListener{
            val perfil = intent.getSerializableExtra("perfil") as PerfilUsuario
            val historia = intent.getSerializableExtra("historia") as Historia
            var intent: Intent = Intent(this, HistoriaBase::class.java)
            intent.putExtra("historia", historia)
            intent.putExtra("perfil", perfil)

            startActivity(intent)
        }

        val imageViewRegresar: ImageView=findViewById(R.id.imageView2Regresar2)
        imageViewRegresar.setOnClickListener{
            val perfil = intent.getSerializableExtra("perfil") as PerfilUsuario
            var intent: Intent = Intent(this, Menu::class.java)
            intent.putExtra("perfil", perfil)
            startActivity(intent)
        }
    }
}
