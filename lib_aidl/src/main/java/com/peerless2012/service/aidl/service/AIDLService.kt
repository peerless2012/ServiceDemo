package com.peerless2012.service.aidl.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * @Author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2022/6/15 16:55
 * @Version V1.0
 * @Description:
 */
class AIDLService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}