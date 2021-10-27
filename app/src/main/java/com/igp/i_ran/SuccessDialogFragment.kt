package com.igp.i_ran

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.igp.i_ran.databinding.CustomSuccessDialogBinding

class SuccessDialogFragment : DialogFragment() {

    private lateinit var binding : CustomSuccessDialogBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = CustomSuccessDialogBinding.inflate(LayoutInflater.from(context))

        val successDialog = activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)

            builder.setView(binding.root)

            /*
            isCancelable = false

            binding.btnAdd.setOnClickListener {
                dismiss()
            }*/

            // Create the AlertDialog object and return it
            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
        successDialog.window?.setBackgroundDrawable(ColorDrawable(0))
        return successDialog
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}