package com.viona.onactivityresult.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.viona.onactivityresult.R
import com.viona.onactivityresult.databinding.ActivityMain2Binding
import com.viona.onactivityresult.utils.BetterActivityResult

class MainActivity2 : AppCompatActivity() {

    private lateinit var activityMain2Binding: ActivityMain2Binding
    var isFavorite = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain2Binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(activityMain2Binding.root)

        activityMain2Binding.button3.setOnClickListener {

            setResult(Activity.RESULT_OK,
                Intent().putExtra("Viona", isFavorite))

            finish()
        }
    }
}