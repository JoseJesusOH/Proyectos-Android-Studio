package mx.edu.itson.practica4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val button: Button =findViewById(R.id.sign_int_button)
        button.setOnClickListener(){
            var intent: Intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
    }
}