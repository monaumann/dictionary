package de.monau.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import de.monau.adapters.AdapterViewTypes.CONJUGATION_VIEW_TYPE
import de.monau.databinding.ItemVerbPersonBinding
import de.monau.models.Verb
import de.monau.utils.extensions.inflater
import de.monau.utils.extensions.person
import de.monau.viewholders.VerbPersonVH
import javax.inject.Inject

private const val PERSONS_COUNT = 6

class ConjugationAdapter @Inject constructor(
    private val inflater: BindingInflater
) : Adapter<VerbPersonVH>() {

    private lateinit var verb: Verb

    fun bind(verb: Verb) { this.verb = verb }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VerbPersonVH(inflater.inflate(parent))

    override fun onBindViewHolder(holder: VerbPersonVH, position: Int) =
        holder.bind(verb.person(position))

    override fun getItemCount(): Int = PERSONS_COUNT

    override fun getItemViewType(position: Int) =
        CONJUGATION_VIEW_TYPE
}

class BindingInflater @Inject constructor() {

    fun inflate(view: View) =
        ItemVerbPersonBinding.inflate(view.inflater)
}