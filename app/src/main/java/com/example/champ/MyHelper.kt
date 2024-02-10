package com.example.champ

import android.content.Context
import androidx.appcompat.app.AlertDialog

class MyHelper {
    companion object{
        fun alert(context: Context, title:String, message:String, btnOk:String = "Ok", btnCancel:String = "Cancel"){
            AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(btnOk) { _, _ -> }
                .setNegativeButton(btnCancel){_, _ ->}
                .show()
        }
    }
}