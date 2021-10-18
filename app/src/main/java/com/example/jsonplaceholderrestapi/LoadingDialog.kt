package com.example.jsonplaceholderrestapi

import android.app.Activity
import android.app.AlertDialog
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

class LoadingDialog(val fragment: Fragment) {
   private lateinit var dialog: AlertDialog

    fun startLoadingDialog() {
        val builder= AlertDialog.Builder(fragment.context)
        val inflater= fragment.layoutInflater
        builder.setView(inflater.inflate(R.layout.costum_dialog, null))
            .apply { setCancelable(false) }
        dialog = builder.create()
        dialog.show()
    }
    fun dismissDialog(){
        dialog.dismiss()
    }

}