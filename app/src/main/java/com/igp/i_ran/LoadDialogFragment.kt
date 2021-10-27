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
import com.igp.i_ran.databinding.CustomLoadDialogBinding

class LoadDialogFragment : DialogFragment() {

    private lateinit var binding : CustomLoadDialogBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = CustomLoadDialogBinding.inflate(LayoutInflater.from(context))

        val loadDialog = activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)

            builder.setView(binding.root)
            isCancelable = false

            // Create the AlertDialog object and return it
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
        loadDialog.window?.setBackgroundDrawable(ColorDrawable(0))
        return loadDialog
    }


    override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View {

         return binding.root
     }

}