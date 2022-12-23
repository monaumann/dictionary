package de.monau.utils.extensions

import android.util.Log
import de.monau.models.PersonConjugation
import de.monau.models.Verb

fun Verb.person(position: Int): PersonConjugation =
    when (position) {
        0 -> "yo" to yo
        1 -> "tú" to tu
        2 -> "el" to el
        3 -> "nosotros" to nosotros
        4 -> "vosotros" to vosotros
        5 -> "ellos" to ellos
        else -> "" to ""
    }

fun List<Verb>.print() {
    for (verb in this) verb.print()
}

fun Verb.print() {
    Log.d("development", "-------------------------")
    Log.d("development", "$infinitiveEs ($type)")
    Log.d("development", "Yo $yo")
    Log.d("development", "Tú $tu")
    Log.d("development", "El $el")
    Log.d("development", "Nosotros $nosotros")
    Log.d("development", "Vosotros $vosotros")
    Log.d("development", "Ellos $ellos")
}