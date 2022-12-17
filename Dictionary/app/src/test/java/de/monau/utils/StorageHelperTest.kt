package de.monau.utils

import android.content.Context
import de.monau.models.Verb
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.mockito.Mockito.verifyNoInteractions

private const val LINE = "SER:soy,eres,es,somos,sois,son:irregular"
private val LINES = listOf(LINE)

internal class StorageHelperTest {

    private val context = mock<Context>()

    private val fileHelper = mock<FileHelper>()
    private val verbHelper = mock<VerbHelper>()
    private val tested = StorageHelper(fileHelper, verbHelper)

    @Test
    fun `writeLines calls fileHelper_writeLines`() {
        tested.writeLines(context, LINES)

        verify(fileHelper).writeLines(context, LINES)
    }

    @Test
    fun `readVerbs calls fileHelper_readLines but not verbHelper when no lines read`() {
        tested.readVerbs(context).assertEquals(listOf<Verb>())

        verify(fileHelper).readLines(context)
        verifyNoInteractions(verbHelper)
    }

    @Test
    fun `readVerbs calls fileHelper_readLines and verbHelper when lines read`() {
        whenever(fileHelper.readLines(context)).thenReturn(LINES)

        tested.readVerbs(context).assertEquals(listOf<Verb>())

        verify(fileHelper).readLines(context)
        verify(verbHelper).convert(LINE)
    }

    @Test
    fun `readVerbs returns expected verb`() {
        val verb = mock<Verb>()
        whenever(fileHelper.readLines(context)).thenReturn(LINES)
        whenever(verbHelper.convert(LINE)).thenReturn(verb)

        tested.readVerbs(context).assertEquals(listOf(verb))
    }
}