package com.sampleapp.common.logging

interface ILogger {
    /** Log a verbose message with optional format args.  */
    fun v(tag: String, message: String, vararg args: Any)

    /** Log a verbose exception and a message with optional format args.  */
    fun v(tag: String, t: Throwable, message: String, vararg args: Any)

    /** Log a verbose exception.  */
    fun v(tag: String, t: Throwable)

    /** Log a debug message with optional format args.  */
    fun d(tag: String, message: String, vararg args: Any)

    /** Log a debug exception and a message with optional format args.  */
    fun d(tag: String, t: Throwable, message: String, vararg args: Any)

    /** Log a debug exception.  */
    fun d(tag: String, t: Throwable)

    /** Log an info message with optional format args.  */
    fun i(tag: String, message: String, vararg args: Any)

    /** Log an info exception and a message with optional format args.  */
    fun i(tag: String, t: Throwable, message: String, vararg args: Any)

    /** Log an info exception.  */
    fun i(tag: String, t: Throwable)

    /** Log a warning message with optional format args.  */
    fun w(tag: String, message: String, vararg args: Any)

    /** Log a warning exception and a message with optional format args.  */
    fun w(tag: String, t: Throwable, message: String, vararg args: Any)

    /** Log a warning exception.  */
    fun w(tag: String, t: Throwable)

    /** Log an error message with optional format args.  */
    fun e(tag: String, message: String, vararg args: Any)

    /** Log an error exception and a message with optional format args.  */
    fun e(tag: String, t: Throwable, message: String, vararg args: Any)

    /** Log an error exception.  */
    fun e(tag: String, t: Throwable)
}
