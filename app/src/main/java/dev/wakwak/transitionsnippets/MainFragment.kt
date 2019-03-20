package dev.wakwak.transitionsnippets


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.wakwak.transitionsnippets.transitionFragments.appStoreLikeTransition.AppStoreLikeTransitionParentFragment

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var adapter: MenuRecyclerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = view.findViewById<RecyclerView>(R.id.menu_recycler_view)
        if (adapter == null) {
            adapter = MenuRecyclerAdapter(listOf(
                MenuRecyclerAdapter.MenuItem(0, "AppStore like Transition")
            )) {
                when(it.id) {
                    0L -> commitFragment(AppStoreLikeTransitionParentFragment.newInstance())
                    else -> {}
                }
            }
        }
        rv.adapter = adapter
    }

    private fun commitFragment(fragment: Fragment) {
        (requireActivity() as? MainActivity)?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.addToBackStack(fragment::class.java.simpleName)
            ?.commit()
    }
}
