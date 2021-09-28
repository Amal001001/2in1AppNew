package com.example.a2in1app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class MyActivity1 : AppCompatActivity() {
    lateinit var tvguess2: TextView
    lateinit var tvguess3: TextView
    lateinit var etguess: EditText
    lateinit var bguess: Button
    lateinit var myLayoutnum: ConstraintLayout
    var counter = 3
    val randomnum = Random.nextInt(11)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my1)
        myLayoutnum = findViewById(R.id.clMain1)
        var tvguess = findViewById<TextView>(R.id.tvguess)
        tvguess2 = findViewById(R.id.tvguess3)
        tvguess3 = findViewById(R.id.tvguess2)
        etguess = findViewById(R.id.etguess)
        bguess = findViewById(R.id.bguess)

        tvguess3.text = "You have $counter guesses"

        bguess.setOnClickListener { checking() }

    }

    @SuppressLint("SetTextI18n")
    fun checking() {
        var number = etguess.text!!.toString()

        if (number != "") {
            if (counter > 0) {
                if (number.toInt() == randomnum) {
                    tvguess3.text = "You guessed $number"
                    tvguess2.text = "correct!"
                }else {
                    if (number.toInt() > 10 || number.toInt() < 0) {
                        Snackbar.make(myLayoutnum, "wrong range", Snackbar.LENGTH_LONG).show()
                        etguess.setText("")}
                    else{
                        counter--
                        tvguess3.text = "You guessed $number"
                        tvguess2.text = "You have ${counter} guesses left"
                        etguess.setText("")
                    }
                }
            }
            if(counter ==0){
                tvguess3.text = "Game Over"
                tvguess2.text = "the number was ${randomnum}"
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_activity1menu, menu)
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
            R.id.mainmenu -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}



