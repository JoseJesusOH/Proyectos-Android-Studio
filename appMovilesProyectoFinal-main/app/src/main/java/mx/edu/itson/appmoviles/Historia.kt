package mx.edu.itson.appmoviles

import java.io.Serializable

data class Historia(
    var id: Int?=null,
    var image: Int?=null,
    var titulo: String?=null,
    var autor: String?=null,
    var numPaginas: String?=null,
    var sinopsisi: String?=null,
    var generos: ArrayList<String> = ArrayList(),
    var imagenes: ArrayList<Int> = ArrayList(),
    var parrafos: ArrayList<String> = ArrayList(),
    var pregunta: String?=null,
    var respuesta: String?=null,
    var opciones: ArrayList<Char> = ArrayList()

    ) : Serializable