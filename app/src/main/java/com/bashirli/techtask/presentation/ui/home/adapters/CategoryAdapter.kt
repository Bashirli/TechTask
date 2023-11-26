package com.bashirli.techtask.presentation.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bashirli.techtask.common.base.BaseAdapter
import com.bashirli.techtask.databinding.ItemCategoryBinding
import com.bashirli.techtask.domain.model.CardCategoryUiModel

class CategoryAdapter : BaseAdapter<CardCategoryUiModel>() {

    var onClickCardListener: (CardCategoryUiModel) -> Unit = {}

    inner class CategoryVH(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CardCategoryUiModel) {
            with(binding) {
                cardCategoryUiModel = item
                executePendingBindings()

                cardCategory.setOnClickListener {
                    onClickCardListener(item)
                }

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int,
    ): RecyclerView.ViewHolder = CategoryVH(ItemCategoryBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryVH -> {
                items.getOrNull(position)?.let { item ->
                    holder.bind(item)
                }
            }
        }
    }
}