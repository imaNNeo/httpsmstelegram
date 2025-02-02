package com.httpsms

import android.content.Context
import timber.log.Timber


object Receiver {
    fun isValid(context: Context, messageId: String?): Boolean {
        if (messageId == null) {
            Timber.e("cannot handle event because the message ID is null")
            return false
        }

        if (!Settings.isLoggedIn(context)) {
            Timber.w("cannot handle message with id [$messageId] because the user is not logged in")
            return false
        }

        if (!Settings.getActiveStatus(context, Constants.SIM1) && !Settings.getActiveStatus(context, Constants.SIM2)) {
            Timber.w("cannot handle message with id [$messageId] because the user is not active")
            return false
        }
        return true
    }
}
