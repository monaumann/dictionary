package de.monau.utils

import de.monau.models.Verb
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.mockito.Mockito.verifyNoInteractions

private const val LINE = "SER:soy,eres,es,somos,sois,son:irregular"
private val LINES = listOf(LINE)

internal class StorageHelperTest {

    private val fileHelper = mock<FileHelper>()
    private val verbHelper = mock<VerbHelper>()
    private val tested = StorageHelper(fileHelper, verbHelper)

    @Test
    fun `writeLines calls fileHelper_writeLines`() {
        tested.writeLines(LINES)

        verify(fileHelper).writeLines(LINES)
    }

    @Test
    fun `readVerbs calls fileHelper_readLines but not verbHelper when no lines read`() {
        tested.readVerbs().assertEquals(listOf<Verb>())

        verify(fileHelper).readLines()
        verifyNoInteractions(verbHelper)
    }

    @Test
    fun `readVerbs calls fileHelper_readLines and verbHelper when lines read`() {
        whenever(fileHelper.readLines()).thenReturn(LINES)

        tested.readVerbs().assertEquals(listOf<Verb>())

        verify(fileHelper).readLines()
        verify(verbHelper).convert(LINE)
    }

    @Test
    fun `readVerbs returns expected verb`() {
        val verb = mock<Verb>()
        whenever(fileHelper.readLines()).thenReturn(LINES)
        whenever(verbHelper.convert(LINE)).thenReturn(verb)

        tested.readVerbs().assertEquals(listOf(verb))
    }
}