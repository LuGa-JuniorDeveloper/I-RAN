package com.igp.i_ran

import android.content.Context
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.igp.i_ran.databinding.ActivityMainBinding
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import com.igp.i_ran.databinding.CustomLoadDialogBinding

class MainActivity : AppCompatActivity() {

    private val load    : LoadDialogFragment = LoadDialogFragment()
    private val success : SuccessDialogFragment = SuccessDialogFragment()
    private val error   : ErrorDialogFragment = ErrorDialogFragment()
    private lateinit var binding : ActivityMainBinding
    private val viewModel : OperationViewModel by viewModels()
    private lateinit var containerEnergy: Number
    private lateinit var containerTelemetry : Number
    private lateinit var containerInstrumentation : Number
    private lateinit var containerTypeOFault :Number

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_IRAN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setupObservables()

        binding.imageViewEnergy.setOnClickListener(clickListener)
        binding.imageView2Telemetry.setOnClickListener(clickListener)
        binding.imageView3Instrumentation.setOnClickListener(clickListener)
        binding.imageView4TypeOfFault.setOnClickListener(clickListener)

        binding.btnSend.setOnClickListener { button ->

            /* Código */
            val code = binding.editTextTextPersonName.text.toString()

            /*  */
            val radioButtonID: Int = binding.radioGroup.checkedRadioButtonId
            val radioButton: View = binding.radioGroup.findViewById(radioButtonID)
            val idx: Int = binding.radioGroup.indexOfChild(radioButton)
            val r = binding.radioGroup.getChildAt(idx) as RadioButton
            val s1 = r.text.toString()


            val radioButtonID2: Int = binding.radioGroup2.checkedRadioButtonId
            val radioButton2: View = binding.radioGroup2.findViewById(radioButtonID2)
            val idx2: Int = binding.radioGroup2.indexOfChild(radioButton2)
            val r2 = binding.radioGroup2.getChildAt(idx2) as RadioButton
            val s2 = r2.text.toString()


            val radioButtonID3: Int = binding.radioGroup3.checkedRadioButtonId
            val radioButton3: View = binding.radioGroup3.findViewById(radioButtonID3)
            val idx3: Int = binding.radioGroup3.indexOfChild(radioButton3)
            val r3 = binding.radioGroup3.getChildAt(idx3) as RadioButton
            val s3 = r3.text.toString()


            val radioButtonID4: Int = binding.radioGroup4.checkedRadioButtonId
            val radioButton4: View = binding.radioGroup4.findViewById(radioButtonID4)
            val idx4: Int = binding.radioGroup4.indexOfChild(radioButton4)
            val r4 = binding.radioGroup4.getChildAt(idx4) as RadioButton
            val s4 = r4.text.toString()


            val radioButtonID5: Int = binding.radioGroup5.checkedRadioButtonId
            val radioButton5: View = binding.radioGroup5.findViewById(radioButtonID5)
            val idx5: Int = binding.radioGroup5.indexOfChild(radioButton5)
            val r5 = binding.radioGroup5.getChildAt(idx5) as RadioButton
            val s5 = r5.text.toString()


            val radioButtonID6: Int = binding.radioGroup6.checkedRadioButtonId
            val radioButton6: View = binding.radioGroup6.findViewById(radioButtonID6)
            val idx6: Int = binding.radioGroup6.indexOfChild(radioButton6)
            val r6 = binding.radioGroup6.getChildAt(idx6) as RadioButton
            val s6 = r6.text.toString()


            val radioButtonID7: Int = binding.radioGroup7.checkedRadioButtonId
            val radioButton7: View = binding.radioGroup7.findViewById(radioButtonID7)
            val idx7: Int = binding.radioGroup7.indexOfChild(radioButton7)
            val r7 = binding.radioGroup7.getChildAt(idx7) as RadioButton
            val s7 = r7.text.toString()


            val radioButtonID8: Int = binding.radioGroup8.checkedRadioButtonId
            val radioButton8: View = binding.radioGroup8.findViewById(radioButtonID8)
            val idx8: Int = binding.radioGroup8.indexOfChild(radioButton8)
            val r8 = binding.radioGroup8.getChildAt(idx8) as RadioButton
            val s8 = r8.text.toString()


            val radioButtonID9: Int = binding.radioGroup9.checkedRadioButtonId
            val radioButton9: View = binding.radioGroup9.findViewById(radioButtonID9)
            val idx9: Int = binding.radioGroup9.indexOfChild(radioButton9)
            val r9 = binding.radioGroup9.getChildAt(idx9) as RadioButton
            val s9 = r9.text.toString()


            val radioButtonID10: Int = binding.radioGroup10.checkedRadioButtonId
            val radioButton10: View = binding.radioGroup10.findViewById(radioButtonID10)
            val idx10: Int = binding.radioGroup10.indexOfChild(radioButton10)
            val r10 = binding.radioGroup10.getChildAt(idx10) as RadioButton
            val s10 = r10.text.toString()


            val radioButtonID11: Int = binding.radioGroup11.checkedRadioButtonId
            val radioButton11: View = binding.radioGroup11.findViewById(radioButtonID11)
            val idx11: Int = binding.radioGroup11.indexOfChild(radioButton11)
            val r11 = binding.radioGroup11.getChildAt(idx11) as RadioButton
            val s11 = r11.text.toString()


            binding.containerDataTelemetry.visibility = View.GONE
            binding.imageView2Telemetry.setBackgroundResource(R.drawable.arrow_enlarge)
            binding.containerDataInstrumentation.visibility = View.GONE
            binding.imageView3Instrumentation.setBackgroundResource(R.drawable.arrow_enlarge)
            binding.containerDataTypeOfFault.visibility = View.GONE
            binding.imageView4TypeOfFault.setBackgroundResource(R.drawable.arrow_enlarge)
            binding.containerDataEnergy.visibility = View.GONE
            binding.imageViewEnergy.setBackgroundResource(R.drawable.arrow_enlarge)
            containerEnergy = 0
            containerTelemetry = 0
            containerInstrumentation = 0
            containerTypeOFault = 0

            hideKeyboard(button)
            viewModel.grabar(code, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11)

        }
    }

    private fun init() = with(binding) {

        containerEnergy = 0
        containerTelemetry = 0
        containerInstrumentation = 0
        containerTypeOFault = 0

        imageViewEnergy.setBackgroundResource(R.drawable.arrow_enlarge)
        imageView2Telemetry.setBackgroundResource(R.drawable.arrow_enlarge)
        imageView3Instrumentation.setBackgroundResource(R.drawable.arrow_enlarge)
        imageView4TypeOfFault.setBackgroundResource(R.drawable.arrow_enlarge)

    }

    private fun setupObservables() {
        viewModel.report.observe(this, { report ->
            binding.editTextTextPersonName.setText("")
            success.show(supportFragmentManager,"")

        })

        viewModel.loader.observe(this, { condition ->

            if (condition == true){
                load.show(supportFragmentManager,"")
            } else {
                load.dismiss()
            }

        })

        viewModel.error.observe(this, { error1 ->
            error.show(supportFragmentManager,"")
        })
    }

    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.imageView_energy-> {

                if(containerEnergy == 0){
                    binding.containerDataTelemetry.visibility = View.GONE
                    binding.imageView2Telemetry.setBackgroundResource(R.drawable.arrow_enlarge)
                    binding.containerDataInstrumentation.visibility = View.GONE
                    binding.imageView3Instrumentation.setBackgroundResource(R.drawable.arrow_enlarge)
                    binding.containerDataTypeOfFault.visibility = View.GONE
                    binding.imageView4TypeOfFault.setBackgroundResource(R.drawable.arrow_enlarge)


                    binding.containerDataEnergy.visibility = View.VISIBLE
                    binding.imageViewEnergy.setBackgroundResource(R.drawable.arrow_contract)
                    containerEnergy = 1
                } else {
                    binding.containerDataEnergy.visibility = View.GONE
                    binding.imageViewEnergy.setBackgroundResource(R.drawable.arrow_enlarge)
                    containerEnergy = 0
                }

            }
            R.id.imageView2_telemetry-> {

                if(containerTelemetry == 0){

                    binding.containerDataEnergy.visibility = View.GONE
                    binding.imageViewEnergy.setBackgroundResource(R.drawable.arrow_enlarge)
                    binding.containerDataInstrumentation.visibility = View.GONE
                    binding.imageView3Instrumentation.setBackgroundResource(R.drawable.arrow_enlarge)
                    binding.containerDataTypeOfFault.visibility = View.GONE
                    binding.imageView4TypeOfFault.setBackgroundResource(R.drawable.arrow_enlarge)



                    binding.containerDataTelemetry.visibility = View.VISIBLE
                    binding.imageView2Telemetry.setBackgroundResource(R.drawable.arrow_contract)
                    containerTelemetry = 1

                } else {
                    binding.containerDataTelemetry.visibility = View.GONE
                    binding.imageView2Telemetry.setBackgroundResource(R.drawable.arrow_enlarge)
                    containerTelemetry = 0
                }

            }
            R.id.imageView3_instrumentation-> {

                if(containerInstrumentation == 0){

                    binding.containerDataEnergy.visibility = View.GONE
                    binding.imageViewEnergy.setBackgroundResource(R.drawable.arrow_enlarge)

                    binding.containerDataTelemetry.visibility = View.GONE
                    binding.imageView2Telemetry.setBackgroundResource(R.drawable.arrow_enlarge)

                    binding.containerDataTypeOfFault.visibility = View.GONE
                    binding.imageView4TypeOfFault.setBackgroundResource(R.drawable.arrow_enlarge)


                    binding.containerDataInstrumentation.visibility = View.VISIBLE
                    binding.imageView3Instrumentation.setBackgroundResource(R.drawable.arrow_contract)
                    containerInstrumentation = 1
                } else {
                    binding.containerDataInstrumentation.visibility = View.GONE
                    binding.imageView3Instrumentation.setBackgroundResource(R.drawable.arrow_enlarge)
                    containerInstrumentation = 0
                }

            }
            R.id.imageView4_type_of_fault-> {

                if(containerTypeOFault == 0){

                    binding.containerDataEnergy.visibility = View.GONE
                    binding.imageViewEnergy.setBackgroundResource(R.drawable.arrow_enlarge)

                    binding.containerDataTelemetry.visibility = View.GONE
                    binding.imageView2Telemetry.setBackgroundResource(R.drawable.arrow_enlarge)

                    binding.containerDataInstrumentation.visibility = View.GONE
                    binding.imageView3Instrumentation.setBackgroundResource(R.drawable.arrow_enlarge)


                    binding.containerDataTypeOfFault.visibility = View.VISIBLE
                    binding.imageView4TypeOfFault.setBackgroundResource(R.drawable.arrow_contract)
                    containerTypeOFault = 1
                } else {
                    binding.containerDataTypeOfFault.visibility = View.GONE
                    binding.imageView4TypeOfFault.setBackgroundResource(R.drawable.arrow_enlarge)
                    containerTypeOFault = 0
                }

            }
        }
    }




    private fun hideKeyboard(view: View) {
        val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}