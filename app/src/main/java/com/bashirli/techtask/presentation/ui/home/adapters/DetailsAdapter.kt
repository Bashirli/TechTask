package com.bashirli.techtask.presentation.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bashirli.techtask.common.base.BaseAdapter
import com.bashirli.techtask.databinding.ItemDetailsBinding
import com.bashirli.techtask.domain.model.StatementsUiModel

class DetailsAdapter : BaseAdapter<StatementsUiModel>() {

    inner class DetailsVH(private val binding: ItemDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StatementsUiModel) {
            with(binding) {
                statementsUiModel = item
                executePendingBindings()

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int,
    ): RecyclerView.ViewHolder = DetailsVH(ItemDetailsBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailsVH -> {
                items.getOrNull(position)?.let { item ->
                    holder.bind(item)
                }
            }
        }
    }
}