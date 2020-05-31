package com.example.hogwartslibrary.ui.scenes.students.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartslibrary.R

class StudentsAdapter : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

    private val mDataList = ArrayList<StudentCellModel>()
    private val mDisplayList = ArrayList<StudentCellModel>()

    fun setData(newData: List<StudentCellModel>) {
        mDataList.clear()
        mDataList.addAll(newData)
        filter(query = "")
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        mDisplayList.clear()

        if (query.isEmpty()) {
            mDisplayList.addAll(mDataList)
            return
        }
        mDisplayList.addAll(mDataList.filter {
            it.name.contains(query, true) ||
                    it.facultyName.contains(query, true)
        })
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StudentViewHolder(itemView = inflater.inflate(R.layout.cell_student, parent, false))
    }

    override fun getItemCount(): Int = mDisplayList.count()

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(cellModel = mDisplayList[position])
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtName: TextView = itemView.findViewById(R.id.txtStudentName)
        private val txtFaculty: TextView = itemView.findViewById(R.id.txtStudentFaculty)
        private val txtSpecie: TextView = itemView.findViewById(R.id.txtStudentSpecies)

        fun bind(cellModel: StudentCellModel) {
            txtName.text = cellModel.name
            txtFaculty.text = cellModel.facultyName
            txtSpecie.text = cellModel.species
        }
    }
}