@file:Suppress("DEPRECATION")

package com.example.hogwartslibrary.ui.scenes.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hogwartslibrary.R
import com.example.hogwartslibrary.ui.scenes.spells.adapters.SpellsAdapter
import kotlinx.android.synthetic.main.fragment_spells.*

@Suppress("DEPRECATION")
class SpellsFragment : Fragment() {

    private lateinit var spellsViewModel: SpellsViewModel
    private val mAdapter = SpellsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        spellsViewModel =
            ViewModelProviders.of(this).get(SpellsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_spells, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecycler()
        configureDataDisplay()

        btnSpellsCharm.setOnClickListener {
            btnSpellsCharm.isSelected = !btnSpellsCharm.isSelected
            spellsViewModel.pressFilter(type = "Charm", isSelected = btnSpellsCharm.isSelected)
        }

        btnSpellsSpell.setOnClickListener {
            btnSpellsSpell.isSelected = !btnSpellsSpell.isSelected
            spellsViewModel.pressFilter(type = "Spell", isSelected = btnSpellsSpell.isSelected)
        }

        btnSpellsCurse.setOnClickListener {
            btnSpellsCurse.isSelected = !btnSpellsCurse.isSelected
            spellsViewModel.pressFilter(type = "Curse", isSelected = btnSpellsCurse.isSelected)
        }

        btnSpellsJinx.setOnClickListener {
            btnSpellsJinx.isSelected = !btnSpellsJinx.isSelected
            spellsViewModel.pressFilter(type = "Jinx", isSelected = btnSpellsJinx.isSelected)
        }
    }

    private fun configureRecycler() {
        recyclerSpells.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerSpells.adapter = mAdapter
    }

    private fun configureDataDisplay() {
        spellsViewModel.spellsDisplay.observe(viewLifecycleOwner, Observer {data ->
            mAdapter.setData(newData = data)
        })
    }
}
