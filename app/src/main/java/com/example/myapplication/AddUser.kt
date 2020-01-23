package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class AddUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        btn_add.setOnClickListener()
        {
            if (id.text.isEmpty()) {
                id.setError("Need to Enter")
            }
            if (email.text.isEmpty()) {
                email.setError("Need to Enter")
            }
            if (firstname.text.isEmpty()) {
                firstname.setError("Need to Enter")
            }
            if (lastname.text.isEmpty()) {
                lastname.setError("Need to Enter")
            }
            if (avatar.text.isEmpty()) {
                avatar.setError("Need to Enter")
            }


            if (id.text.isNotEmpty() || email.text.isNotEmpty() || lastname.text.isNotEmpty() || firstname.text.isNotEmpty() || avatar.text.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("firstname", firstname.text)
                intent.putExtra("id", id.text)
                intent.putExtra("lastname", lastname.text)
                intent.putExtra("email", email.text)
                intent.putExtra("image", avatar.text)
                setResult(Activity.RESULT_OK,intent)
                finish()
                //startActivity(intent)
            }
        }
    }

}
