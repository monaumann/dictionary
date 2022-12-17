package de.monau.utils

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
        val expectedVerb = Verb(
            infinitiveEs = "SER",
            yo = "soy",
            tu = "eres",
            el = "es",
            nosotros = "somos",
            vosotros = "sois",
            ellos = "son",
            type = "irregular",
        )

        tested.convert(CORRECT_LINE)!!
            .assertEquals(expectedVerb)
    }
}