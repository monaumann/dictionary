package de.monau.utils

import android.util.Log
import de.monau.models.Verb

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