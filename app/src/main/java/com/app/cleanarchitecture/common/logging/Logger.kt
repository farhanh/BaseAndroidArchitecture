package com.sampleapp.common.logging

import timber.log.Timber

/**
 * TODO: ideally we shouldn't need to specify the tag for Timber.
 * But having Timber wrapped in another class, causes it always to detect that wrapping class as the tag.
 * There are some PRs in their Github repo regarding this but those have never been accepted:
 * https://github.com/JakeWharton/timber/pull/314
 **/
@Suppress("SpreadOperator")
class Logger : ILogger {
    override fun v(tag: String, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.v(message, *args)
    }

    override fun v(tag: String, t: Throwable, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.v(t, message, args)
    }

    override fun v(tag: String, t: Throwable) {
        Timber.tag(tag)
        Timber.v(t)
    }

    override fun d(tag: String, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.d(message, *args)
    }

    override fun d(tag: String, t: Throwable, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.d(t, message, *args)
    }

    override fun d(tag: String, t: Throwable) {
        Timber.tag(tag)
        Timber.d(t)
    }

    override fun i(tag: String, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.i(message, *args)
    }

    override fun i(tag: String, t: Throwable, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.i(t, message, *args)
    }

    override fun i(tag: String, t: Throwable) {
        Timber.tag(tag)
        Timber.i(t)
    }

    override fun w(tag: String, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.w(message, *args)
    }

    override fun w(tag: String, t: Throwable, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.w(t, message, *args)
    }

    override fun w(tag: String, t: Throwable) {
        Timber.tag(tag)
        Timber.w(t)
    }

    override fun e(tag: String, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.e(message, *args)
    }

    override fun e(tag: String, t: Throwable, message: String, vararg args: Any) {
        Timber.tag(tag)
        Timber.e(t, message, *args)
    }

    override fun e(tag: String, t: Throwable) {
        Timber.tag(tag)
        Timber.e(t)
    }
}
