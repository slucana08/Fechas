package com.kotlin.cursos.fechas

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cambiarFecha(view: View){
        var c = Calendar.getInstance()
        var dia = c.get(Calendar.DAY_OF_MONTH)
        var mes = c.get(Calendar.MONTH)
        var anio = c.get(Calendar.YEAR)

        val datePicker = DatePickerDialog(this,
                android.R.style.ThemeOverlay_Material,
                DatePickerDialog.OnDateSetListener{DatePicker,Year,Month,Day ->
                    textView.text = "$Day/${Month +1}/$Year" },
                anio, mes, dia)
        datePicker.show()
    }

    fun cambiarHora(view: View){
        var c = Calendar.getInstance()
        var hora = c.get(Calendar.HOUR_OF_DAY)
        var minutos = c.get(Calendar.MINUTE)
        var countHora = 0
        var countMinutos = 0

        val timePicker = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener{TimePicker,hour,minute ->
                    hora = hour
                    minutos = minute
                    while (hora != 0) {
                        hora /= 10
                        ++countHora
                    }
                    while (minutos != 0) {
                        minutos /= 10
                        ++countMinutos
                    }
                    if (countHora != 1 && countMinutos !=1)
                        textView2.text = "$hour:$minute"
                    else
                        textView2.text = "0$hour:0$minute"
                }, hora, minutos,true)
        timePicker.show()

    }
}
