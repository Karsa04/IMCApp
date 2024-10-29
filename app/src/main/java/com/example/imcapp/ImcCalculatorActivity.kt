package com.example.imcapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat


class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var maleview: CardView
    private lateinit var femaleview: CardView
    var  isMaleSelected=true

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }
    private fun initComponents() {
        maleview = findViewById(R.id.maleview)
        femaleview = findViewById(R.id.femaleview)
    }

    private fun initListeners() {

        maleview.setOnClickListener{
        setGenderColor(true)
    }
        femaleview.setOnClickListener{
            setGenderColor(false)
        }


    }
    private fun setGenderColor(isMaleSelected: Boolean){
        maleview.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        femaleview.setCardBackgroundColor(getBackgroundColor(!isMaleSelected))
    }
    private fun getBackgroundColor(isMaleSelected: Boolean): Int {
        val colorReference = if(isMaleSelected) {
            R.color.bg_comp_sel
        } else {
            R.color.bg_comp
        }
        return ContextCompat.getColor(this,colorReference)
    }

    private fun initUI(){
        setGenderColor(true)
    }
}