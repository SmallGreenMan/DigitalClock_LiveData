package com.gmail.avoishel.digitalckock_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DigitsDisplayManager {

    private val _digitDisplayLiveData = MutableLiveData<Map<Int, Int>>()
    val digitDisplayLiveData: LiveData<Map<Int, Int>> = _digitDisplayLiveData

    private val segmentIdList = listOf(
        R.id.segmentTop,
        R.id.segmentTopLeft,
        R.id.segmentTopRight,
        R.id.segmentMiddle,
        R.id.segmentBottomLeft,
        R.id.segmentBottomRight,
        R.id.segmentBottom,
    )

        private val digitalMap = mapOf(
        R.id.segmentTop         to listOf(0, 2, 3, 5, 6, 7, 8, 9),
        R.id.segmentTopLeft     to listOf(0, 4, 5, 6,  8, 9),
        R.id.segmentTopRight    to listOf(0, 1, 2, 3, 4, 7, 8, 9),
        R.id.segmentMiddle      to listOf(2, 3, 4, 5, 6, 8, 9),
        R.id.segmentBottomLeft  to listOf(0, 2, 6, 8),
        R.id.segmentBottomRight to listOf(0, 1, 3, 4, 5, 6, 7, 8, 9),
        R.id.segmentBottom      to listOf(0, 2, 3, 5, 6, 8),
    )

    fun onNewDigit(digit: Int) {
        val state = HashMap<Int, Int>()
        segmentIdList.forEach { id ->
            val colorRes = if (digitalMap[id]!!.contains(digit)) {
                R.color.selected
            } else {
                R.color.unselected
            }

            state[id] = colorRes
        }
        _digitDisplayLiveData.postValue(state)
    }

    //region LiveData
//    private val _segmentTopLiveData = MutableLiveData(R.color.unselected)
//    val segmentTopLiveData: LiveData<Int> = _segmentTopLiveData
//
//    private val _segmentTopLeftLiveData = MutableLiveData(R.color.unselected)
//    val segmentTopLeftLiveData: LiveData<Int> = _segmentTopLeftLiveData
//
//    private val _segmentTopRightLiveData = MutableLiveData(R.color.unselected)
//    val segmentTopRightLiveData: LiveData<Int> = _segmentTopRightLiveData
//
//    private val _segmentMiddleLiveData = MutableLiveData(R.color.unselected)
//    val segmentMiddleLiveData: LiveData<Int> = _segmentMiddleLiveData
//
//    private val _segmentBottomLeftLiveData = MutableLiveData(R.color.unselected)
//    val segmentBottomLeftLiveData: LiveData<Int> = _segmentBottomLeftLiveData
//
//    private val _segmentBottomRightLiveData = MutableLiveData(R.color.unselected)
//    val segmentBottomRightLiveData: LiveData<Int> = _segmentBottomRightLiveData
//
//    private val _segmentBottomLiveData = MutableLiveData(R.color.unselected)
//    val segmentBottomLiveData: LiveData<Int> = _segmentBottomLiveData
//    //endregion LiveData
//
//    private val liveDateList = listOf(
//        _segmentTopLiveData,
//        _segmentTopLeftLiveData,
//        _segmentTopRightLiveData,
//        _segmentMiddleLiveData,
//        _segmentBottomLeftLiveData,
//        _segmentBottomRightLiveData,
//        _segmentBottomLiveData
//    )
//
//    private val digitalMap = mapOf(
//        _segmentTopLiveData         to listOf(0, 2, 3, 5, 6, 7, 8, 9),
//        _segmentTopLeftLiveData     to listOf(0, 4, 5, 6,  8, 9),
//        _segmentTopRightLiveData    to listOf(0, 1, 2, 3, 4, 7, 8, 9),
//        _segmentMiddleLiveData      to listOf(2, 3, 4, 5, 6, 8, 9),
//        _segmentBottomLeftLiveData  to listOf(0, 2, 6, 8),
//        _segmentBottomRightLiveData to listOf(0, 1, 3, 4, 5, 6, 7, 8, 9),
//        _segmentBottomLiveData      to listOf(0, 2, 3, 5, 6, 8),
//    )
//
//    fun startCounting() {
//        viewModelScope.launch {
//            repeat(10){
//                onNewDigit(it)
//                delay(1_000)
//            }
//        }
//    }
//
//    fun onNewDigit(digit: Int) {
//        liveDateList.forEach { segmentLiveDate ->
//            val colorRes = if (digitalMap[segmentLiveDate]!!.contains(digit)) {
//                R.color.selected
//            } else {
//                R.color.unselected
//            }
//
//            segmentLiveDate.postValue(colorRes)
//        }
//    }
}