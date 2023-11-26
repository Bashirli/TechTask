package com.bashirli.techtask.presentation.ui.home

import android.graphics.Color
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.bashirli.techtask.R
import com.bashirli.techtask.common.base.BaseFragment
import com.bashirli.techtask.common.utils.gone
import com.bashirli.techtask.common.utils.invisible
import com.bashirli.techtask.common.utils.visible
import com.bashirli.techtask.databinding.BottomFragmentStatementBinding
import com.bashirli.techtask.databinding.FragmentHomeBinding
import com.bashirli.techtask.domain.model.CardCategoryUiModel
import com.bashirli.techtask.presentation.ui.home.adapters.CardAdapter
import com.bashirli.techtask.presentation.ui.home.adapters.CategoryAdapter
import com.bashirli.techtask.presentation.ui.home.adapters.DetailsAdapter
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModels()

    private var _bsdState = true


    private val yearItems = listOf("2021", "2022", "2023")
    private val monthItems by lazy {
        listOf(
            resources.getString(R.string.July),
            resources.getString(R.string.August),
            resources.getString(R.string.September)
        )
    }

    private val cardAdapter = CardAdapter()
    private val categoryAdapter = CategoryAdapter()
    private val detailsAdapter = DetailsAdapter()
    private var _cardCategoryUiModel: CardCategoryUiModel? = null

    override fun observeEvents() {
        with(binding) {
            with(viewModel) {
                liveData.observe(viewLifecycleOwner) {
                    when (it) {

                        is HomeUiState.CategoryDetails -> {
                            detailsAdapter.submitData(it.data.statements)
                        }

                        is HomeUiState.CardDetails -> {
                            cardResponseUiModel = it.data
                            _cardCategoryUiModel = it.data.categories?.firstOrNull()
                            cardCategoryUiModel = it.data.categories?.firstOrNull()
                            categoryAdapter.submitData(it.data.categories)
                            setChart(it.data.categories ?: emptyList())
                        }

                        is HomeUiState.Cards -> {
                            val item = it.data.first { item -> item.isSelected ?: true }
                            cardUiModel = item
                            cardAdapter.submitData(it.data)
                            viewModel.getStatistics(
                                actvYear.text.toString(), actvMonth.text.toString()
                            )
                            viewModel.getCardDetails(item.id ?: 1)
                        }

                        else -> Unit
                    }
                }
                effect.observe(viewLifecycleOwner) {
                    when (it) {
                        is HomeUiEffect.ShowMessage -> Toast.makeText(
                            requireContext(), it.message, Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

    override fun onViewCreateFinish() {
        setup()
    }

    private fun setup() {
        setDropDownMenu()
        setRV()
        with(binding) {

            cardSelectedCard.setOnClickListener {
                if (rvCard.isVisible) {
                    rvCard.gone()
                } else {
                    rvCard.visible()
                }
            }



            buttonViewStatement.setOnClickListener {
                _cardCategoryUiModel?.id?.let { id ->
                    if(_bsdState){
                        val date = actvMonth.text.toString() + " " + actvYear.text.toString()
                        createBs(date, id)
                        _bsdState = false
                    }
                }
            }


        }
    }

    private fun setDropDownMenu() {
        with(binding) {
            val yearAdapter = ArrayAdapter(requireContext(), R.layout.item_drop_down, yearItems)
            val monthAdapter = ArrayAdapter(requireContext(), R.layout.item_drop_down, monthItems)

            actvYear.setText(yearItems.lastOrNull())
            actvMonth.setText(monthItems.lastOrNull())


            actvYear.setAdapter(yearAdapter)
            actvMonth.setAdapter(monthAdapter)

            actvYear.setOnItemClickListener { adapterView, view, i, l ->
                yearAdapter.getItem(i)?.let {
                    viewModel.getStatistics(actvYear.text.toString(), actvMonth.text.toString())
                }
            }
            actvMonth.setOnItemClickListener { adapterView, view, i, l ->
                monthAdapter.getItem(i)?.let {
                    viewModel.getStatistics(actvYear.text.toString(), actvMonth.text.toString())
                }
            }

        }
    }

    private fun setRV() {
        with(binding) {
            rvCard.adapter = cardAdapter
            rvCategories.adapter = categoryAdapter
            rvCard.itemAnimator = null

            cardAdapter.onClickCardListener = {
                if (it.isSelected == false) {
                    it.id?.let { id ->

                        val newList = cardAdapter.items.map { item ->
                            item.copy(isSelected = id == item.id)
                        }
                        cardAdapter.submitData(newList)
                        cardUiModel = it
                        viewModel.getCardDetails(id)
                        rvCard.gone()
                    }
                }
            }

            categoryAdapter.onClickCardListener = {
                cardCategoryUiModel = it
                _cardCategoryUiModel = it
                nestedScroll.smoothScrollTo(nestedScroll.scrollX, pieChart.top, 1100)
            }

        }


    }

    private fun setChart(data: List<CardCategoryUiModel>) {
        with(binding) {
            if (data.isEmpty()) {
                pieChart.invisible()
            } else {
                pieChart.visible()
            }

            val chartList = arrayListOf<PieEntry>()
            val colorList = arrayListOf<Int>()


            data.forEach { item ->
                chartList.add(
                    PieEntry(
                        item.price?.toFloat() ?: 0f
                    )
                )
                colorList.add(
                    Color.parseColor(item.color)
                )
            }

            val pieDataSet = PieDataSet(chartList, "")

            pieChart.setExtraOffsets(2f, 0f, 2f, 0f)
            pieChart.animateY(1400, Easing.EaseInOutQuad)
            pieChart.holeRadius = 88f
            pieChart.setUsePercentValues(true)
            pieChart.data = PieData(pieDataSet)
            pieChart.legend.isEnabled = false
            pieChart.description.isEnabled = false

            pieDataSet.selectionShift = 8f
            pieDataSet.sliceSpace = 5f
            pieDataSet.colors = colorList


            pieChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
                override fun onValueSelected(e: Entry?, h: Highlight?) {
                    e?.let {
                        h?.let {
                            // h -> index , e->value
                            val newData = data.getOrNull(h.x.toInt())
                            cardCategoryUiModel = newData
                            _cardCategoryUiModel = newData
                        }
                    }
                }

                override fun onNothingSelected() {

                }
            })

        }
    }

    private fun createBs(date: String, id: Int) {
        val layout = BottomFragmentStatementBinding.inflate(layoutInflater)
        val bsd = BottomSheetDialog(requireContext())
        bsd.setContentView(layout.root)
        viewModel.getDetails(id)

        layout.rvDetails.adapter = detailsAdapter
        layout.cardCategoryUiModel = _cardCategoryUiModel
        layout.date = date

        bsd.show()

        bsd.setOnDismissListener {
            _bsdState = true
        }

    }

}