package com.mdgroup.exampleviewmodel.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment(@LayoutRes private val contentLayoutId: Int = 0) :
    Fragment(contentLayoutId) {

    protected abstract fun initViewModel()

    protected abstract fun initView(view: View, savedInstanceState: Bundle?)

    protected abstract fun viewBinding()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
        viewBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        if (contentLayoutId != 0) inflater.inflate(contentLayoutId, container, false)
        else null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view, savedInstanceState)
    }

    protected fun navigateTo(@IdRes resId: Int, args: Bundle? = null) {
        findNavController().navigate(resId, args)
    }
}