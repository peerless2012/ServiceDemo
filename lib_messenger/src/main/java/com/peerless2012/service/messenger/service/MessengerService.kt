package com.peerless2012.service.messenger.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * @Author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2022/6/16 19:41
 * @Version V1.0
 * @Description
 */
class MessengerService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}