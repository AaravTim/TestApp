package com.example.testapplication.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapplication.R

class OrdersFragment : Fragment() {

    private lateinit var ordersViewModel: OrdersViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        ordersViewModel =
                ViewModelProvider(this).get(OrdersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        ordersViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}