package com.example.hogwartslibrary.ui.scenes.spells.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hogwartslibrary.R

class SpellsAdapter : RecyclerView.Adapter<SpellsAdapter.SpellsViewHolder>() {

    private val mDataList = ArrayList<SpellsCellModel>()

    fun setData(newData: List<SpellsCellModel>) {
        mDataList.clear()
        mDataList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SpellsViewHolder(itemView = inflater.inflate(R.layout.cell_spell, parent, false))
    }

    override fun getItemCount(): Int = mDataList.count()

    override fun onBindViewHolder(holder: SpellsViewHolder, position: Int) {
        holder.bind(cellModel = mDataList[position])
    }

    class SpellsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtName: TextView = itemView.findViewById(R.id.txtSpellName)
        private val txtType: TextView = itemView.findViewById(R.id.txtSpellType)

        fun bind(cellModel: SpellsCellModel) {
            txtName.text = cellModel.name
            txtType.text = cellModel.type
        }
    }
}