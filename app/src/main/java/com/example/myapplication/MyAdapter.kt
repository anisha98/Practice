package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(private val dataList:MutableList<Data>): RecyclerView.Adapter<MyHolder>(){
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]

        val userFullName = holder.itemView.user_full_name
        val userAvatar = holder.itemView.user_avatar

        //Api
        val fullname = "${data.firstName} ${data.lastName}"
        userFullName.text = fullname

        Picasso.get()
            .load(data.avatar)
            .into(userAvatar)

        holder.itemView.setOnClickListener(){

            Toast.makeText(it.context,"pressed",Toast.LENGTH_SHORT).show()
            val firstname = data.firstName
            val lastname = data.lastName
            val email = data.email
            val image = data.avatar
            val intent = Intent(it.context,CardViewActivity::class.java)
            intent.putExtra("firstname",firstname)
            intent.putExtra("lastname",lastname)
            intent.putExtra("email",email)
            intent.putExtra("image",image)
            it.context.startActivity(intent)
        }
    }

}