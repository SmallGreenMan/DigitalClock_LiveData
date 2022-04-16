package com.gmail.avoishel.digitalckock_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.gmail.avoishel.digitalckock_livedata.databinding.ActivityMainBinding
import com.gmail.avoishel.digitalckock_livedata.databinding.LayoutDigitDisplayBinding
import com.google.android.material.card.MaterialCardView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.secondLeftDisplayManager.digitDisplayLiveData.observe(this){ map ->
            setuplayoutWithNewDigit(binding.layoutSecondLeft, map)
        }
        viewModel.secondRightDisplayManager.digitDisplayLiveData.observe(this){ map ->
            setuplayoutWithNewDigit(binding.layoutSecondRight, map)
        }

        viewModel.startCounting()
    }

    private fun setuplayoutWithNewDigit(binding: LayoutDigitDisplayBinding, map: Map<Int, Int>){
        styleCardView(binding.segmentTop.root, map[R.id.segmentTop]!!)
        styleCardView(binding.segmentTopLeft.root, map[R.id.segmentTopLeft]!!)
        styleCardView(binding.segmentTopRight.root, map[R.id.segmentTopRight]!!)
        styleCardView(binding.segmentMiddle.root, map[R.id.segmentMiddle]!!)
        styleCardView(binding.segmentBottomLeft.root, map[R.id.segmentBottomLeft]!!)
        styleCardView(binding.segmentBottomRight.root, map[R.id.segmentBottomRight]!!)
        styleCardView(binding.segmentBottom.root, map[R.id.segmentBottom]!!)
    }

    private fun styleCardView(materialCardView: MaterialCardView, @ColorRes colorRes: Int){
        materialCardView.apply {
            val resolvedColor = ContextCompat.getColor(context, colorRes)
            setCardBackgroundColor(resolvedColor)
        }
    }
//
//        bindLiveData(viewModel.segmentTopLiveData, binding.segmentTop.root)
//        bindLiveData(viewModel.segmentTopLeftLiveData, binding.segmentTopLeft.root)
//        bindLiveData(viewModel.segmentTopRightLiveData, binding.segmentTopRight.root)
//        bindLiveData(viewModel.segmentMiddleLiveData, binding.segmentMiddle.root)
//        bindLiveData(viewModel.segmentBottomLeftLiveData, binding.segmentBottomLeft.root)
//        bindLiveData(viewModel.segmentBottomRightLiveData, binding.segmentBottomRight.root)
//        bindLiveData(viewModel.segmentBottomLiveData, binding.segmentBottom.root)
//
//        viewModel.startCounting()
//    }
//
//    private fun bindLiveData(liveData: LiveData<Int>, materialCardView: MaterialCardView){
//        liveData.observe(this) { colorRes ->
//            materialCardView.apply {
//                val resolvedColor = ContextCompat.getColor(context, colorRes)
//                setCardBackgroundColor(resolvedColor)
//            }
//        }
//    }
}