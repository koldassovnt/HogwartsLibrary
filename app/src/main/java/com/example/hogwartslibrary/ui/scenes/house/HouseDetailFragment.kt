package com.example.hogwartslibrary.ui.scenes.house

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

import com.example.hogwartslibrary.R
import com.example.hogwartslibrary.helpers.Keys
import kotlinx.android.synthetic.main.fragment_houses.*
import kotlinx.android.synthetic.main.fragment_students.*
import kotlinx.android.synthetic.main.house_detail_fragment.*
import java.security.Key

@Suppress("DEPRECATION")
class HouseDetailFragment : Fragment() {

    companion object {
        fun newInstance() = HouseDetailFragment()
    }

    private lateinit var viewModel: HouseDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.house_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HouseDetailViewModel::class.java)
        setupLoading()
        configureLayout()

        viewModel.fetchData(house = arguments?.get(Keys.Faculty.value) as Houses)
    }

    private fun configureLayout() {
        viewModel.founder.observe(viewLifecycleOwner, Observer {
            txtHouseOwner.text = getString(R.string.house_detail_owner).replace("[FOUNDER_NAME]", it)
        })

        viewModel.ghost.observe(viewLifecycleOwner, Observer {
            txtHouseGhost.text = getString(R.string.house_detail_ghost).replace("[GHOST_NAME]", it)
        })

        viewModel.leader.observe(viewLifecycleOwner, Observer {
            txtHouseLeader.text = getString(R.string.house_detail_leader).replace("[LEADER_NAME]", it)
        })

        viewModel.houseName.observe(viewLifecycleOwner, Observer {
            txtHouseName.text = it
        })

        viewModel.houseImage.observe(viewLifecycleOwner, Observer {
            imgHouseDetail.setImageResource(it)
        })
    }

    private fun setupLoading() {
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            txtHouseDetailLoading.visibility = if (it)
                View.VISIBLE
            else
                View.GONE

            llHouseDetail.visibility = if (it)
                View.GONE
            else
                View.VISIBLE
        })
    }
}
