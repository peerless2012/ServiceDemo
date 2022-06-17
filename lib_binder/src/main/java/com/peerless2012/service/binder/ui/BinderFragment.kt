package com.peerless2012.service.binder.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import androidx.fragment.app.Fragment
import com.peerless2012.service.binder.R
import com.peerless2012.service.binder.service.BinderService

/**
 * @Author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2022/6/16 19:31
 * @Version V1.0
 * @Description
 */
class BinderFragment : Fragment(R.layout.fragment_binder) {

    private var mBinded = false

    private var mBinderService: BinderService? = null

    private val serviceConnection = object : ServiceConnection {

        override fun onServiceConnected(name: ComponentName, service: IBinder?) {
            service?.let {
                mBinderService = (service as BinderService.InnerBinder).getService()
            }
            mBinded = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mBinded = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(requireContext(), BinderService::class.java)
        requireContext().bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}