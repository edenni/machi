package com.eden.machi

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_time_picker.*


class TimePickerFragment : DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_time_picker, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.fragment_time_picker, null)
        val builder = AlertDialog.Builder(context)

        builder.setView(dialogView)
        builder.setTitle("NumberPickerDialog")
        builder.setPositiveButton("OK") { dialog, id ->
            
        }
        builder.setNegativeButton("CANCEL") { dialog, id ->

        }

        val hourPicker = dialogView.findViewById<NumberPicker>(R.id.hourPicker)
        val minutePicker = dialogView.findViewById<NumberPicker>(R.id.minutePicker)
        hourPicker?.minValue = 0
        hourPicker.maxValue = 24
        hourPicker.value = 0
        minutePicker.minValue = 0
        minutePicker.maxValue = 60
        hourPicker.value = 20

        return builder.create()
    }
}

