package com.example.cocktail_bar

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView

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
        val cardViewImageCocktail: CardView = view.findViewById(R.id.cardViewImageCocktail)

        cancelButton.setOnClickListener{
            requireActivity().supportFragmentManager.popBackStack()
        }

        cardViewImageCocktail.setOnClickListener{
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            loadSelectedImage(selectedImageUri)
        }
    }

    private fun loadSelectedImage(imageUri: Uri?) {
        val imageView = view?.findViewById<ImageView>(R.id.imageCocktail)
        val inputStream = imageUri?.let { requireActivity().contentResolver.openInputStream(it) }
        val bitmap = BitmapFactory.decodeStream(inputStream)
        imageView?.setImageBitmap(bitmap)
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateCocktailsFragment()
        private const val GALLERY_REQUEST_CODE = 123
    }
}