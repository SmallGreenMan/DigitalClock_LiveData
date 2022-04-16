package com.gmail.avoishel.digitalckock_livedata

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainActivityViewModel: ViewModel() {

    val secondRightDisplayManager = DigitsDisplayManager()
    val secondLeftDisplayManager = DigitsDisplayManager()

    fun startCounting(){
        viewModelScope.launch {
            var index = 0
            while (true) {
                secondRightDisplayManager.onNewDigit(index % 10)
                secondLeftDisplayManager.onNewDigit((index / 10) % 10)
                index++
                delay(1_00)
            }
        }
    }

}