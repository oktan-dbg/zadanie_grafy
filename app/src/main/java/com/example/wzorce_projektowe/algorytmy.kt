package com.example.wzorce_projektowe

data class Droga(val przebyte_wierzcholki: List<Int>,val sciezka: Int)

abstract class Algorithm(val graph: graph) {

    abstract fun pathfind(s: Int, e:Int):Droga?

}