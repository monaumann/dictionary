package de.monau.utils

import de.monau.examples.verbSER
import de.monau.models.Verb
import org.junit.Test

private const val ILLEGAL_LINE = ""
private const val CORRECT_LINE = "SER:soy,eres,es,somos,sois,son:irregular"

internal class VerbHelperTest {

    private val tested = VerbHelper()

    @Test
    fun `convert returns null for illegal line`() {
        tested.convert(ILLEGAL_LINE).assertNull()
    }

    @Test
    fun `convert returns expected Verb for correct line`() {
        val expectedVerb = verbSER

        tested.convert(CORRECT_LINE)!!
            .assertEquals(expectedVerb)
    }
}