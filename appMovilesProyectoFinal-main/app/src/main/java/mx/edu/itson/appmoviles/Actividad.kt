package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible

class Actividad : AppCompatActivity(), View.OnClickListener {

    var tv_letraAdivinar1: TextView? = null
    var tv_letraAdivinar2: TextView? = null
    var tv_letraAdivinar3: TextView? = null
    var tv_letraAdivinar4: TextView? = null
    var tv_letraAdivinar5: TextView? = null
    var tv_letraAdivinar6: TextView? = null

    var tv_letraSeleccionada1: TextView? = null
    var tv_letraSeleccionada2: TextView? = null
    var tv_letraSeleccionada3: TextView? = null
    var tv_letraSeleccionada4: TextView? = null
    var tv_letraSeleccionada5: TextView? = null
    var tv_letraSeleccionada6: TextView? = null
    var tv_letraSeleccionada7: TextView? = null
    var tv_letraSeleccionada8: TextView? = null
    var respuestaUser: String? = null
    var respuestaOK: String? = null
    var respuestaUserArray = charArrayOf()
    var respuestaArray = respuestaUserArray.toMutableList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad)



        tv_letraAdivinar1 = findViewById(R.id.tvLetraAdivinar1)
        tv_letraAdivinar2 = findViewById(R.id.tvLetraAdivinar2)
        tv_letraAdivinar3 = findViewById(R.id.tvLetraAdivinar3)
        tv_letraAdivinar4 = findViewById(R.id.tvLetraAdivinar4)
        tv_letraAdivinar5 = findViewById(R.id.tvLetraAdivinar5)
        tv_letraAdivinar6 = findViewById(R.id.tvLetraAdivinar6)


        tv_letraSeleccionada1 = findViewById(R.id.tvLetraSeleccionada1)
        tv_letraSeleccionada2 = findViewById(R.id.tvLetraSeleccionada2)
        tv_letraSeleccionada3 = findViewById(R.id.tvLetraSeleccionada3)
        tv_letraSeleccionada4 = findViewById(R.id.tvLetraSeleccionada4)
        tv_letraSeleccionada5 = findViewById(R.id.tvLetraSeleccionada5)
        tv_letraSeleccionada6 = findViewById(R.id.tvLetraSeleccionada6)
        tv_letraSeleccionada7 = findViewById(R.id.tvLetraSeleccionada7)
        tv_letraSeleccionada8 = findViewById(R.id.tvLetraSeleccionada8)


        val iv_cerrar_actividad: ImageView = findViewById(R.id.ivCerrarActividad)
        val iv_actividad_img: ImageView = findViewById(R.id.ivActividadImg)
        val tv_pregunta: TextView = findViewById(R.id.tvPreguntaActividad)
        val btn_Siguiente: Button = findViewById(R.id.btnSiguienteActividad)


        val historia = intent.getSerializableExtra("historia") as Historia
        val perfil = intent.getSerializableExtra("perfil") as PerfilUsuario

        llenarOpciones(historia)

        iv_actividad_img.setImageResource(historia.image!!.toInt())
        tv_pregunta.setText(historia.pregunta.toString())
        respuestaOK = historia.respuesta.toString()

        iv_cerrar_actividad.setOnClickListener {
            var intent: Intent = Intent(this, Menu::class.java)
            intent.putExtra("perfil", perfil)
            startActivity(intent)
        }

        btn_Siguiente.setOnClickListener {

            respuestaUser = respuestaArray.joinToString("")

            if (respuestaOK.equals(respuestaUser)) {
                var intent: Intent = Intent(this, Regalo::class.java)
                intent.putExtra("perfil", perfil)
                startActivity(intent)

            } else {
                var intent: Intent = Intent(this, Actividad_Fallida::class.java)
                intent.putExtra("perfil", perfil)
                intent.putExtra("historia", historia)
                startActivity(intent)
            }
        }


    }


    fun llenarOpciones(historia: Historia) {

        val opciones: ArrayList<Char> = historia.opciones

        tv_letraSeleccionada1?.setText(opciones.get(0).toString())
        tv_letraSeleccionada2?.setText(opciones.get(1).toString())
        tv_letraSeleccionada3?.setText(opciones.get(2).toString())
        tv_letraSeleccionada4?.setText(opciones.get(3).toString())
        tv_letraSeleccionada5?.setText(opciones.get(4).toString())
        tv_letraSeleccionada6?.setText(opciones.get(5).toString())
        tv_letraSeleccionada7?.setText(opciones.get(6).toString())
        tv_letraSeleccionada8?.setText(opciones.get(7).toString())



    }

    override fun onClick(view: View) {
        when (view.id) {

            R.id.tvLetraSeleccionada1 -> {
                tv_letraSeleccionada1?.setVisibility(View.INVISIBLE)

                if (tv_letraAdivinar1?.isVisible == false) {
                    tv_letraAdivinar1?.setText(tv_letraSeleccionada1?.text.toString())
                    tv_letraAdivinar1?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada1?.text!!.get(0))

                } else if (tv_letraAdivinar2?.isVisible == false) {
                    tv_letraAdivinar2?.setText(tv_letraSeleccionada1?.text.toString())
                    tv_letraAdivinar2?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada1?.text!!.get(0))

                } else if (tv_letraAdivinar3?.isVisible == false) {
                    tv_letraAdivinar3?.setText(tv_letraSeleccionada1?.text.toString())
                    tv_letraAdivinar3?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada1?.text!!.get(0))

                } else if (tv_letraAdivinar4?.isVisible == false) {
                    tv_letraAdivinar4?.setText(tv_letraSeleccionada1?.text.toString())
                    tv_letraAdivinar4?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada1?.text!!.get(0))

                } else if (tv_letraAdivinar5?.isVisible == false) {
                    tv_letraAdivinar5?.setText(tv_letraSeleccionada1?.text.toString())
                    tv_letraAdivinar5?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada1?.text!!.get(0))

                } else if (tv_letraAdivinar6?.isVisible == false) {
                    tv_letraAdivinar6?.setText(tv_letraSeleccionada1?.text.toString())
                    tv_letraAdivinar6?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada1?.text!!.get(0))
                }


            }

            R.id.tvLetraSeleccionada2 -> {
                tv_letraSeleccionada2?.setVisibility(View.INVISIBLE)
                if (tv_letraAdivinar1?.isVisible == false) {
                    tv_letraAdivinar1?.setText(tv_letraSeleccionada2?.text.toString())
                    tv_letraAdivinar1?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada2?.text!!.get(0))

                } else if (tv_letraAdivinar2?.isVisible == false) {
                    tv_letraAdivinar2?.setText(tv_letraSeleccionada2?.text.toString())
                    tv_letraAdivinar2?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada2?.text!!.get(0))

                } else if (tv_letraAdivinar3?.isVisible == false) {
                    tv_letraAdivinar3?.setText(tv_letraSeleccionada2?.text.toString())
                    tv_letraAdivinar3?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada2?.text!!.get(0))

                } else if (tv_letraAdivinar4?.isVisible == false) {
                    tv_letraAdivinar4?.setText(tv_letraSeleccionada2?.text.toString())
                    tv_letraAdivinar4?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada2?.text!!.get(0))

                } else if (tv_letraAdivinar5?.isVisible == false) {
                    tv_letraAdivinar5?.setText(tv_letraSeleccionada2?.text.toString())
                    tv_letraAdivinar5?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada2?.text!!.get(0))

                } else if (tv_letraAdivinar6?.isVisible == false) {
                    tv_letraAdivinar6?.setText(tv_letraSeleccionada2?.text.toString())
                    tv_letraAdivinar6?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada2?.text!!.get(0))
                }


            }//end letraSeleccionada

            R.id.tvLetraSeleccionada3 -> {
                tv_letraSeleccionada3?.setVisibility(View.INVISIBLE)
                if (tv_letraAdivinar1?.isVisible == false) {
                    tv_letraAdivinar1?.setText(tv_letraSeleccionada3?.text.toString())
                    tv_letraAdivinar1?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada3?.text!!.get(0))

                } else if (tv_letraAdivinar2?.isVisible == false) {
                    tv_letraAdivinar2?.setText(tv_letraSeleccionada3?.text.toString())
                    tv_letraAdivinar2?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada3?.text!!.get(0))

                } else if (tv_letraAdivinar3?.isVisible == false) {
                    tv_letraAdivinar3?.setText(tv_letraSeleccionada3?.text.toString())
                    tv_letraAdivinar3?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada3?.text!!.get(0))

                } else if (tv_letraAdivinar4?.isVisible == false) {
                    tv_letraAdivinar4?.setText(tv_letraSeleccionada3?.text.toString())
                    tv_letraAdivinar4?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada3?.text!!.get(0))

                } else if (tv_letraAdivinar5?.isVisible == false) {
                    tv_letraAdivinar5?.setText(tv_letraSeleccionada3?.text.toString())
                    tv_letraAdivinar5?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada3?.text!!.get(0))

                } else if (tv_letraAdivinar6?.isVisible == false) {
                    tv_letraAdivinar6?.setText(tv_letraSeleccionada3?.text.toString())
                    tv_letraAdivinar6?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada3?.text!!.get(0))
                }


            }//end letraSeleccionada

            R.id.tvLetraSeleccionada4 -> {
                tv_letraSeleccionada4?.setVisibility(View.INVISIBLE)
                if (tv_letraAdivinar1?.isVisible == false) {
                    tv_letraAdivinar1?.setText(tv_letraSeleccionada4?.text.toString())
                    tv_letraAdivinar1?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada4?.text!!.get(0))

                } else if (tv_letraAdivinar2?.isVisible == false) {
                    tv_letraAdivinar2?.setText(tv_letraSeleccionada4?.text.toString())
                    tv_letraAdivinar2?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada4?.text!!.get(0))

                } else if (tv_letraAdivinar3?.isVisible == false) {
                    tv_letraAdivinar3?.setText(tv_letraSeleccionada4?.text.toString())
                    tv_letraAdivinar3?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada4?.text!!.get(0))

                } else if (tv_letraAdivinar4?.isVisible == false) {
                    tv_letraAdivinar4?.setText(tv_letraSeleccionada4?.text.toString())
                    tv_letraAdivinar4?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada4?.text!!.get(0))

                } else if (tv_letraAdivinar5?.isVisible == false) {
                    tv_letraAdivinar5?.setText(tv_letraSeleccionada4?.text.toString())
                    tv_letraAdivinar5?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada4?.text!!.get(0))

                } else if (tv_letraAdivinar6?.isVisible == false) {
                    tv_letraAdivinar6?.setText(tv_letraSeleccionada4?.text.toString())
                    tv_letraAdivinar6?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada4?.text!!.get(0))
                }


            }//end letraSeleccionada
            R.id.tvLetraSeleccionada5 -> {
                tv_letraSeleccionada5?.setVisibility(View.INVISIBLE)
                if (tv_letraAdivinar1?.isVisible == false) {
                    tv_letraAdivinar1?.setText(tv_letraSeleccionada5?.text.toString())
                    tv_letraAdivinar1?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada5?.text!!.get(0))

                } else if (tv_letraAdivinar2?.isVisible == false) {
                    tv_letraAdivinar2?.setText(tv_letraSeleccionada5?.text.toString())
                    tv_letraAdivinar2?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada5?.text!!.get(0))

                } else if (tv_letraAdivinar3?.isVisible == false) {
                    tv_letraAdivinar3?.setText(tv_letraSeleccionada5?.text.toString())
                    tv_letraAdivinar3?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada5?.text!!.get(0))

                } else if (tv_letraAdivinar4?.isVisible == false) {
                    tv_letraAdivinar4?.setText(tv_letraSeleccionada5?.text.toString())
                    tv_letraAdivinar4?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada5?.text!!.get(0))

                } else if (tv_letraAdivinar5?.isVisible == false) {
                    tv_letraAdivinar5?.setText(tv_letraSeleccionada5?.text.toString())
                    tv_letraAdivinar5?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada5?.text!!.get(0))

                } else if (tv_letraAdivinar6?.isVisible == false) {
                    tv_letraAdivinar6?.setText(tv_letraSeleccionada5?.text.toString())
                    tv_letraAdivinar6?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada5?.text!!.get(0))
                }


            }//end letraSeleccionada

            R.id.tvLetraSeleccionada6 -> {
                tv_letraSeleccionada6?.setVisibility(View.INVISIBLE)
                if (tv_letraAdivinar1?.isVisible == false) {
                    tv_letraAdivinar1?.setText(tv_letraSeleccionada6?.text.toString())
                    tv_letraAdivinar1?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada6?.text!!.get(0))

                } else if (tv_letraAdivinar2?.isVisible == false) {
                    tv_letraAdivinar2?.setText(tv_letraSeleccionada6?.text.toString())
                    tv_letraAdivinar2?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada6?.text!!.get(0))

                } else if (tv_letraAdivinar3?.isVisible == false) {
                    tv_letraAdivinar3?.setText(tv_letraSeleccionada6?.text.toString())
                    tv_letraAdivinar3?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada6?.text!!.get(0))

                } else if (tv_letraAdivinar4?.isVisible == false) {
                    tv_letraAdivinar4?.setText(tv_letraSeleccionada6?.text.toString())
                    tv_letraAdivinar4?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada6?.text!!.get(0))

                } else if (tv_letraAdivinar5?.isVisible == false) {
                    tv_letraAdivinar5?.setText(tv_letraSeleccionada6?.text.toString())
                    tv_letraAdivinar5?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada6?.text!!.get(0))

                } else if (tv_letraAdivinar6?.isVisible == false) {
                    tv_letraAdivinar6?.setText(tv_letraSeleccionada6?.text.toString())
                    tv_letraAdivinar6?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada6?.text!!.get(0))
                }


            }//end letraSeleccionada

            R.id.tvLetraSeleccionada7 -> {
                tv_letraSeleccionada7?.setVisibility(View.INVISIBLE)
                if (tv_letraAdivinar1?.isVisible == false) {
                    tv_letraAdivinar1?.setText(tv_letraSeleccionada7?.text.toString())
                    tv_letraAdivinar1?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada7?.text!!.get(0))

                } else if (tv_letraAdivinar2?.isVisible == false) {
                    tv_letraAdivinar2?.setText(tv_letraSeleccionada7?.text.toString())
                    tv_letraAdivinar2?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada7?.text!!.get(0))

                } else if (tv_letraAdivinar3?.isVisible == false) {
                    tv_letraAdivinar3?.setText(tv_letraSeleccionada7?.text.toString())
                    tv_letraAdivinar3?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada7?.text!!.get(0))

                } else if (tv_letraAdivinar4?.isVisible == false) {
                    tv_letraAdivinar4?.setText(tv_letraSeleccionada7?.text.toString())
                    tv_letraAdivinar4?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada7?.text!!.get(0))

                } else if (tv_letraAdivinar5?.isVisible == false) {
                    tv_letraAdivinar5?.setText(tv_letraSeleccionada7?.text.toString())
                    tv_letraAdivinar5?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada7?.text!!.get(0))

                } else if (tv_letraAdivinar6?.isVisible == false) {
                    tv_letraAdivinar6?.setText(tv_letraSeleccionada7?.text.toString())
                    tv_letraAdivinar6?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada7?.text!!.get(0))
                }


            }//end letraSeleccionada

            R.id.tvLetraSeleccionada8 -> {
                tv_letraSeleccionada8?.setVisibility(View.INVISIBLE)
                if (tv_letraAdivinar1?.isVisible == false) {
                    tv_letraAdivinar1?.setText(tv_letraSeleccionada8?.text.toString())
                    tv_letraAdivinar1?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada8?.text!!.get(0))

                } else if (tv_letraAdivinar2?.isVisible == false) {
                    tv_letraAdivinar2?.setText(tv_letraSeleccionada8?.text.toString())
                    tv_letraAdivinar2?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada8?.text!!.get(0))

                } else if (tv_letraAdivinar3?.isVisible == false) {
                    tv_letraAdivinar3?.setText(tv_letraSeleccionada8?.text.toString())
                    tv_letraAdivinar3?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada8?.text!!.get(0))

                } else if (tv_letraAdivinar4?.isVisible == false) {
                    tv_letraAdivinar4?.setText(tv_letraSeleccionada8?.text.toString())
                    tv_letraAdivinar4?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada8?.text!!.get(0))

                } else if (tv_letraAdivinar5?.isVisible == false) {
                    tv_letraAdivinar5?.setText(tv_letraSeleccionada8?.text.toString())
                    tv_letraAdivinar5?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada8?.text!!.get(0))

                } else if (tv_letraAdivinar6?.isVisible == false) {
                    tv_letraAdivinar6?.setText(tv_letraSeleccionada8?.text.toString())
                    tv_letraAdivinar6?.setVisibility(View.VISIBLE)
                    respuestaArray.add(tv_letraSeleccionada8?.text!!.get(0))
                }


            }//end letraSeleccionada


        }
    }
}