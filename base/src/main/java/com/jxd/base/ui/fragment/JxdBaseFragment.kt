package com.jxd.base.ui.fragment

import android.content.Context
import androidx.fragment.app.Fragment

abstract class JxdBaseFragment : Fragment() {

    open val mContext: Context
        get() = requireContext()

    private var isOnShow: Boolean = false
    open val mIsOnShow: Boolean
        get() = isOnShow

    open fun onShow() {
        isOnShow = true
    }

    open fun onHide() {
        isOnShow = false
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            onHide()
        } else {
            onShow()
        }
    }

    override fun onResume() {
        super.onResume()
        onShow()
    }

    override fun onStop() {
        super.onStop()
        onHide()
    }
}