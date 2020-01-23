package com.example.myapplication
//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.myapplication.model.Data
import com.example.myapplication.model.Reqres
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_card.*
//import android.support.v7.widget.GridLayoutManager
//import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList:MutableList<Data> = mutableListOf()
    //The lateinit keyword stands for late initialization. Lateinit comes very handy when a non-null initializer cannot be supplied in the constructor, but the developer is certain that the variable will not be null when accessing it, thus avoiding null checks when referencing it later.
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create instance of adapter class
        myAdapter = MyAdapter(dataList)

        //create instance of recycler view and attach the recycler view to the adapter class
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(DividerItemDecoration(this,OrientationHelper.VERTICAL))
        recyclerview.adapter = myAdapter

        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://reqres.in/api/users?page=2")
            .build()
            .getAsObject(Reqres::class.java,object:ParsedRequestListener<Reqres>{
                override fun onResponse(response: Reqres?) {
                    dataList.addAll(response!!.data)
                    myAdapter.notifyDataSetChanged()
                }
                override fun onError(anError: ANError?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        button_add_note.setOnClickListener(){
            val intent = Intent(this,AddUser::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1 && resultCode == RESULT_OK)
        {
            val bundle: Bundle? = this.intent.extras
            bundle?.let{
                val id = bundle.getString("id")
                val firstname= bundle.getString("firstname")
                val lastname= bundle.getString("lastname")
                val email= bundle.getString("email")
                val avatar= bundle.getString("image")

                //User user = new User(id,firstname,lastname,email,avator)
                //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

                //Picasso.get()
                  //  .load(image)
                  //  .into(card_img)
            }
        }
    }
}