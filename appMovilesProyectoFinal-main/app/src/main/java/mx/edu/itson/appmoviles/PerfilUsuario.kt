package mx.edu.itson.appmoviles

import java.io.Serializable

data class PerfilUsuario(
    val nombre: String?=null,
    val edad: Int?=null,
    val imagen: Int?=null,
    val numPerfil: Int?=null,
    var bibliotecaHistorias: ArrayList<Int> = ArrayList(),
    var porcentajes: ArrayList<Int> = ArrayList(),
    var temasFavoritos: ArrayList<String> = ArrayList()
): Serializable
