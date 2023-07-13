package com.example.sample16l10toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sample16l10toolbar.databinding.FragmentToolbarBinding

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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}