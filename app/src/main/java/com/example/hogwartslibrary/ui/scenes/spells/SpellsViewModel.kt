package com.example.hogwartslibrary.ui.scenes.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hogwartslibrary.domain.repositories.SpellRepositoryImpl
import com.example.hogwartslibrary.ui.scenes.spells.adapters.SpellsCellModel
import com.example.hogwartslibrary.ui.scenes.spells.adapters.mapToUI
import com.example.hogwartslibrary.ui.scenes.students.adapters.mapToUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.nio.channels.Selector

class SpellsViewModel : ViewModel() {

    private val spellsRepository = SpellRepositoryImpl()

    private val _spells = MutableLiveData<MutableList<SpellsCellModel>>().apply {
        value = mutableListOf()
    }
    private val _filters = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }
    private val _spellsDisplay = MutableLiveData<MutableList<SpellsCellModel>>().apply {
        value = ArrayList()
    }

    val spellsDisplay: LiveData<MutableList<SpellsCellModel>> = _spellsDisplay

    init {
        fetchSpells()
    }

    private fun fetchSpells() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val spells = spellsRepository.getAllSpells()
                _spells.postValue(spells.map { it.mapToUI()}.toMutableList())
                _spellsDisplay.postValue(_spells.value ?: ArrayList())
            }
        }
    }


    fun pressFilter(type: String, isSelected: Boolean) {
        if (isSelected)
            _filters.value?.add(type)
        else
            _filters.value?.remove(type)

        if (_filters.value?.isEmpty() == true) {
            _spellsDisplay.postValue(_spells.value ?: ArrayList())
            return
        }

        _spellsDisplay.postValue(_spells.value?.filter { _filters.value?.contains(it.type) ?: false }?.toMutableList())
    }
}