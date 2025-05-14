package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var edtNota: EditText? = null
    var btnValidar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNota = findViewById<EditText>(R.id.edtNota)
        val validarButton = findViewById<Button>(R.id.btnValidar)

        validarButton.setOnClickListener(View.OnClickListener {
            val notaTexto = edtNota?.text.toString().trim { it <= ' ' }
            if (notaTexto.isEmpty()) {
                Toast.makeText(this@MainActivity, "Ingrese una nota válida", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }

            val nota = notaTexto.toInt()

            val resultado = if (nota >= 91 && nota <= 100) {
                "A (Excelente)"
            } else if (nota >= 81) {
                "B (Bueno)"
            } else if (nota >= 71) {
                "C (Regular)"
            } else if (nota >= 61) {
                "D (Más o menos regular)"
            } else {
                "No Aprobado"
            }
            Toast.makeText(this@MainActivity, "Resultado: $resultado", Toast.LENGTH_LONG).show()
        })
    }
}