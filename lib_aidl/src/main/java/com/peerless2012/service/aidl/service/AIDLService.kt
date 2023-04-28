package com.peerless2012.service.aidl.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.peerless2012.service.aidl.AIDLInterface

/**
 * @Author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2022/6/15 16:55
 * @Version V1.0
 * @Description:
 */
class AIDLService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return object : AIDLInterface.Stub() {
            override fun basicTypes(
                anInt: Int,
                aLong: Long,
                aBoolean: Boolean,
                aFloat: Float,
                aDouble: Double,
                aString: String?,
            ): String {
                return "Int = $anInt, long = $aLong, bool = $aBoolean, double = $aDouble, string = $aString"
            }

        }
    }

}