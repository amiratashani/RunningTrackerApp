package com.example.runningtrackerapp.ui.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.runningtrackerapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialogFragment : DialogFragment() {

    private var yesListener: (() -> Unit)? = null
    fun setListener(listener: () -> Unit) {
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel the Run?")
            .setMessage("Are you sure to cancel the current run and delete all its data?")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Yes") { _, _ ->
                yesListener?.let { yes ->
                    yes()
                }
            }
            .setNegativeButton("No") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
            .create()

    }

}