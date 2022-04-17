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

    val hourRightDisplayManager = DigitsDisplayManager()
    val hourLeftDisplayManager = DigitsDisplayManager()

    val secondRightDisplayManager = DigitsDisplayManager()
    val secondLeftDisplayManager = DigitsDisplayManager()

    fun startCounting(){
        viewModelScope.launch {
            var index = 0
            while (true) {
                val hours = index / 60
                val seconds = index % 60

                hourRightDisplayManager.onNewDigit(hours % 10)
                hourLeftDisplayManager.onNewDigit((hours / 10) % 10)

                secondRightDisplayManager.onNewDigit(seconds % 10)
                secondLeftDisplayManager.onNewDigit((seconds / 10) % 10)
                index++
                delay(1_00)
            }
        }
    }

}