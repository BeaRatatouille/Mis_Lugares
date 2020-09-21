package com.example.mislugares

import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.edicion_lugar.*
import kotlinx.android.synthetic.main.edicion_lugar.direccion
import kotlinx.android.synthetic.main.edicion_lugar.nombre
import kotlinx.android.synthetic.main.edicion_lugar.telefono
import kotlinx.android.synthetic.main.vista_lugar.*
import java.util.*


class EdicionLugarActivity : AppCompatActivity() {
    val lugares = LugaresLista()
    var pos = 0
    lateinit var lugar: Lugar

    override fun onCreate(savedInstanceState: Bundle?) {
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,lugar.TipoLugar.getNombres())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edicion_lugar)
        pos = intent.extras?.getInt("pos", 0) ?: 0
        lugares.addEjemplos()
        lugar = lugares.elemento(pos)
        actualizaVistas()
    }

    fun actualizaVistas(){
        nombre.setText(lugar.nombre)
        direccion.setText (lugar.TipoLugar.texto)
        telefono.setText (lugar.direccion)
        paginaWeb.setText (lugar.url)
        comentarios.setText (lugar.comentarios)
    }
}