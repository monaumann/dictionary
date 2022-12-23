package de.monau.viewholders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import de.monau.databinding.ItemVerbPersonBinding
import de.monau.models.PersonConjugation

class VerbPersonVH(
    private val binding: ItemVerbPersonBinding
) : ViewHolder(binding.root) {

    fun bind(personPair: PersonConjugation) {
        binding.person.text = "${personPair.first}:"
        binding.conjugation.text = personPair.second
    }
}