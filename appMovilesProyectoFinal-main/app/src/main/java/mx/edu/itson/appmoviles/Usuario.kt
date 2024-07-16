package mx.edu.itson.appmoviles

import java.io.Serializable

data class Usuario(
    var uid: String?=null,
    var correoElectronico: String?=null,
    var nombreUsuario: String?=null,
    var perfiles: ArrayList<PerfilUsuario> = ArrayList()


): Serializable{
    override fun toString() = correoElectronico + "\t" + nombreUsuario
}
