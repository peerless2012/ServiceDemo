package com.peerless2012.service.binder.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlin.random.Random

/**
 * @Author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2022/6/16 19:31
 * @Version V1.0
 * @Description
 */
class BinderService : Service() {

    private val binder = InnerBinder()

    private val random = Random.Default

    override fun onCreate() {
        super.onCreate()
    }

    public fun randomNum(): Int {
        return random.nextInt()
    }

    override fun onBind(intent: Intent): IBinder? {
        return binder
    }

    inner class InnerBinder : Binder() {

        fun getService(): BinderService = this@BinderService

    }
}