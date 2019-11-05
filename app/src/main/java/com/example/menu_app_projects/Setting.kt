package com.example.menu_app_projects

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.menu_app_projects.ui.login.LoginActivity

import kotlinx.android.synthetic.main.activity_setting.*

class Setting : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        // this button allow the user to get back very quick
        btn_back.setOnClickListener{
            var intent = Intent (this , MainActivity::class.java)
            startActivity(intent)
        }
        // this here logout the account
        btn_logout.setOnClickListener{
            var intent = Intent(applicationContext , LoginActivity ::class.java )
            startActivities(arrayOf(intent))

        }

        // Notification allow the user
        // this button allow the app get notifications

        var notificationManager =getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        var id = " Channel_01"
        var name = " Defult_Channel"
        var important =  NotificationManager.IMPORTANCE_HIGH
        var channels = NotificationChannel(id,name , important)
        channels.lightColor = Color.CYAN

        notificationManager.createNotificationChannel(channels)


        // this code here allow the user to switch off the notification or switch back on
        swt_notify.setOnClickListener{
            var ncbuilder = NotificationCompat.Builder(this , " Channel_01")
            ncbuilder.setSmallIcon(R.drawable.notification_icon_background)
            ncbuilder.setContentTitle("Setting Notification ")
            ncbuilder.setContentText("This is the best notification allow the user ")
            val mNoficiationManager =
                getSystemService(Context.NOTIFICATION_SERVICE)
                        as NotificationManager

            mNoficiationManager.notify(1, ncbuilder.build())

        }

    }
}