package com.example.imcapp

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imcapp.ImcCalculatorActivity.Companion.IMC_KEY

class ImcResultActivity : AppCompatActivity() {
    private lateinit var ReCalc:Button
    private lateinit var tvResult: TextView
    private lateinit var TipoPeso: TextView
    private lateinit var Explica: TextView
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_result)

        initComponents()
        initListeners()
        initUI()

       //val imc1= intent.extras?.getString("IMC_KEY").orEmpty()

    }

    private fun initComponents() {
    ReCalc= findViewById(R.id.ReCalc)
    tvResult= findViewById(R.id.tvresult)
    TipoPeso=findViewById(R.id.TipoPeso)
        Explica=findViewById(R.id.expl)
   }

    private fun initListeners() {

        ReCalc.setOnClickListener {

            finish()
        }

    }


    private fun initUI(){
        val imc = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        tvResult.text= DecimalFormat("#.##").format(imc)
        if (imc>0 && imc<18.5){

            TipoPeso.setText(R.string.PesoInsu)
            TipoPeso.setTextColor(getResources().getColor(R.color.PesoInsu) )
            Explica.setText(R.string.PesoInsuEX)

        }else if (imc<24.9){

            TipoPeso.setText(R.string.PesoNorm)
            TipoPeso.setTextColor(getResources().getColor(R.color.PesoNorm) )
            Explica.setText(R.string.PesoNormEX)

        }else if (imc<29.9){

            TipoPeso.setText(R.string.PesoSobre)
            TipoPeso.setTextColor(getResources().getColor(R.color.SobrePeso))
            Explica.setText(R.string.PesoSobreEX)
        }
        else if (imc>29.9){

            TipoPeso.setText(R.string.PesoObe)
            TipoPeso.setTextColor(getResources().getColor(R.color.Obesidad))
            Explica.setText(R.string.PesoObeEX)
        }

    }

}