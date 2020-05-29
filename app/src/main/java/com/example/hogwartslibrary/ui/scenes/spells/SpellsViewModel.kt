package com.example.hogwartslibrary.ui.scenes.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hogwartslibrary.ui.scenes.spells.adapters.SpellsCellModel
import java.nio.channels.Selector

class SpellsViewModel : ViewModel() {

    private val _spells = MutableLiveData<MutableList<SpellsCellModel>>().apply {
        value = mutableListOf(
            SpellsCellModel(name = "Diffindo", type = "Charm"),
            SpellsCellModel(name = "Vingardio Leviosa", type = "Spell"),
            SpellsCellModel(name = "Avada Kedavra", type = "Curse"),
            SpellsCellModel(name = "Oblivious", type = "Jinx"),
            SpellsCellModel(name = "Diffindo", type = "Charm"),
            SpellsCellModel(name = "Vingardio Leviosa", type = "Spell"),
            SpellsCellModel(name = "Avada Kedavra", type = "Curse"),
            SpellsCellModel(name = "Oblivious", type = "Jinx")

        )
    }
    private val _filters = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }
    private val _spellsDisplay = MutableLiveData<MutableList<SpellsCellModel>>().apply {
        value = ArrayList()
    }

    val spellsDisplay: LiveData<MutableList<SpellsCellModel>> = _spellsDisplay

    init {
        _spellsDisplay.postValue(_spells.value ?: ArrayList())
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