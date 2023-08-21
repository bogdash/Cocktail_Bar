package com.example.cocktail_bar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CreateCocktailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_cocktails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cancelButton: Button = view.findViewById(R.id.buttonCancel)

        cancelButton.setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = CreateCocktailsFragment()
    }
}