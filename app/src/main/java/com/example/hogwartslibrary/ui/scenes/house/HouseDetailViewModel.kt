package com.example.hogwartslibrary.ui.scenes.house

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hogwartslibrary.R
import kotlinx.android.synthetic.main.fragment_houses.view.*

class HouseDetailViewModel : ViewModel() {

    private val _ghost: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    private val _founder: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    private val _leader: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    private val _houseName: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }
    private val _houseImage: MutableLiveData<Int> = MutableLiveData<Int>().apply { value = R.drawable.img_gryffindor }

    val ghost: LiveData<String> = _ghost
    val founder: LiveData<String> =_founder
    val leader: LiveData<String> = _leader
    val houseName: LiveData<String> = _houseName
    val houseImage: LiveData<Int> = _houseImage

    fun fetchData(house: Houses?) {
        when (house) {
            Houses.Gryffindor -> {
                _ghost.postValue("Nick")
                _founder.postValue("Godrik Gryffindor")
                _leader.postValue("McGonagal")
                _houseName.postValue("Gryffindor")
                _houseImage.postValue(R.drawable.img_gryffindor)
            }
            else -> {
                _ghost.postValue("Alex")
                _founder.postValue("Mary Hufflepuff")
                _leader.postValue("Garden Woman")
                _houseName.postValue("Hufflepuff")
                _houseImage.postValue(R.drawable.img_hufflepuff)
            }
        }
    }
}
