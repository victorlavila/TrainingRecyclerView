package com.example.trainninglist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trainninglist.R
import com.example.trainninglist.model.PositionStudant
import com.example.trainninglist.model.Studant

class MainActivity : AppCompatActivity() {

    private val recycler by lazy { findViewById<RecyclerView>(R.id.studantsList) }
    private val button by lazy { findViewById<Button>(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)

        val studant = getSudant()

        val adapter = StudantAdapter(studant, object : PositionStudant{
            override fun retrieveStudantPosition(studant: Studant, position: Int) {
                Toast.makeText(this@MainActivity, "$studant, position = $position",
                    Toast.LENGTH_LONG).show()
            }
        })

        recycler.adapter = adapter

        button.setOnClickListener {
            adapter.addStudant()
        }

    }

    fun getSudant(): MutableList<Studant>{
        val studantInclused = mutableListOf<Studant>()

        for(i in 0..30){
            val studant = Studant("Aluno $i", "Matrícula $i")
            studantInclused.add(studant)
        }
        return studantInclused
    }
}