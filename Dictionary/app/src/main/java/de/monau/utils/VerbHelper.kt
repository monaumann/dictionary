package de.monau.utils

import de.monau.models.Verb
import javax.inject.Inject

private const val LINE_DELIMITER = ":"
private const val VERB_DELIMITER = ","
private const val SPLIT_LINE_SIZE = 3
private const val VERBS_SIZE = 6
private const val INFINITIVE_INDEX = 0
private const val VERBS_INDEX = 1
private const val TYPE_INDEX = 2
private const val YO_INDEX = 0
private const val TU_INDEX = 1
private const val EL_INDEX = 2
private const val NOSOTROS_INDEX = 3
private const val VOSOTROS_INDEX = 4
private const val ELLOS_INDEX = 5

class VerbHelper @Inject constructor() {

    fun convert(line: String): Verb? {
        val splitText = line.split(LINE_DELIMITER)
        return if (splitText.size == SPLIT_LINE_SIZE) {
            return convertVerb(splitText)
        } else null
    }

    private fun convertVerb(splitLine: List<String>): Verb? {
        val splitVerbs = splitLine[VERBS_INDEX].split(VERB_DELIMITER)
        return if (splitVerbs.size == VERBS_SIZE) {
            Verb(
                infinitiveEs = splitLine[INFINITIVE_INDEX],
                yo = splitVerbs[YO_INDEX],
                tu = splitVerbs[TU_INDEX],
                el = splitVerbs[EL_INDEX],
                nosotros = splitVerbs[NOSOTROS_INDEX],
                vosotros = splitVerbs[VOSOTROS_INDEX],
                ellos = splitVerbs[ELLOS_INDEX],
                type = splitLine[TYPE_INDEX],
            ).also { it.print() }
        } else null
    }
}