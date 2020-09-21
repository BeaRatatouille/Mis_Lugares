package com.example.mislugares

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.vista_lugar.*
import java.text.DateFormat
import java.util.*


class VistaLugarActivity : AppCompatActivity() {
    val lugares = LugaresLista()
    var pos = 0
    lateinit var lugar: Lugar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_lugar)
        pos = intent.extras?.getInt("pos", 0) ?: 0
        lugares.addEjemplos()
        lugar = lugares.elemento(pos)
        actualizaVistas()
    }

    fun actualizaVistas(){
        nombre.text = lugar.nombre
        logo_tipo.setImageResource(
            when (lugar.TipoLugar) {
                TipoLugar.RESTAURANTE -> R.drawable.restaurante
                TipoLugar.OTROS -> R.drawable.otros
                TipoLugar.BAR -> R.drawable.bar
                TipoLugar.COMPRAS -> R.drawable.compras
                TipoLugar.COPAS -> R.drawable.copas
                TipoLugar.DEPORTE -> R.drawable.deporte
                TipoLugar.EDUCACION -> R.drawable.educacion
                TipoLugar.ESPECTACULO -> R.drawable.espectaculos
                TipoLugar.GASOLINERA -> R.drawable.gasolinera
                TipoLugar.HOTEL -> R.drawable.hotel
                TipoLugar.NATURALEZA -> R.drawable.naturaleza
            }
        )

        direccion.text = lugar.TipoLugar.texto
        telefono.text = lugar.direccion
        Tipo.text = Integer.toString(lugar.telefono)
        paginaWeb.text = lugar.url
        comentarios.text = lugar.comentarios
        fecha.text = DateFormat.getDateInstance().format(Date(lugar.fecha))
        hora.text = DateFormat.getTimeInstance().format(Date(lugar.fecha))
        valoracion.rating = lugar.valoracion
        valoracion.setOnRatingBarChangeListener {
                ratingBar, valor, fromUser -> lugar.valoracion = valor
        }
    }
}