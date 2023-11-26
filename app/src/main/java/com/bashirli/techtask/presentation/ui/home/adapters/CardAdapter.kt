package com.bashirli.techtask.presentation.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bashirli.techtask.common.base.BaseAdapter
import com.bashirli.techtask.databinding.ItemCardsBinding
import com.bashirli.techtask.domain.model.CardUiModel

class CardAdapter : BaseAdapter<CardUiModel>(selected = true) {

    var onClickCardListener: (CardUiModel) -> Unit = {}

    inner class CardVH(private val binding: ItemCardsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CardUiModel) {
            with(binding) {
                cardUiModel = item
                executePendingBindings()

                cardCard.setOnClickListener {
                    onClickCardListener(item)
                }

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int,
    ): RecyclerView.ViewHolder = CardVH(ItemCardsBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CardVH -> {
                items.getOrNull(position)?.let { item ->
                    holder.bind(item)
                }
            }
        }
    }
}