package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible


class HistoriaBase : AppCompatActivity(), View.OnClickListener {

    var tv_texto_historia: TextView? = null
    var btn_configuracion_historia: Button? = null
    var btn_regresar_lectura: Button? = null
    var btn_siguiente_lectura: Button? = null
    var pb_progreso: ProgressBar? = null
    var btn_diccionario: Button? = null
    var btn_escuchar_historia: Button? = null
    var historia: Historia? = null
    var perfil: PerfilUsuario? = null
    var numParrafo: Int = 0
    var maxProgBar: Int = 0
    var progreso: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia_base)

        historia = intent.getSerializableExtra("historia") as Historia
        perfil = intent.getSerializableExtra("perfil") as PerfilUsuario


        tv_texto_historia = findViewById(R.id.tvTextoHistoria)
        btn_configuracion_historia = findViewById(R.id.btnConfiguracionHistoria)
        btn_regresar_lectura = findViewById(R.id.btnRegresarLectura)
        btn_siguiente_lectura = findViewById(R.id.btnSiguienteLectura)
        pb_progreso = findViewById(R.id.pbHistoriaBase)
        btn_diccionario = findViewById(R.id.btnDiccionarioHistoria)
        btn_escuchar_historia = findViewById(R.id.btnEscucharHistoria)

        val iv_imagen_lectura: ImageView = findViewById(R.id.imagenLectura)

        iv_imagen_lectura.setImageResource(historia!!.image!!.toInt())
        tv_texto_historia!!.setText(historia!!.parrafos.get(0))
        pb_progreso!!.setMax(historia!!.parrafos.size-1)
        pb_progreso!!.progress = progreso

        btn_siguiente_lectura!!.setOnClickListener {
            numParrafo++
            progreso++
            if (numParrafo > (historia!!.parrafos.size - 1)) {
                numParrafo = historia!!.parrafos.size - 1

                var intent: Intent = Intent(this, FinLectura::class.java)
                intent.putExtra("perfil", perfil)
                intent.putExtra("historia",historia)
                startActivity(intent)
            }
            if (progreso > historia!!.parrafos.size) {
                progreso = historia!!.parrafos.size
            }
            tv_texto_historia!!.setText(historia!!.parrafos.get(numParrafo))
            pb_progreso!!.progress = progreso
            iv_imagen_lectura.setImageResource(historia!!.imagenes.get(numParrafo))


        }

        btn_regresar_lectura!!.setOnClickListener {
            numParrafo--
            progreso--
            if (numParrafo < 0) {
                numParrafo = 0
            }

            if (progreso < 0) {
                progreso = 0
            }

            tv_texto_historia!!.setText(historia!!.parrafos.get(numParrafo))
            pb_progreso!!.progress = progreso
            iv_imagen_lectura.setImageResource(historia!!.imagenes.get(numParrafo))
        }

        val iv_regresar_historia: ImageView = findViewById(R.id.ivRegresarHistoria)


        iv_regresar_historia.setOnClickListener {
            var intent: Intent = Intent(this, HistoriaInfo::class.java)
            intent.putExtra("perfil",perfil)
            intent.putExtra("historia",historia)

            startActivity(intent)
        }

        /*
                siguiente_imagen_perfil.setOnClickListener {
            imagenPerfil++
            if (imagenPerfil > (imagenesPerfil.size - 1)) {
                imagenPerfil = 0
            }

            imagen_perfil.setImageResource(imagenesPerfil.get(imagenPerfil))

        }

        anterior_imagen_perfil.setOnClickListener {
            imagenPerfil--
            if (imagenPerfil < 0) {
                imagenPerfil = 2
            }

            imagen_perfil.setImageResource(imagenesPerfil.get(imagenPerfil))
        }
         */

        btn_escuchar_historia?.setOnClickListener {
            var intent: Intent = Intent(this, PopUpVoz::class.java)
            startActivity(intent)
        }

        btn_configuracion_historia?.setOnClickListener {
            var intent: Intent = Intent(this, PopUpLectura::class.java)
            startActivity(intent)
        }

        btn_diccionario?.setOnClickListener {
            var intent: Intent = Intent(this, PopUpDiccionario::class.java)
            startActivity(intent)
        }


    }


    override fun onClick(view: View) {

        when (view.id) {
            R.id.tvTextoHistoria -> {
                if (btn_diccionario?.isInvisible == true) {
                    btn_regresar_lectura?.visibility = View.INVISIBLE
                    pb_progreso?.visibility = View.INVISIBLE
                    btn_siguiente_lectura?.visibility = View.INVISIBLE
                    btn_configuracion_historia?.visibility = View.INVISIBLE
                    btn_escuchar_historia?.visibility = View.INVISIBLE
                    btn_diccionario?.visibility = View.VISIBLE
                } else {
                    btn_regresar_lectura?.visibility = View.VISIBLE
                    pb_progreso?.visibility = View.VISIBLE
                    btn_siguiente_lectura?.visibility = View.VISIBLE
                    btn_configuracion_historia?.visibility = View.VISIBLE
                    btn_escuchar_historia?.visibility = View.VISIBLE
                    btn_diccionario?.visibility = View.INVISIBLE
                }
            }
        }
    }


}
