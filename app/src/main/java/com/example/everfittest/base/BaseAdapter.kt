package com.example.everfittest.base


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<V : ViewBinding, DATA> :
    RecyclerView.Adapter<BaseAdapter<V, DATA>.BaseVH>() {
    protected val items = mutableListOf<DATA>()

    fun getItemsData(): List<DATA> {
        return items
    }

    fun setItems(items: List<DATA>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    open fun addItems(items: List<DATA>) {
        val prevSize = this.items.size
        this.items.addAll(items)
        notifyItemRangeInserted(prevSize, items.size)
    }

    open fun addItem(fieldModel: DATA) {
        this.items.add(fieldModel)
        val index = items.indexOf(fieldModel)
        notifyItemInserted(index)
    }

    fun removeItem(fieldModel: DATA) {
        val index = items.indexOf(fieldModel)
        items.removeAt(index)
        notifyItemRemoved(index)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {
        return BaseVH(getLayoutBinding(parent, viewType))
    }

    abstract fun getLayoutBinding(parent: ViewGroup, viewType: Int): V

    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        val binding = holder.getBinding()
        bind(binding, getItem(position), position)
    }

    protected fun getItem(position: Int): DATA {
        return items[position]
    }

    protected abstract fun bind(binding: V, item: DATA, position: Int)

    override fun getItemCount(): Int {
        return items.size
    }

    inner class BaseVH(private val binding: V) : RecyclerView.ViewHolder(binding.root) {
        fun getBinding(): V {
            return binding
        }
    }
}