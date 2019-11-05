package com.example.menu_app_projects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // this funtion here one of the option menu should br implementaed inorder to get on
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.manu, menu)
        return true
    }

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_search -> {
            ShowSearch("Search")
            true
        }
        R.id.action_profile -> {
            ShowSetting("Profile")
            true
        }
        R.id.action_setting -> {
            ShowSetting("Setting")
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    // this funtion here allow the user to search what evere they want to searh anyway
    fun ShowSearch(sea:String){
        Toast.makeText(this, "Search what you want " , Toast.LENGTH_LONG).show()
    }
    // this funtion allow the user to get to the setting activity
    fun ShowSetting(set:String){
        var intent = Intent (application , Setting::class.java)
        startActivities(arrayOf(intent))
        Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show()
    }
    // this functon here allow the user to show the profile activity
    fun showProfile(s: String) {
        var intent = Intent (application , MainActivity ::class.java)
        startActivities(arrayOf(intent))
        Toast.makeText(this, "Update Your Profile", Toast.LENGTH_LONG).show()
    }
}