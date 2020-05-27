package com.example.hogwartslibrary.ui.scenes.houses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.hogwartslibrary.R
import com.example.hogwartslibrary.helpers.Keys
import com.example.hogwartslibrary.ui.scenes.house.Houses
import kotlinx.android.synthetic.main.fragment_houses.*

@Suppress("DEPRECATION")
class HousesFragment : Fragment() {

    private lateinit var housesViewModel: HousesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        housesViewModel =
                ViewModelProviders.of(this).get(HousesViewModel::class.java)
        return inflater.inflate(R.layout.fragment_houses, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        imgGryffindor.setOnClickListener { showDetail(sender = it) }
        imgHufflepuff.setOnClickListener { showDetail(sender = it) }
        imgRavenclaw.setOnClickListener { showDetail(sender = it) }
        imgSlytherin.setOnClickListener { showDetail(sender = it) }
    }

    private fun showDetail(sender: View) {
        val house = when (sender.tag) {
            "0" -> Houses.Gryffindor
            "1" -> Houses.Hufflepuff
            "2" -> Houses.Ravenclaw
            else -> Houses.Slytherin
        }

        sender.findNavController().navigate(R.id.action_navigation_dashboard_to_houseDetailFragment,
            Bundle().apply
         { this.putSerializable(Keys.Faculty.value, house) })
    }

}
