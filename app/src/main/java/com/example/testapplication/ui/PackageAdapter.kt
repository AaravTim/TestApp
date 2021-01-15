package com.example.testapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R
import com.example.testapplication.databinding.ListItemLayoutBinding
import com.example.testapplication.ui.product.ProductModel

class PackageAdapter(
    private var mContext: Context
) : RecyclerView.Adapter<PackageAdapter.ViewHolder>() , Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
       val binding = ListItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    private val mFilter = ItemFilter()
    var result: ArrayList<ProductModel>? = null
    var filterResult: ArrayList<ProductModel>? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (result != null){
            val model = result!![position]
            holder.binding.tvName.text = model.name
            holder.binding.tvPrice.text = "${model.price}"
        }
    }


    override fun getItemCount(): Int {
         return  if (result.isNullOrEmpty()) 0 else result!!.size
    }

    fun setData(result: ArrayList<ProductModel>) {
        this.result = result
        this.filterResult = result
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    private inner class ItemFilter : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val results = FilterResults()
            if (constraint == null || constraint.isEmpty()) {
                results.values = filterResult
                results.count = filterResult!!.size
            } else {
                val filterString = constraint.toString().toLowerCase()
                val list = filterResult

                val count = list!!.size
                val nlist = ArrayList<ProductModel>(count)
                var filterableString: String
                for (i in 0 until count) {
                    filterableString = list[i].name
                    if (filterableString.toLowerCase().contains(filterString)) {
                        nlist.add(list[i])
                    }
                }
                results.values = nlist
                results.count = nlist.size
            }
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            if (results.values != null) {
                result = results.values as ArrayList<ProductModel>
            }
            notifyDataSetChanged()
        }
    }

    override fun getFilter(): Filter {
        return mFilter
    }
}