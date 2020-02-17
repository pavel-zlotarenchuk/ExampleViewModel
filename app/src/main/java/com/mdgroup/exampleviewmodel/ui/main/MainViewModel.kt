package com.mdgroup.exampleviewmodel.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var text = MutableLiveData<String>()

    fun onClick() {
        text.postValue("This from ViewModel")
    }
}