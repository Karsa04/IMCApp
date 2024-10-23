package com.example.imcapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var maleview: CardView
    private lateinit var femaleview: CardView

    override fun onCreate(savedInstanceState: Bundle?) {

        initComponents()
        initListeners()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initComponents() {
        maleview = findViewById(R.id.maleview)
        femaleview = findViewById(R.id.femaleview)
    }

    private fun initListeners(){
        setGenderColor()
    }
    private fun setGenderColor(){
        maleview.setCardBackgroundColor()
    }
}