package com.aldin.android_studio_lab_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel<T>: ViewModel() {

    val data : MutableLiveData<T> = MutableLiveData()

    fun setData(values : T){
        data.value = values
    }

}