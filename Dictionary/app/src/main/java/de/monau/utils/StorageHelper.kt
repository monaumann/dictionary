package de.monau.utils

import android.content.Context
import de.monau.models.Verb
import javax.inject.Inject

class StorageHelper @Inject constructor(
    private val fileHelper: FileHelper,
    private val verbHelper: VerbHelper,
) {

    fun writeLines(context: Context, lines: List<String>) =
        fileHelper.writeLines(context, lines)

    fun readVerbs(context: Context): List<Verb> {
        val verbs = mutableListOf<Verb>()
        for (line in fileHelper.readLines(context)) {
            verbHelper.convert(line)
                ?.let(verbs::add)
        }
        return verbs
    }
}