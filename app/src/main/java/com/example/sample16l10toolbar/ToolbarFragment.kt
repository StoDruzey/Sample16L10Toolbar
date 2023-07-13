package com.example.sample16l10toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sample16l10toolbar.databinding.FragmentToolbarBinding
import com.google.android.material.snackbar.Snackbar

class ToolbarFragment : Fragment() {

    private var _binding: FragmentToolbarBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentToolbarBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            textView.text = "Menu"
//            toolbar.inflateMenu(R.menu.menu_toolbar)
            toolbar.setNavigationOnClickListener {
//                findNavController().navigateUp()
                Toast.makeText(requireContext(), "1234", Toast.LENGTH_SHORT).show()
            }
            toolbar.setOnMenuItemClickListener {
//                if (it.itemId == R.id.menu_item1) {
//                    true
//                } else {
//                    false
//                }
                when (it.itemId) {
                    R.id.menu_search -> {
                        toolbar
                            .menu
                            .findItem(R.id.menu_search)
                            .actionView
                            .let { it as SearchView }
                            .setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                                override fun onQueryTextSubmit(p0: String): Boolean {
                                    TODO("Not yet implemented")
                                }

                                override fun onQueryTextChange(p0: String): Boolean {
                                    TODO("Not yet implemented")
                                }
                            })
//                        Toast.makeText(
//                            requireContext(), "Menu1", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.menu_item2 -> {
                        Snackbar.make(view, "Menu2", Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    R.id.menu_item3 -> {
                        Snackbar.make(view, "Menu3", Snackbar.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}