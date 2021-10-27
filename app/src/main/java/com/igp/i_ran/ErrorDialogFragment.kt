package com.igp.i_ran

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.igp.i_ran.databinding.CustomErrorDialogBinding

class ErrorDialogFragment : DialogFragment() {

    private lateinit var binding: CustomErrorDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = CustomErrorDialogBinding.inflate(LayoutInflater.from(context))

        val errorDialog = activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)

            builder.setView(binding.root)

            /*
            isCancelable = false

            binding.btnSave.setOnClickListener {

                dismiss()
            }*/

            // Create the AlertDialog object and return it
            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
        errorDialog.window?.setBackgroundDrawable(ColorDrawable(0))
        return errorDialog
    }
     override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View {
         return binding.root
     }

}