package com.example.assignment5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.assignment5.SecondActivity
import com.example.assignment5.ThirdActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var providers: List<AuthUI.IdpConfig>
    private val MY_REQUEST_CODE:Int=7117

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


        providers = Arrays.asList<AuthUI.IdpConfig>(

            AuthUI.IdpConfig.EmailBuilder().build(),//Email login
            AuthUI.IdpConfig.GoogleBuilder().build(),//google login
            AuthUI.IdpConfig.PhoneBuilder().build()//Phone login

            //You can add more options to this list if you like
        )

        ShowSigninOptions()


        //if user pesses signout
        btnso.setOnClickListener{

            AuthUI.getInstance().signOut(this@MainActivity)
                .addOnCompleteListener {

                    btnso.isEnabled=false
                    ShowSigninOptions() //once logged out go back to firebase sign in screen

                }
                .addOnFailureListener {

                        e->  Toast.makeText(this@MainActivity,e.message, Toast.LENGTH_LONG).show()

                }


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==MY_REQUEST_CODE){

            val response= IdpResponse.fromResultIntent(data)
            if (resultCode== Activity.RESULT_OK){
                val user= FirebaseAuth.getInstance().currentUser
                Toast.makeText(this,"Signed in as "+user!!.email, Toast.LENGTH_LONG).show()

                btnso.isEnabled=true

            }else{

                Toast.makeText(this,""+response!!.error!!.message, Toast.LENGTH_LONG).show()


            }
        }


    }

    private fun ShowSigninOptions(){

        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setTheme(R.style.MyTheme).
            build(),MY_REQUEST_CODE)



    }

}