package com.mdgroup.exampleviewmodel.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var text = MutableLiveData<String>()

    fun onClick(){
        text.value = "This from ViewModel"
    }
}