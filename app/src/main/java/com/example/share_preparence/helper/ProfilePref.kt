package com.example.share_preparence.helper

import android.content.Context
import com.example.share_preparence.helper.model.Profile

class ProfilePref(context: Context) {
    companion object {
        const val SP_NAME = "profile_name"
        const val NAME = "name"
        const val AGE = "age"
        const val GENDER = "GENDER"
    }

    val preference = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun setProfile(profile: Profile) {
        val prefEditor = preference.edit()
        prefEditor.putString(NAME, profile.name)
        profile.age?.let { prefEditor.putInt(AGE, it) }
        prefEditor.putString(GENDER, profile.gender)
        prefEditor.apply()
    }

    fun getProfile(): Profile {
        val profile = Profile()
        profile.name = preference.getString(NAME, "")
        profile.age = preference.getInt(AGE, 0)
        profile.gender = preference.getString(GENDER, "")
        return profile
    }

}