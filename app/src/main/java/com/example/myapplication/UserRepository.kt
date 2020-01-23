package com.example.myapplication

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    var allUsers: LiveData<List<User>> = userDao.getAllUsers()

    //inserts to the database
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}