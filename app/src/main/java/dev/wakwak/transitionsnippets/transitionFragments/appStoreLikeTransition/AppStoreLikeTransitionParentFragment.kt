package dev.wakwak.transitionsnippets.transitionFragments.appStoreLikeTransition


import android.content.Context
import android.graphics.Matrix
import android.graphics.RectF
import android.os.Bundle
import android.os.Parcelable
import android.transition.Fade
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.SharedElementCallback
import androidx.core.transition.addListener
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

import dev.wakwak.transitionsnippets.R

class AppStoreLikeTransitionParentFragment : Fragment() {

    companion object {
        fun newInstance() =
                AppStoreLikeTransitionParentFragment()
    }

    private var adapter: AppStoreItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (sharedElementEnterTransition as? Transition)?.addListener(onStart = {
            val targets = it.targets
        })
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_store_like_transition_parent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (adapter == null) {
            adapter = AppStoreItemAdapter { holder, id ->
                requireActivity().supportFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .addSharedElement(holder.itemView.findViewById(R.id.container), holder.itemView.findViewById<View>(R.id.container).transitionName)
                        .replace(R.id.fragment_container, AppStoreLikeTransitionChildFragment.newInstance(id.toString()).apply {
                            enterTransition = Fade()
                            exitTransition = Fade().excludeTarget(holder.itemView.findViewById<View>(R.id.container), true)
                            this@AppStoreLikeTransitionParentFragment.exitTransition = Fade()
                        })
                        .commit()
            }
        }
        val rv = view.findViewById<RecyclerView>(R.id.recycler_view)
        rv.adapter = adapter
    }
}
