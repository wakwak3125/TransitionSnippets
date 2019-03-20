package dev.wakwak.transitionsnippets.transitionFragments.appStoreLikeTransition


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import dev.wakwak.transitionsnippets.R

class AppStoreLikeTransitionParentFragment : Fragment() {

    companion object {
        fun newInstance() =
            AppStoreLikeTransitionParentFragment()
    }

    private var adapter: AppStoreItemAdapter? = null

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
            adapter = AppStoreItemAdapter()
        }
        val rv = view.findViewById<RecyclerView>(R.id.recycler_view)
        rv.adapter = adapter
    }
}
