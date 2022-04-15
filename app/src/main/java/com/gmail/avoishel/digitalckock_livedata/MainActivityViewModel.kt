package com.gmail.avoishel.digitalckock_livedata

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel: ViewModel() {

    private val _segmentStateLiveData = MutableLiveData(R.color.unselected)
    val segmentStateLiveData: LiveData<Int> = _segmentStateLiveData

    fun onButtonClicked() {
        val curentColor = _segmentStateLiveData
        _segmentStateLiveData.postValue(info)
        //_segmentStateLiveData.value = randomText
    }
}