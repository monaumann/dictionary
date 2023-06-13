package de.monau

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import de.monau.adapters.ConjugationAdapter
import de.monau.databinding.FragmentVerbBinding
import de.monau.utils.StorageHelper
import de.monau.utils.extensions.setToolbarTitle
import javax.inject.Inject

class VerbFragment : BindingDaggerFragment<FragmentVerbBinding>() {

    @Inject
    lateinit var adapter: ConjugationAdapter

    @Inject
    lateinit var storageHelper: StorageHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerbBinding.inflate(inflater, container, false)
        bindVerb()
        return binding.root
    }

    private fun bindVerb() {
        val verb = storageHelper.readVerbs()[0]
        adapter.bind(verb)
        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.adapter = adapter
        setToolbarTitle("${verb.infinitiveEs} (${verb.type})")
    }
}