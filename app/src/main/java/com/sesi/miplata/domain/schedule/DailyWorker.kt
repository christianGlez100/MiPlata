package com.sesi.miplata.domain.schedule

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class DailyWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters
): CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        Log.i("DayliWorker", "init DayliWorker")
      /*  val notification = MiPlataNotification()
        val notifyIntent = Intent(appContext, RegistroOperacionesDayliActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val notifyPendingIntent = PendingIntent.getActivity(
            appContext,
            0,
            notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        notification.sendNotification(
            context = appContext,
            title = "",
            message = appContext.getString(R.string.dialog_dayli_message),
            pendingIntent = notifyPendingIntent
        )*/
        return Result.success()
    }
}