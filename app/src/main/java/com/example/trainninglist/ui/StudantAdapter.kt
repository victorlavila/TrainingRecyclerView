package com.example.trainninglist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trainninglist.R
import com.example.trainninglist.model.PositionStudant
import com.example.trainninglist.model.Studant

class StudantAdapter (
    private val studantsList: MutableList<Studant>,
    val studantSelected: PositionStudant
    ): RecyclerView.Adapter<StudantAdapter.StudantViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_activity,
            parent,
            false)
        return StudantViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudantViewHolder, position: Int) {
        val name = holder.studant
        name.text = studantsList[position].name

        val studantnumber = holder.numberStudant
        studantnumber.text = studantsList[position].number

        holder.itemView.setOnClickListener {
            studantSelected.retrieveStudantPosition(studantsList[position], position)
        }
    }

    fun addStudant(){
        studantsList.add(Studant(" Aluno ${studantsList.size}", "Matrícula ${studantsList.size}"))
        notifyDataSetChanged()
    }

    override fun getItemCount() = studantsList.size

    inner class StudantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val studant by lazy { itemView.findViewById<TextView>(R.id.studantName) }
        val numberStudant by lazy { itemView.findViewById<TextView>(R.id.studantNumber) }
    }
}