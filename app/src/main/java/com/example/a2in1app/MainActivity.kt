package com.example.a2in1app

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var nbutton: Button
    lateinit var gbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nbutton = findViewById(R.id.nbutton)
        gbutton = findViewById(R.id.gbutton)
        val textview = findViewById<TextView>(R.id.tvguess)

        nbutton.setOnClickListener {
            val intent = Intent(this, MyActivity1::class.java)
            startActivity(intent)
        }
        gbutton.setOnClickListener {
            val intent = Intent(this, MyActivity2::class.java)
            startActivity(intent)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.game1 -> {
                val intent = Intent(this, MyActivity1::class.java)
                startActivity(intent)
                return true
            }
            R.id.game2 -> {
                val intent = Intent(this, MyActivity2::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}