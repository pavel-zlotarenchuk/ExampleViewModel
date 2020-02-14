package com.mdgroup.exampleviewmodel.ui.main


import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mdgroup.exampleviewmodel.R
import com.mdgroup.exampleviewmodel.ui.base.BaseFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        message.setOnClickListener {
            viewModel.onClick()
        }
    }

    override fun viewBinding() {
        viewModel.text.observe(this, Observer { text ->
            message.text = text
        })
    }
}
