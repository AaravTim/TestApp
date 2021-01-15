package com.example.testapplication.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.testapplication.R
import com.example.testapplication.ui.home.HomeViewModel
import java.util.Observer


class CategoriesFragment : Fragment() {

    private lateinit var categoriesViewModel: CategoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        categoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_categories, container, false)
        val textView: TextView = root.findViewById(R.id.text_categories)
        categoriesViewModel.text.observe(viewLifecycleOwner,  {
            textView.text = it
        })
        return root
    }
}