package com.example.wzorce_projektowe

import java.util.PriorityQueue

data class Odleglosc(val n: Int,val c:Int)

class Algorytm_dijkstra(graf:graph) : Algorithm(graf) {

    override fun pathfind(s: Int, e: Int):Droga? {

        // poprzedni wierzchołek
        val pooprzedni_wierzcholek = MutableList(graph.nodeCount) { -1 }
        // Minimalna odległość
        val odleglosc = MutableList(graph.nodeCount) { -1 }
        // dystans z którego zaczynamy
        odleglosc[s] = 0;

        val kolejka = PriorityQueue<Odleglosc>(compareBy{it.c})

        kolejka.add(Odleglosc(s,0))

        while (!kolejka.isEmpty()) {
            val obecny_wierzcholek = kolejka.remove()

            for ( vertice in graph.adjacencyList[obecny_wierzcholek.n] ){
                if(obecny_wierzcholek.c + vertice.c > odleglosc[vertice.n] && odleglosc[vertice.n] != -1) continue

                odleglosc[vertice.n] = obecny_wierzcholek.c + vertice.c
                pooprzedni_wierzcholek[vertice.n] = obecny_wierzcholek.n
                kolejka.add(Odleglosc(vertice.n,odleglosc[vertice.n]))

            }

        }

        if(pooprzedni_wierzcholek[e] == -1) return null

        //wyliczanie ścieżki
        var sciezka: MutableList<Int> = mutableListOf()
        var i = e
        do{
            sciezka.add(i)
            i = pooprzedni_wierzcholek[i]
        }while(i != s)
        return Droga(sciezka.reversed(),odleglosc[e])

    }

}