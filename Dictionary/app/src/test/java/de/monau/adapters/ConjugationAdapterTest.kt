package de.monau.adapters

import android.view.ViewGroup
import de.monau.adapters.AdapterViewTypes.CONJUGATION_VIEW_TYPE
import de.monau.databinding.ItemVerbPersonBinding
import de.monau.examples.verbSER
import de.monau.utils.assertEquals
import de.monau.utils.assertType
import de.monau.utils.extensions.person
import de.monau.viewholders.VerbPersonVH
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class ConjugationAdapterTest {

    private val parent = mock<ViewGroup>()
    private val viewHolder = mock<VerbPersonVH>()

    private val binding = mock<ItemVerbPersonBinding> {
        on { root } doReturn mock()
    }
    private val inflater = mock<BindingInflater> {
        on { inflate(parent) } doReturn binding
    }
    private val tested = ConjugationAdapter(inflater)

    @Test
    fun `adapterViewType is CONJUGATION_VIEW_TYPE`() {
        tested.getItemViewType(0)
            .assertEquals(CONJUGATION_VIEW_TYPE)
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun `onBindVH before passing verb causes exception`() {
        tested.onBindViewHolder(viewHolder, 0)
    }

    @Test
    fun `onBindVH after passing verb calls viewHolder_bind`() {
        tested.bind(verbSER)

        tested.onBindViewHolder(viewHolder, 0)

        verify(viewHolder).bind(verbSER.person(0))
    }

    @Test
    fun `onCreateVH returns VerbPersonVH`() {
        tested.onCreateViewHolder(parent, 0)
            .assertType(VerbPersonVH::class.java)
    }
}