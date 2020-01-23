package com.example.myapplication



import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var email: String? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    var avatar: String? = null
)