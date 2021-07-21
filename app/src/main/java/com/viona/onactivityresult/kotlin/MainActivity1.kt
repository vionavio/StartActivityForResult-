package com.viona.onactivityresult.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.viona.onactivityresult.MainActivity
import com.viona.onactivityresult.databinding.ActivityMain1Binding
import com.viona.onactivityresult.utils.BetterActivityResult

class MainActivity1 : AppCompatActivity() {

    private lateinit var activityMain1Binding: ActivityMain1Binding
    private val activityLauncher = BetterActivityResult.registerActivityForResult(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain1Binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(activityMain1Binding.root)

        val resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data
                val a = data?.getBooleanExtra("Viona", false)
                Toast.makeText(this, a.toString() , Toast.LENGTH_SHORT).show()

                if (a == true){
                    activityMain1Binding.button2.visibility = View.GONE
                }
            }


        }

        activityMain1Binding.button1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            resultLauncher.launch(intent)
        }

        activityMain1Binding.button2.setOnClickListener {
            toMainActivity2()
        }
    }

    private fun toMainActivity2(){
        val intent = Intent(this, MainActivity2::class.java)
        activityLauncher.launch(intent){
            result : ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK){
                val data = result.data
                val a = data?.getBooleanExtra("Viona", false)
                Toast.makeText(this, a.toString() , Toast.LENGTH_SHORT).show()

                if (a == true){
                    activityMain1Binding.button2.visibility = View.GONE
                }
            }
        }
    }






}