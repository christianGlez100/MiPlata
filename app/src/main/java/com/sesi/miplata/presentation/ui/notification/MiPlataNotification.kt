package com.sesi.miplata.presentation.ui.notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.sesi.miplata.v2.R

class MiPlataNotification {

    fun sendNotification(context: Context, title: String, message: String, pendingIntent: PendingIntent) {
        val channel = NotificationChannel(
            Companion.NOTIFICATION_ID,
            "PaymentNotification",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.description = context.getString(R.string.notify_title)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        val logoBitmap =
            BitmapFactory.decodeResource(context.resources, R.drawable.miplataicon)
        val notification = NotificationCompat.Builder(context, NOTIFICATION_ID)
            .setSmallIcon(R.drawable.ic_launcher_round)
            .setContentTitle(context.getString(R.string.notify_title))
            .setContentText(context.getString(R.string.notify_content))
            .setLargeIcon(logoBitmap)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(message)
            )
            .setContentIntent(pendingIntent)
            .build()
        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                notify(0, notification)
            }
        }
    }

    companion object {
        const val NOTIFICATION_ID = "NotiId"
    }
}