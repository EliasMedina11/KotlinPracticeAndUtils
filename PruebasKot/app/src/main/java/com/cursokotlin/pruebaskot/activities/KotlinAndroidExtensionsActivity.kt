package com.cursokotlin.pruebaskot.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cursokotlin.pruebaskot.MainActivity
import com.cursokotlin.pruebaskot.R
import com.cursokotlin.pruebaskot.others.goToActivity
import com.cursokotlin.pruebaskot.others.loadByUrl
import com.cursokotlin.pruebaskot.others.snackBar
import com.cursokotlin.pruebaskot.others.toast
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        buttonToast.setOnClickListener { toast(R.string.button_kat_id) }
        buttonSnackBar.setOnClickListener { snackBar(" I love Extension Functions!!", action = "Undo") { toast("Undo?")}}
        buttonLoadByUrl.setOnClickListener {  imageViewLoadedByUrl.loadByUrl("http://www.abc.es/media/play/2017/08/01/one-piece-U201001054433iyG--620x349@abc.jpg")}
        buttonGoToActivity.setOnClickListener {  goToActivity<MainActivity>{putExtra("id" , 1)} }
    }
}
