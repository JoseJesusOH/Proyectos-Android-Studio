package mx.edu.itson.practica4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Products : AppCompatActivity() {
    var antojitos=ArrayList<Product>()
    var especialidades=ArrayList<Product>()
    var combinaciones=ArrayList<Product>()
    var sopas=ArrayList<Product>()
    var tortas=ArrayList<Product>()
    var bebidas=ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
        agregarProductosAntojitos()
        agregarProductosEspecialidades()
        agregarProductosCombinaciones()
        agregarProductosSopas()
        agregarProductosTortas()
        agregarProductosBebidas()
        var listv:ListView= findViewById(R.id.litview) as ListView
        val botonSeleccionado = intent.getIntExtra("botonSeleccionado", 0) // 0 es un valor por defecto en caso de que el extra no exista
        var adaptador:AdaptadorProductos
        if (botonSeleccionado==1) {
            adaptador=AdaptadorProductos(this,antojitos)
            val imagen=findViewById(R.id.imgTitulo) as ImageView
            imagen.setImageResource(R.drawable.antojitos)
            listv.adapter=adaptador
        }

        if (botonSeleccionado==2) {
            adaptador=AdaptadorProductos(this,especialidades)
            val imagen=findViewById(R.id.imgTitulo) as ImageView
            imagen.setImageResource(R.drawable.especialidades)
            listv.adapter=adaptador
        }
        if (botonSeleccionado==3) {
            adaptador=AdaptadorProductos(this,combinaciones)
            val imagen=findViewById(R.id.imgTitulo) as ImageView
            imagen.setImageResource(R.drawable.combinations)
            listv.adapter=adaptador
        }
        if (botonSeleccionado==4) {
            adaptador=AdaptadorProductos(this,sopas)
            val imagen=findViewById(R.id.imgTitulo) as ImageView
            imagen.setImageResource(R.drawable.sopas)
            listv.adapter=adaptador
        }
        if (botonSeleccionado==5) {
            adaptador=AdaptadorProductos(this,tortas)
            val imagen=findViewById(R.id.imgTitulo) as ImageView
            imagen.setImageResource(R.drawable.tortas)
            listv.adapter=adaptador
        }
        if (botonSeleccionado==6) {
            adaptador=AdaptadorProductos(this,bebidas)
            val imagen=findViewById(R.id.imgTitulo) as ImageView
            imagen.setImageResource(R.drawable.drinks)
            listv.adapter=adaptador
        }

    }
    fun agregarProductosAntojitos(){
        antojitos.add(Product("Quesadillas",R.drawable.quesadillas,"Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.",5.9))
        antojitos.add(Product("Huaraches",R.drawable.huaraches,"Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big Thick tortilla with beans, your choice of meat, fresh cheese, and sour cream",10.85))
        antojitos.add(Product("Gringas",R.drawable.gringas,"Tortilla de harina con queso, carne al pastor y piña Flour tortilla with cheese marinated pork and pineapple",7.99))
        antojitos.add(Product("Sincronizadas",R.drawable.sincronizadas,"Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole Sandwich of Two four tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.",7.69))
        antojitos.add(Product("Sopes",R.drawable.sopes,"Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes",3.56))
        antojitos.add(Product("Tostadas",R.drawable.tostadas,"Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes",3.73))
    }
    fun agregarProductosEspecialidades(){
       especialidades.add(Product("Mojarra Frita - Fried Fish",R.drawable.mojarra,"Tilapia frita servida con lechiga, cebolla, jitomate, aguacate y tortillas. Agregue arroz y frijoles por $1.50 adicinales Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas. Add rice and beans for $1.50 extra.",15.99))
        especialidades.add(Product("Ceviche",R.drawable.ceviche,"Tilapia, camarones, Aguacate y pico de gallo servido con Chips  Tilapia, Shrimp, Avocado and pico de gallo, served with Chips",6.99))
        especialidades.add(Product("Fajita Burrito",R.drawable.burritos,"Gran burrito relleno de tu carne favorita, cebolla, chile, arroz, frijoles y jitomate. Servido con lechuga y guacamole Large burrito filled with your choice of meat, onions, chile, peppers, rice, beans and tomatoes. Served with lettuce guacamole and sour cream.",12.99))
        especialidades.add(Product("Fajita Quesadilla",R.drawable.fajitaquesadilla,"Quesadilla extra grande, rellena con tu carne favorita, cebolla asada, chile banana y jitomate. Servida con arroz, frijoles y ensalada Extra large quesadilla with your choice of meat, cooked with grilled onions, banana peppers and tomatoes. Served with rice beans and salad.",13.99))
        especialidades.add(Product("Botana de Camarones",R.drawable.botanacamarones,"Botana de camarones, revuelta consalsa especial.",17.99))
        especialidades.add(Product("Coctel de Camaron",R.drawable.coctel,"Baile y vive con este cocte.",14.50))

    }
    fun agregarProductosCombinaciones(){
        combinaciones.add(Product("Traditional Taco Combo",R.drawable.combinationtaco,"Tortilla de Maiz, tu carne favorita, servido con arroz y frijoles Corn tortilla taco, your choice of meat, served with rice and beans",6.99))
        combinaciones.add(Product("Mexican Burritos",R.drawable.cominationburros,"Your choice of meat on a big burrito made of flour tortilla with rice, beans, lettuce, grilled onions, pico de gallo, guacamole and sour cream.",11.99))
        combinaciones.add(Product("Los Portales Burrito",R.drawable.burritosportales,"A flour tortilla wrapped around grilled cactus, steak, pastor, (Seasoned Pork) grilled onions, rice and beans. Served a side of lettuce salad, tomatoes, sour cream and guacamole.",12.99))
        combinaciones.add(Product("Cinco",R.drawable.cinco,"One hard sell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream, guacamole and beans. Served with rice and beans.",7.99))
        combinaciones.add(Product("Dos Amigos",R.drawable.dosamigos,"Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese. served with a side of rice and beans",8.99))
        combinaciones.add(Product("Burrito Pepe",R.drawable.burritopepe,"A flour tortilla wrapped around your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo. served with a side of rice.",7.49))


    }

    fun agregarProductosTortas(){
        tortas.add(Product("Torta Regular",R.drawable.torta,"All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.",11.99))
        tortas.add(Product("Torta -Milanesa de Res o Pollo",R.drawable.tortamilanesa,"Breaded Steak or Chicken", 12.99))
        tortas.add(Product("Torta Cubana",R.drawable.tortacubana,"Chorizo, asada, jamon, pastor y queso Mexican sausage, steak, marinated pork, ham, and cheese", 13.59))
        tortas.add(Product("Torta Mixta",R.drawable.tortamixta,"Chorizo, asada y pastor. Mexican sausage, steak and marinated pork.",12.99))
        tortas.add(Product("Small Mexican Torta",R.drawable.smallmexican,"Bolillo bread sandwich with your of meat, shredded lettuce, avocado, tomato, onion and sour cream.",57.39))
    }


    fun agregarProductosSopas(){
        sopas.add(Product("Pozole",R.drawable.pozole,"Weekends only",5.99))
        sopas.add(Product("Menudo",R.drawable.menudo,"Wednesday to Sunday",5.99))
        sopas.add(Product("Caldo de Res",R.drawable.caldores,"",5.99))
        sopas.add(Product("Caldo de Camaron",R.drawable.caldocamaron,"Shrimp soup",12.99))
        sopas.add(Product("Sopa de Mariscos",R.drawable.sopamariscos,"Seafood soup",19.99))
        sopas.add(Product("Coctel de Camaron",R.drawable.sopamariscos,"Shrimp cocktail",14.99))

    }


    fun agregarProductosBebidas(){
        bebidas.add(Product("Sodas 20oz.",R.drawable.sodas,"",2.99))
        bebidas.add(Product("Jarritos",R.drawable.jarritos,"",2.35))
        bebidas.add(Product("Domestic Beer",R.drawable.domesticbeer,"",3.55))
        bebidas.add(Product("Mexican Beer",R.drawable.mexicanbeer,"",3.99))
        bebidas.add(Product("Micheladas",R.drawable.michelada,"",6.75))
        bebidas.add(Product("Caguama",R.drawable.caguama,"",8.99))
        bebidas.add(Product("Caguama Michelada",R.drawable.caguamamichelada,"",10.99))
        bebidas.add(Product("Cubetazos",R.drawable.cubetazo,"",21.99))
        bebidas.add(Product("Charolazo",R.drawable.charolazo,"",15.75))
        bebidas.add(Product("La Mamalona",R.drawable.caguamamichelada,"(michelada 2 Cervesas)",12.99))
        bebidas.add(Product("Cubetazo (6 cervesas)",R.drawable.cubetasix,"",21.99))
    }


    private class AdaptadorProductos:BaseAdapter{
   var productos=ArrayList<Product>()
        var contexto:Context?=null
        constructor(contexto: Context,productos:ArrayList<Product>){
        this.productos=productos
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
            var prod=productos[p0]
            var inflador=LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.producto_view,null)
            var imagen=vista.findViewById(R.id.producto_img)as ImageView
            var nombre=vista.findViewById(R.id.producto_nombre) as TextView
            var desc=vista.findViewById(R.id.producto_desc) as TextView
            var precio=vista.findViewById(R.id.producto_precio) as TextView
imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.descripcion)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}