package de.monau

import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment

open class BindingDaggerFragment<Binding : ViewBinding> : DaggerFragment() {

    @Suppress("PropertyName")
    internal var _binding: Binding? = null

    // This property is only valid between onCreateView and onDestroyView.
    internal val binding: Binding
        get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}