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
    private lateinit var edadNum:TextView
    private lateinit var pesoNum:TextView
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton

    var  operacion =true
    private var Weight =0
    private var age=0

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
        edadNum= findViewById(R.id.edadNum)
        pesoNum= findViewById(R.id.pesoNum)
        btnAddWeight= findViewById(R.id.btnAddAge)
        btnSubtractWeight= findViewById(R.id.btnSubtractAge)
        btnAddAge= findViewById(R.id.btnaddAge2)
        btnSubtractAge= findViewById(R.id.btnSubtractAge2)
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
        btnAddWeight.setOnClickListener {
            operacion=true
            setWeight(operacion)
        }

        btnAddAge.setOnClickListener {
            operacion=true
            setAge(operacion)
        }

        btnSubtractWeight.setOnClickListener {
            operacion=false
            setWeight(operacion)
        }

        btnSubtractAge.setOnClickListener {
            operacion=false
            setAge(operacion)
        }


    }
    private fun setGenderColor(isMaleSelected: Boolean){
        maleview.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        femaleview.setCardBackgroundColor(getBackgroundColor(!isMaleSelected))
    }
    private fun setWeight(operacion:Boolean){
        if (operacion){
            this.Weight+=1
            pesoNum.setText(""+this.Weight)
        }else{
            this.Weight-=1
            pesoNum.setText(""+this.Weight)
        }

    }  private fun setAge(operacion:Boolean){
        if (operacion){
            this.age+=1
            edadNum.setText(""+this.age)
        }else{
            this.age-=1
            edadNum.setText(""+this.age)
        }
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
        setAge(operacion)
        setWeight(operacion)
    }
}