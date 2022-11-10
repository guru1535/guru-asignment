package com.example.notificationandroid

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private val channelName = "Live Stream"
    private val channelDesc = "Live Description"
    private val channelId = "LVSTRM"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_notification).setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification() {



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){




            var channel = NotificationChannel(channelId , channelName , NotificationManager.IMPORTANCE_HIGH)
            channel.description = channelDesc

            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }




        var builder = NotificationCompat.Builder(this , channelId)

            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("Keval Mangukiya")
            .setContentText("Welcome To Keval Mangukiya")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Much Longer Text That cannot fit ones"))
            .setDefaults(Notification.DEFAULT_ALL)
            .setVibrate(longArrayOf(100 , 200 , 300 , 400 , 500 , 400 , 300 , 200 , 100))

        var notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1 , builder.build())

    }
}