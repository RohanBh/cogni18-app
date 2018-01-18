package com.cognizance.cognizance18.fragments

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.cognizance.cognizance18.R


class BottomSheetFragment : BottomSheetDialogFragment() {

    interface OnBottomSheetCancelledListener {
        fun onBottomSheetCancel()
    }

    private lateinit var mListener: OnBottomSheetCancelledListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as? OnBottomSheetCancelledListener ?:
                throw ClassCastException("$context must implement OnBottomSheetCancelledListener")
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false)

    override fun onCancel(dialog: DialogInterface?) {
        super.onCancel(dialog)
        mListener.onBottomSheetCancel()
    }

}
