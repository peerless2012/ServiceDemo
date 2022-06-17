package com.peerless2012.service.core

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

/**
 * @Author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2022/6/17 15:16
 * @Version V1.0
 * @Description
 */
open class ServiceBinderFragment : Fragment(), ServiceConnection {

    private var mBinded = false

    private lateinit var mBindBtn: Button

    private lateinit var mOperationView: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBindBtn = view.findViewById(R.id.btn_bind_service)
        mBindBtn.isEnabled = true
        mBindBtn.setText(R.string.bind_service)
        mOperationView = view.findViewById(R.id.widget_operation)
        mOperationView.isEnabled = false
    }

    open override fun onServiceConnected(name: ComponentName, service: IBinder?) {
        mBinded = true
        mBindBtn.isEnabled = true
        mBindBtn.setText(R.string.unbind_service)
        mOperationView.isEnabled = true
    }

    open override fun onServiceDisconnected(name: ComponentName) {
        mBinded = false
        mBindBtn.isEnabled = true
        mBindBtn.setText(R.string.bind_service)
    }

    fun bindService() {
        mBindBtn.isEnabled = false
    }

    fun unBindService() {

    }

}