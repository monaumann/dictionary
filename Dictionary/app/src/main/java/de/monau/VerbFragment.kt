package de.monau

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import de.monau.adapters.ConjugationAdapter
import de.monau.databinding.FragmentVerbBinding
import de.monau.utils.StorageHelper
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.infinitive.setOnClickListener {
            findNavController().navigate(R.id.action_VerbFragment_to_SecondFragment)
        }
    }

    private fun bindVerb() {
        val verb = storageHelper.readVerbs()[0]
        adapter.bind(verb)
        binding.infinitive.text = "${verb.infinitiveEs} (${verb.type})"
        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.adapter = adapter
    }
}