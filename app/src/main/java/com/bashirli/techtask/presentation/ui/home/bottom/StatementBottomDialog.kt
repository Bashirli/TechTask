package com.bashirli.techtask.presentation.ui.home.bottom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bashirli.techtask.R
import com.bashirli.techtask.databinding.BottomFragmentStatementBinding
import com.bashirli.techtask.presentation.ui.home.HomeUiState
import com.bashirli.techtask.presentation.ui.home.HomeViewModel
import com.bashirli.techtask.presentation.ui.home.adapters.DetailsAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatementBottomDialog : BottomSheetDialogFragment() {
    private val viewModel by viewModels<HomeViewModel>()

    private var _binding: BottomFragmentStatementBinding? = null
    val binding get() = _binding!!

    private val detailsAdapter = DetailsAdapter()
    private val args by navArgs<StatementBottomDialogArgs>()
    private val _id by lazy {
        args.id
    }
    private val _date by lazy { args.detailsDate }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = BottomFragmentStatementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setup()
    }

    private fun observeData() {
        with(binding) {
            with(viewModel) {
                liveData.observe(viewLifecycleOwner) {
                    when (it) {
                        is HomeUiState.CategoryDetails -> {
                            cardCategoryUiModel = it.data.details
                            detailsAdapter.submitData(it.data.statements)
                        }

                        else -> Unit
                    }
                }
            }
        }
    }


    private fun setup() {
        setRV()
        viewModel.getDetails(_id)
        with(binding) {
            date = _date
        }
    }

    private fun setRV() {
        with(binding) {
            rvDetails.adapter = detailsAdapter
        }
    }


    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}