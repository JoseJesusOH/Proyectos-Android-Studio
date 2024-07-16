package mx.edu.itson.examenu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txError: TextView = findViewById(R.id.txtError)
        val etC: EditText = findViewById(R.id.etC)
        val etF: EditText = findViewById(R.id.etF)
        val etK: EditText = findViewById(R.id.etK)
        val btnC: Button = findViewById(R.id.btnGC)
        val btnF: Button = findViewById(R.id.btnGF)
        val btnK: Button = findViewById(R.id.btnGK)
        btnC.setOnClickListener {
            txError.setText("")
            if (etC.text.toString().isEmpty() == false || etF.text.toString()
                    .isEmpty() == false || etK.text.toString().isEmpty() == false
            ) {
                var kelvin: Double = 0.0
                var fahrenheit: Double = 0.0
                if (etC.text.toString().isEmpty()) {
                    try {
                        kelvin = etK.text.toString().toDouble()
                    } catch (e: java.lang.Exception) {
                    }
                    try {
                        fahrenheit = etF.text.toString().toDouble()
                    } catch (e: java.lang.Exception) {
                    }
                    if (kelvin != 0.0 && fahrenheit != 0.0) {
                        txError.setText("Solo se requiere que ingrese un valor  kelvin o fahrenheit")
                    } else {
                        if (kelvin == 0.0 && fahrenheit != 0.0) {
                            etC.setText("%.4f".format(((fahrenheit - 32) / (1.8))))
                        } else if (kelvin != 0.0 && fahrenheit == 0.0) {
                            etC.setText("%.4f".format((kelvin - 273.15)))
                        }
                    }
                } else {
                    txError.setText("No se puede realizar una conversion de celsius a celsius")
                }
            } else {
                txError.setText("Se requiere que ingrese algun valor antes de realizar alguna conversion")
            }
        }
        btnK.setOnClickListener {
            txError.setText("")
            if (etC.text.toString().isEmpty() == false || etF.text.toString()
                    .isEmpty() == false || etK.text.toString().isEmpty() == false
            ) {
                var celsius: Double = 0.0
                var kelvin: Double = 0.0
                var fahrenheit: Double = 0.0

                try {
                    kelvin = etK.text.toString().toDouble()
                } catch (e: java.lang.Exception) {
                }

                if (kelvin == 0.0) {
                    try {
                        fahrenheit = etF.text.toString().toDouble()
                    } catch (e: java.lang.Exception) {
                    }
                    try {
                        celsius = etC.text.toString().toDouble()
                    } catch (e: java.lang.Exception) {
                    }
                    if (celsius != 0.0 && fahrenheit != 0.0) {
                        txError.setText("Solo se requiere que ingrese un valor  celsius o fahrenheit")
                    } else {
                        if (celsius == 0.0 ) {
var respuesta:Double=(fahrenheit - 32) * 5 / 9 + 273.15
                            etK.setText(String.format("%.4f",(respuesta)))
                        } else if (celsius != 0.0) {
                            etK.setText("%.4f".format(celsius + 273.15))
                        }
                    }
                } else {
                    txError.setText("No se puede realizar una conversion de kelvin a kelvin")
                }
            } else {
                txError.setText("Se requiere que ingrese algun valor antes de realizar alguna conversion")
            }
        }
        btnF.setOnClickListener {
            txError.setText("")
            if (etC.text.toString().isEmpty() == false || etF.text.toString()
                    .isEmpty() == false || etK.text.toString().isEmpty() == false
            ) {
                var celsius: Double = 0.0
                var kelvin: Double = 0.0

                if (etF.text.toString().isEmpty()) {
                    try {
                        kelvin = etK.text.toString().toDouble()
                    } catch (e: java.lang.Exception) {
                    }
                    try {
                        celsius = etC.text.toString().toDouble()
                    } catch (e: java.lang.Exception) {
                    }
                    if (celsius != 0.0 && kelvin != 0.0) {
                        txError.setText("Solo se requiere que ingrese un valor  celsius o kelvin")
                    } else {
                        if (celsius == 0.0 && kelvin != 0.0) {
                            var result =( (kelvin - 273.15) * (9 ))/ 5 + 32
                            etF.setText("%.4f".format(result))
                        } else if (celsius != 0.0 && kelvin == 0.0) {
                            var result = celsius * 9 / 5 + 32
                            etF.setText("%.4f".format(result))
                        }
                    }
                } else {
                    txError.setText("No se puede realizar una conversion de fahrenheit a fahrenheit")
                }
            } else {
                txError.setText("Se requiere que ingrese algun valor antes de realizar alguna conversion")
            }
        }
    }

}