package com.peerless2012.service.aidl.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.peerless2012.service.aidl.R

/**
 * @Author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2022/6/15 16:54
 * @Version V1.0
 * @Description:
 */
class AIDLFragment : Fragment(R.layout.fragment_aidl), View.OnClickListener {

    private lateinit var sendLargeDataBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        super.onDestroy()
    }

    override fun onClick(view: View) {
    }

}