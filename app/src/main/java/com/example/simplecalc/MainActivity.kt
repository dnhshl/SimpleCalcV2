package com.example.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import simplecalc.R
import simplecalc.databinding.ActivityMainBinding
import splitties.toast.toast


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var calcMode = "plus"

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val num1 = binding.editTextInput.text.toString()
            val num2 = binding.editTextInput2.text.toString()

            if(num1.isEmpty() || num2.isEmpty()){
                toast(getString(R.string.noInput))
            } else {
                val x = num1.toInt()
                val y = num2.toInt()
                when (calcMode) {
                    "plus"  ->  binding.textViewOutput.text = (x + y).toString()
                    "minus" ->  binding.textViewOutput.text = (x - y).toString()
                    "mal"   ->  binding.textViewOutput.text = (x * y).toString()
                    "durch" ->  binding.textViewOutput.text = (x / y).toString()
                }
            }
        }
    }


    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            binding.textViewOutput.text = ""

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_plus ->
                    if (checked) {
                        binding.button.text = getString(R.string.Plus)
                        calcMode = "plus"
                    }
                R.id.radio_minus ->
                    if (checked) {
                        binding.button.text = getString(R.string.Minus)
                        calcMode = "minus"
                    }
                R.id.radio_mal ->
                    if (checked) {
                        binding.button.text = getString(R.string.Mal)
                        calcMode = "mal"
                    }
                R.id.radio_durch ->
                    if (checked) {
                        binding.button.text = getString(R.string.Durch)
                        calcMode = "durch"
                    }
            }
        }
    }
}