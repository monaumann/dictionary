package de.monau.models

typealias PersonConjugation = Pair<String, String>

data class Verb(
    val infinitiveEs: String,
    val yo: String,
    val tu: String,
    val el: String,
    val nosotros: String,
    val vosotros: String,
    val ellos: String,
    val type: String
)