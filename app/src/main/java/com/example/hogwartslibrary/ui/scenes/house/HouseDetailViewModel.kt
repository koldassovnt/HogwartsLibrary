package com.example.hogwartslibrary.ui.scenes.house

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hogwartslibrary.R
import com.example.hogwartslibrary.domain.repositories.HouseRepositoryImpl
import com.example.hogwartslibrary.domain.repositories.StudentsRepositoryImpl
import com.example.hogwartslibrary.ui.scenes.students.adapters.mapToUI
import kotlinx.android.synthetic.main.fragment_houses.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HouseDetailViewModel : ViewModel() {

    private val houseRepository = HouseRepositoryImpl()

    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }
    val isLoading: LiveData<Boolean> = _isLoading


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

        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _isLoading.postValue(true)
                house?.let {
                    val houseDetail = houseRepository.getHouseDetails(house = house)
                    _isLoading.postValue(false)
                    _ghost.postValue(houseDetail?.ghost.orEmpty())
                    _founder.postValue(houseDetail?.founder.orEmpty())
                    _leader.postValue(houseDetail?.leader.orEmpty())
                    _houseName.postValue(houseDetail?.name.orEmpty())

                    when (house) {
                        Houses.Gryffindor -> _houseImage.postValue(R.drawable.img_gryffindor)
                        Houses.Hufflepuff -> _houseImage.postValue(R.drawable.img_hufflepuff)
                        Houses.Ravenclaw -> _houseImage.postValue(R.drawable.img_ravenclaw)
                        Houses.Slytherin -> _houseImage.postValue(R.drawable.img_slytherin)
                    }
                }
            }
        }
    }
}
