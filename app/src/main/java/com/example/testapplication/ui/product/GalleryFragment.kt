package com.example.testapplication.ui.product

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testapplication.databinding.DialogFilterBinding
import com.example.testapplication.databinding.ProductBinding
import com.example.testapplication.ui.PackageAdapter

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var binding: ProductBinding

    private lateinit var packageAdapter : PackageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        packageAdapter = PackageAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductBinding.inflate(inflater, container, false)
        binding.rcyProduct.adapter = packageAdapter

        packageAdapter.setData(getList())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.fabFilter.setOnClickListener {
            showFilter()
        }


        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                packageAdapter.filter.filter(s.toString())
            }
        })

    }


    private fun showFilter(){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding = DialogFilterBinding.inflate(LayoutInflater.from(requireContext()))
        dialog.setContentView(binding.root)
        dialog.setCanceledOnTouchOutside(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        binding.btnSubmit.setOnClickListener {
            validation(binding,dialog)
        }
    }

    private fun validation(binding: DialogFilterBinding, dialog: Dialog) {

        val start = binding.etStart.text.toString()
        val end = binding.etEnd.text.toString()

        if (start.isEmpty()){
            Toast.makeText(requireContext(),"Enter Starting Price",Toast.LENGTH_LONG).show()
        }else if (end.isEmpty()){
            Toast.makeText(requireContext(),"Enter Ending Price",Toast.LENGTH_LONG).show()
        }else {
            val mStart = start.toInt()
            val mEnd = end.toInt()

            val newArray = ArrayList<ProductModel>()

            val oldArray = getList()

            for(index in oldArray){
                if (index.price in mStart..mEnd){
                    newArray.add(index)
                }
            }

            packageAdapter.setData(newArray)
            dialog.dismiss()

        }

    }

    private fun getList() : ArrayList<ProductModel>{

        val model1 = ProductModel("Iphone",120000)
        val model2 = ProductModel("Samsung",70000)
        val model3 = ProductModel("Nokia",60000)
        val model4 = ProductModel("Redmi",50000)
        val model5 = ProductModel("Vivo",40000)
        val model6 = ProductModel("Vigo",35000)
        val model7 = ProductModel("iball",30000)
        val model8 = ProductModel("Dell",25000)
        val model9 = ProductModel("Acer",20000)
        val model10 = ProductModel("Hp",18000)
        val model11 = ProductModel("Lenovo",15000)
        val model12 = ProductModel("HCL",12000)

        val mArray = ArrayList<ProductModel>()
        mArray.add(model1)
        mArray.add(model2)
        mArray.add(model3)
        mArray.add(model4)
        mArray.add(model5)
        mArray.add(model6)
        mArray.add(model7)
        mArray.add(model8)
        mArray.add(model9)
        mArray.add(model10)
        mArray.add(model11)
        mArray.add(model12)

        return  mArray
    }

}