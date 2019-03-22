package dev.wakwak.transitionsnippets.transitionFragments.appStoreLikeTransition


import android.content.Context
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.transition.addListener
import androidx.fragment.app.Fragment
import dev.wakwak.transitionsnippets.R
import android.animation.ObjectAnimator


class AppStoreLikeTransitionChildFragment : Fragment() {

    companion object {
        fun newInstance(key: String) = AppStoreLikeTransitionChildFragment().apply {
            arguments = bundleOf(
                    "key" to key
            )
        }
    }

    private val key by lazy { arguments?.getString("key") }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        postponeEnterTransition()
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.app_store_like_transition)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(R.transition.app_store_like_transition)
        (sharedElementEnterTransition as Transition)
                .setDuration(250)
                .addListener(onStart = {
                    val animator = ObjectAnimator.ofFloat(view?.findViewById(R.id.container), "radius", 0f)
                    animator.duration = 250
                    animator.start()
                })
        //(sharedElementReturnTransition as Transition).duration = 5000

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_app_store_like_transition_child, container, false)
        view.findViewById<View>(R.id.container).transitionName = "container:$key"
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startPostponedEnterTransition()
    }
}
