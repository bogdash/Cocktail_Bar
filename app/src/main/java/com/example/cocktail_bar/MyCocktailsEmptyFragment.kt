package com.example.cocktail_bar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton

class MyCocktailsEmptyFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_cocktails_empty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addButton: AppCompatImageButton = view.findViewById(R.id.add_button)
        addButton.setOnClickListener{
            onClick()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyCocktailsEmptyFragment()
    }

    private fun onClick() {
        Toast.makeText(requireContext(), "Button Clicked!", Toast.LENGTH_LONG).show()

        val createCocktailsFragment = CreateCocktailsFragment()
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, createCocktailsFragment)
            .addToBackStack(null)
            .commit()
    }
}