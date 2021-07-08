package com.sampleapp.common.logging

import timber.log.Timber

/**
 * Timber Tree which sends the logs to Crashlytics
 */
class TimberCrashlyticsTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (t != null) {
            //TODO: Crashlytics to be added
            //Crashlytics.logException(t)
        } else {
            //Crashlytics.log(priority, tag, message)
        }
    }
}
