package de.monau.utils

import de.monau.constants.ESTAR
import de.monau.constants.HABLAR
import de.monau.constants.IR
import de.monau.constants.SER
import de.monau.models.Verb
import javax.inject.Inject

class StorageHelper @Inject constructor(
    private val fileHelper: FileHelper,
    private val verbHelper: VerbHelper,
) {

    init { writeLines(listOf(HABLAR, SER, ESTAR, IR)) }

    fun writeLines(lines: List<String>) =
        fileHelper.writeLines(lines)

    fun readVerbs(): List<Verb> {
        val verbs = mutableListOf<Verb>()
        for (line in fileHelper.readLines()) {
            verbHelper.convert(line)
                ?.let(verbs::add)
        }
        return verbs
    }
}