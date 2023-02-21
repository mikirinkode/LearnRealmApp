package com.mikirinkode.myfirstrealm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikirinkode.myfirstrealm.databinding.ActivityMainBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val database: Realm by lazy {
        Database.getDatabase()
    }

    private val userAdapter: UserAdapter by lazy {
        UserAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        observeData()

        binding.apply {
            rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUser.adapter = userAdapter

            btnSubmit.setOnClickListener {
                submit()
            }
        }
    }

    private fun observeData() {
        val users: RealmResults<User> = database.query<User>().find()
        userAdapter.setList(users)
    }

    private fun submit() {
        Toast.makeText(this, "SUBMIT CALLED", Toast.LENGTH_SHORT).show()
        binding.apply {
            val inputName = edtName.text.toString()
            val inputEmail = edtEmail.text.toString()

            database.writeBlocking {
                copyToRealm(User().apply {
                    name = inputName
                    email = inputEmail
                })
            }
        }
        Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show()
    }
}