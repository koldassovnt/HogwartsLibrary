package com.example.hogwartslibrary.ui.scenes.students

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hogwartslibrary.R
import com.example.hogwartslibrary.ui.scenes.students.adapters.StudentsAdapter
import kotlinx.android.synthetic.main.fragment_students.*

@Suppress("DEPRECATION")
class StudentsFragment : Fragment() {

    private lateinit var studentsViewModel: StudentsViewModel
    private val mAdapter = StudentsAdapter()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        studentsViewModel =
                ViewModelProviders.of(this).get(StudentsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_students, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
        setupLoading()

        context?.let {
            recyclerStudents.adapter = mAdapter
            recyclerStudents.layoutManager = LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
        }

        textStudentsSearch.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mAdapter.filter(query = s.toString())
            }

        })

        studentsViewModel.fetchStudents()
    }

    private fun setupLoading() {
        studentsViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            txtStudentsLoading.visibility = if (it)
                View.VISIBLE
            else
                View.GONE

            recyclerStudents.visibility = if (it)
                View.GONE
            else
                View.VISIBLE

            textStudentsSearch.visibility = if (it)
                View.GONE
            else
                View.VISIBLE
        })
    }

   private fun setupData() {
       studentsViewModel.students.observe(viewLifecycleOwner, Observer {
           if (it.isNotEmpty())
               mAdapter.setData(newData = it)
       })
   }
}
