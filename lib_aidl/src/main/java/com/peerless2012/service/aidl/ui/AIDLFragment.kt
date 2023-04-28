package com.peerless2012.service.aidl.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.hardware.HardwareBuffer
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.peerless2012.service.aidl.AIDLInterface
import com.peerless2012.service.aidl.R
import com.peerless2012.service.aidl.service.AIDLService

/**
 * @Author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2022/6/15 16:54
 * @Version V1.0
 * @Description:
 */
class AIDLFragment : Fragment(R.layout.fragment_aidl), View.OnClickListener {

    private lateinit var sendLargeDataBtn: Button

    private var aidlInterface: AIDLInterface? = null

    private val aidlServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            aidlInterface = AIDLInterface.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            aidlInterface = null
            val a = HardwareBuffer.create()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(context, AIDLService::class.java)
        requireContext().bindService(intent,
            aidlServiceConnection,
            Context.BIND_AUTO_CREATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendLargeDataBtn = view.findViewById(R.id.aidl_send_large_data)
        sendLargeDataBtn.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        requireContext().unbindService(aidlServiceConnection)
        super.onDestroy()
    }

    override fun onClick(view: View) {
        aidlInterface?.let {
            val str = it.basicTypes(1, 2L, true, 3.14f, 6.66, "str")
            Toast.makeText(requireContext(), str, Toast.LENGTH_SHORT).show()
        }
    }

}