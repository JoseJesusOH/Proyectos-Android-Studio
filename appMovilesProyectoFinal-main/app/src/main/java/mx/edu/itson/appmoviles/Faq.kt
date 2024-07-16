package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class Faq : AppCompatActivity(), View.OnClickListener {

    var tv_mini_cambio: TextView? =null
    var tv_mini_olvide: TextView? =null
    var tv_mini_sin_imagen: TextView? =null
    var tv_mini_perfiles: TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        tv_mini_perfiles = findViewById(R.id.minitextviewPerfiles)
        tv_mini_cambio = findViewById(R.id.minitextviewCambio)
        tv_mini_olvide = findViewById(R.id.minitextviewOlvide)
        tv_mini_sin_imagen = findViewById(R.id.minitextviewSinImagenes)

        val iv_regresar: ImageView = findViewById(R.id.ivRegresarFaq)
        iv_regresar.setOnClickListener {
            var intent: Intent = Intent(this, Configuracion::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.buttonCantidadPerfiles -> {
                if (tv_mini_perfiles?.isVisible == true) {
                    tv_mini_perfiles?.setVisibility(View.GONE)
                } else {
                    tv_mini_perfiles?.setVisibility(View.VISIBLE)
                }
            }

            R.id.buttonOlvideUsuario -> {
                if (tv_mini_olvide?.isVisible == true) {
                    tv_mini_olvide?.setVisibility(View.GONE)
                } else {
                    tv_mini_olvide?.setVisibility(View.VISIBLE)
                }
            }

            R.id.buttonCambioIcono -> {
                if (tv_mini_cambio?.isVisible == true) {
                    tv_mini_cambio?.setVisibility(View.GONE)
                } else {
                    tv_mini_cambio?.setVisibility(View.VISIBLE)
                }
            }

            R.id.buttonSinImagenes -> {
                if (tv_mini_sin_imagen?.isVisible == true) {
                    tv_mini_sin_imagen?.setVisibility(View.GONE)
                } else {
                    tv_mini_sin_imagen?.setVisibility(View.VISIBLE)
                }
            }
        }
    }


}



