package mx.edu.itson.appmoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase

class cargaCatalogo : AppCompatActivity() {
    var catalogo: ArrayList<Historia> = ArrayList<Historia>()

    private var userRef = FirebaseDatabase.getInstance().getReference("libros")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carga_catalogo)
       // agregarHistorias()
        val btnCargarhistorias : Button =findViewById(R.id.btnCargarCatalogo)

        btnCargarhistorias.setOnClickListener {
            userRef.setValue(catalogo)
        }


    }

    /*
    private fun agregarHistorias() {

        catalogo.add(
            Historia(
                1, R.drawable.regaloprincesa,
                "El regalo de la princesa",
                "Paola Artmann",
                "6",
                "Érase una vez una pequeña princesa que al cumplir los diez años tuvo una fantástica fiesta. Había músicos, flores, helado de fresa y pasteles con glaseado rosa. Los invitados trajeron los más maravillosos regalos. Pero entre todos los regalos, uno en particular llamó la atención de la princesa. Era una caja pequeña, envuelta en papel dorado y con un lazo rojo. La princesa abrió la caja con cuidado y dentro encontró un espejo mágico que podía concederle cualquier deseo. Sin embargo, la princesa sabía que con grandes poderes venían grandes responsabilidades.",
                arrayListOf("Magia", "Fantacia"),
                arrayListOf(
                    R.drawable.princesa1,
                    R.drawable.princesa2,
                    R.drawable.princesa3,
                    R.drawable.princesa4,
                    R.drawable.princesa5,
                    R.drawable.princesa6
                ), // Imágenes no especificadas
                arrayListOf(
                    //6
                    "La princesa recibió muchos regalos en su fiesta de cumpleaños.",
                    "Uno de los regalos era una caja envuelta en papel dorado con un lazo rojo.",
                    "Dentro de la caja encontró un espejo mágico que podía concederle cualquier deseo.",
                    "La princesa sabía que con grandes poderes venían grandes responsabilidades.",
                    "La princesa aprendió a usar el espejo mágico con sabiduría y bondad.",
                    "La princesa vivió feliz para siempre con el espejo mágico a su lado."
                ),
                "¿Qué regalaron a la princesa?",
                "ESPEJO",
                arrayListOf("P","C","O","A",
                    "E","S","E","J"

                )

            )
        )
        catalogo.add(
            Historia(
                2,
                R.drawable.reinanieves,
                "Blancanieves",
                "Jacob Grimm, Wilhelm Grimm",
                "8",
                "Había una vez una reina que anhelaba tener una hija, y un día sus deseos se cumplieron con el nacimiento de una hermosa niña de piel blanca como la nieve, labios rojos como la sangre y cabello negro como el ébano. Pero la felicidad no duró mucho tiempo, ya que la reina falleció poco después del nacimiento de su hija. El rey se volvió a casar con una mujer vanidosa y cruel, quien poseía un espejo mágico al que preguntaba quién era la más hermosa del reino. Cuando el espejo respondió que Blancanieves lo era, la madrastra se enfureció y ordenó la muerte de la joven. Sin embargo, el cazador enviado para realizar la tarea se apiadó de Blancanieves y la dejó escapar. La joven llegó a un bosque, donde encontró refugio en una cabaña habitada por siete enanos. Pero la malvada madrastra descubrió que Blancanieves seguía viva y se disfrazó para envenenarla con una manzana. Afortunadamente, un príncipe la despertó de su sueño con un beso de amor verdadero y vivieron felices para siempre.",
                arrayListOf("Fantasía", "Aventura", "Magia", "Misterio"),
                arrayListOf(
                    R.drawable.blanca1,
                    R.drawable.blanca2,
                    R.drawable.blanca3,
                    R.drawable.blanca4,
                    R.drawable.blanca5,
                    R.drawable.blanca6,
                    R.drawable.blanca7,
                    R.drawable.blanca8
                ),
                arrayListOf(
                    "Una reina deseaba tener una hija, y su deseo se cumplió con el nacimiento de Blancanieves.",
                    "La reina falleció poco después del nacimiento de su hija, y el rey se volvió a casar con una mujer vanidosa y cruel.",
                    "La madrastra tenía un espejo mágico al que preguntaba quién era la más hermosa del reino.",
                    "Cuando el espejo respondió que Blancanieves lo era, la madrastra ordenó la muerte de la joven.",
                    "El cazador enviado para realizar la tarea se apiadó de Blancanieves y la dejó escapar.",
                    "Blancanieves llegó a un bosque y encontró refugio en una cabaña habitada por siete enanos.",
                    "La madrastra descubrió que Blancanieves seguía viva y se disfrazó para envenenarla con una manzana.",
                    "Un príncipe la despertó de su sueño con un beso de amor verdadero y vivieron felices para siempre."
                ),
                "¿Cuántos enanos hay en el cuento?",
                "SIETE",
                arrayListOf(
                    "O","A","S","E","S","T","I","E"
                )

            )
        )

        catalogo.add(
            Historia(
                3, R.drawable.cenicienta,
                "Cenicienta",
                "Clyde Geronimi",
                "5",
                "Érase una vez una hermosa joven que vivía con su madrastra y dos hermanastras que la obligaban a hacer todo el trabajo de la casa. La pobre joven tenía que cocinar, limpiar y también lavarles la ropa.",
                arrayListOf("Fantasia", "Magia"),
                arrayListOf(
                    R.drawable.cenicienta1,
                    R.drawable.cenicienta2,
                    R.drawable.cenicienta3,
                    R.drawable.cenicienta4,
                    R.drawable.cenicienta5
                ),
                // 5
                arrayListOf(
                    "Cenicienta quiere asistir al baile real, pero sus malvadas hermanastras le dicen que no puede ir.",
                    "Una hada madrina aparece para ayudar a Cenicienta, convirtiendo una calabaza en un carruaje y unos ratones en caballos.",
                    "Cenicienta asiste al baile con un hermoso vestido y zapatos de cristal, y se roba la atención del príncipe.",
                    "Cuando llega la medianoche, Cenicienta tiene que huir del baile y regresar a casa.",
                    "El príncipe queda enamorado de Cenicienta y busca por todo el pueblo para encontrarla."
                ),
                "¿A dónde quería ir Cenicienta?",
                "BAILE",
                arrayListOf("A","B","E","I","C","L","A","U"

                )
            )
        )
        catalogo.add(
            Historia(
                4, R.drawable.pinocho,
                "Pinocho",
                "Carlos Collodi",
                "6",
                "Érase una vez un anciano carpintero llamado Gepeto que era muy feliz haciendo juguetes de madera para los niños de su pueblo. Un día, hizo una marioneta de una madera de pino muy especial y decidió llamarla Pinocho. En la noche, un hada azul llegó al taller del anciano carpintero:",
                arrayListOf("Magia", "Aventura"),
                arrayListOf(
                    R.drawable.pinocho1,
                    R.drawable.pinocho2,
                    R.drawable.pinocho3,
                    R.drawable.pinocho4,
                    R.drawable.pinocho5,
                    R.drawable.pinocho6
                ),
                //6
                arrayListOf(
                    "Gepeto era un anciano carpintero que hacía juguetes de madera para los niños.",
                    "Un día, Gepeto decidió hacer una marioneta de madera de pino especial y la llamó Pinocho.",
                    "Esa noche, un hada azul llegó al taller del anciano carpintero y le dio vida a la marioneta.",
                    "Pinocho era una marioneta muy traviesa y desobediente, y siempre se metía en problemas.",
                    "Pinocho aprendió importantes lecciones sobre la honestidad y la responsabilidad durante sus aventuras.",
                    "Al final de la historia, Pinocho se convirtió en un niño de verdad gracias a su buen comportamiento."
                ),
                "¿Cuál era el nombre del anciano carpintero?",
                "GEPETO",
                arrayListOf("P","G","A","E","U","E","O","T"

                )
            )
        )

    }

     */
}