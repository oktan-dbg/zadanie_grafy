package com.example.wzorce_projektowe

data class Path(val nodes: List<Int>,val cost: Int)

abstract class Algorithm(val graph: graph) {

    abstract fun pathfind(s: Int, e:Int):Path?

}