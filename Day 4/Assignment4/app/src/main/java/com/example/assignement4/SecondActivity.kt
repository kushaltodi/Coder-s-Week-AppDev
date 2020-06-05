package com.example.assignment2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignement4.R
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {

    var myInt: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    @Override
    fun onButtonClick(view: View ) {
        if (myInt >= 0) {
            myInt += 1
            textView.text = myInt.toString()

        }

    }

}




