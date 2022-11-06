package com.example.wzorce_projektowe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView
import com.example.wzorce_projektowe.Algorytm_dijkstra
import com.example.wzorce_projektowe.R
import com.example.wzorce_projektowe.graph

class MainActivity : AppCompatActivity() {

    lateinit var i: NumberPicker;
    lateinit var j: NumberPicker;
    lateinit var zastosuj: Button
    lateinit var wynik: TextView

    lateinit var graf: graph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        i = findViewById(R.id.i_numberpckr)
        j = findViewById(R.id.j_numberpckr)
        zastosuj = findViewById(R.id.zastosuj_btn)
        wynik = findViewById(R.id.wartosc_edttxt)


        zastosuj.setOnClickListener {
            val algorytm_dijkstra = Algorytm_dijkstra(graf)
            val sciezka = algorytm_dijkstra.pathfind(i.value,j.value)

            wynik.text = sciezka?.toString() ?: "Brak drogi"
            Log.d("sciezka", sciezka?.toString() ?: "Brak drogi")
        }


        graf = graph(10,25,10)

        i.minValue = 0;
        i.maxValue  = 9;

        j.minValue = 0;
        j.maxValue  = 9;



    }
}

