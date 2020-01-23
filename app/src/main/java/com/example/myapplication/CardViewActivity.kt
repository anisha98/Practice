package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_card.*

class CardViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        val bundle: Bundle? = this.intent.extras
        bundle?.let{
            val firstname= bundle.getString("firstname")
            val lastname= bundle.getString("lastname")
            val email= bundle.getString("email")
            val image= bundle.getString("image")
            //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
            first_name.text = firstname
            last_name.text = lastname
            email_id.text = email
            Picasso.get()
                .load(image)
                .into(card_img)
        }
    }
}
