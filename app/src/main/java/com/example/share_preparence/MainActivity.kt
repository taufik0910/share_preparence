package com.example.share_preparence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import com.example.share_preparence.databinding.ActivityMainBinding
import com.example.share_preparence.helper.ProfilePref
import com.example.share_preparence.helper.model.Profile

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var profilePref: ProfilePref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnEdit = binding.btnEdit
        val tvName = binding.tvName
        val tvAge = binding.tvge
        val tvGender = binding.tvGender

        profilePref = ProfilePref(this)
        if (profilePref.preference.contains(ProfilePref.NAME)) {
            val profile = profilePref.getProfile()
            tvName.text = profile.name
            tvAge.text = profile.age.toString()
            tvGender.text = profile.gender
        }

        btnEdit.setOnClickListener {
            Intent(this, FormActivity::class.java).also { startActivity(it) }
        }
    }
}