package com.example.assignement4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.assignment2.SecondActivity
import com.example.assignment3.ThirdActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnt2.setOnClickListener {
            Log.i("Second Activity", "You are now directed to Task 2")
            Toast.makeText(this, "You are now directed to Task 2", Toast.LENGTH_SHORT).show()

            val intent= Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }

        btnt3.setOnClickListener {
            Log.i("Third Activity", "You are now directed to Task 3")
            Toast.makeText(this, "You are now directed to Task 3", Toast.LENGTH_SHORT).show()

            val intent= Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }



    }


}