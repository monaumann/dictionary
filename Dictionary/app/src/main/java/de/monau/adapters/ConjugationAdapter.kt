package de.monau.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import de.monau.models.Verb
import javax.inject.Inject

private const val PERSONS_COUNT = 6

class ConjugationAdapter @Inject constructor() : Adapter<ViewHolder>() {

    private lateinit var verb: Verb

    fun bind(verb: Verb) { this.verb = verb }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return object : ViewHolder(View(parent.context)) {}
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = PERSONS_COUNT
}