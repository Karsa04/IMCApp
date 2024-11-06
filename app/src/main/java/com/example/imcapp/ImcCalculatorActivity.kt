package com.example.imcapp

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider


class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var maleview: CardView
    private lateinit var femaleview: CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var edad:TextView
    private lateinit var peso:TextView
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnAddAge2: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnSubtractAge2: FloatingActionButton

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
        rsHeight = findViewById(R.id.rsHeight)
        tvHeight= findViewById(R.id.tvHeight)
    }

    private fun initListeners() {

        maleview.setOnClickListener{
        setGenderColor(true)
    }
        femaleview.setOnClickListener{
            setGenderColor(false)
        }
        
        rsHeight.addOnChangeListener {_,value,_ ->

            tvHeight.text= DecimalFormat("#.##").format(value)+"cm"
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