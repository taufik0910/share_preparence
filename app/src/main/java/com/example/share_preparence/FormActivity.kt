package com.example.share_preparence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.share_preparence.databinding.ActivityFormBinding
import com.example.share_preparence.helper.ProfilePref
import com.example.share_preparence.helper.model.Profile

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    lateinit var profilePref: ProfilePref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var et_name = binding.edName
        var et_age = binding.edAge
        var et_geder = binding.edGender
        val btn_save = binding.btnSave


        profilePref = ProfilePref(this)
        if (profilePref.preference.contains(ProfilePref.NAME)) {
            val profile = profilePref.getProfile()
            et_name.setText(profile.name)
            profile.age?.let { et_age.setText(it.toString()) }
            et_geder.setText(profile.gender)
        }
        btn_save.setOnClickListener {
            val name = et_name.text.toString().trim()
            val age = et_age.text.toString().trim()
          //  val gender = et_geder.toString().trim()

            val profile = Profile(
                name,
                age.toInt(),
              //  gender
            )

            saveToPref(profile)

        }
    }

    private fun saveToPref(profile: Profile) {
        profilePref.setProfile(profile)
        Toast.makeText(this, " data berhasil disimpan", Toast.LENGTH_SHORT).show()
        Intent(this, MainActivity::class.java).also {
            it.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }

    }
}