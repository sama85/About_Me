package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //initialize data element
        binding.myName = MyName("Sama", "nickname")

        binding.doneButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view : View?) {
                setNickNameText(view)
            }
        })

    }

    private fun setNickNameText(view: View?) {
            binding.apply {
                invalidateAll() //to refresh UI with new data?
                //nicknameText.text = binding.nicknameEt.text

                //assign nickname to data element and set visibilties
                myName?.nickname = binding.nicknameEt.text.toString()
                nicknameEt.visibility = View.GONE
                doneButton.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
            }
    }
}