package de.monau.utils.extensions

import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import de.monau.ToolbarHost

fun Fragment.setToolbarTitle(title: String) {
    val activity = this.activity
    if (activity is ToolbarHost) activity.toolbarTitle = title
}

val View.inflater: LayoutInflater
    get() = LayoutInflater.from(context)
