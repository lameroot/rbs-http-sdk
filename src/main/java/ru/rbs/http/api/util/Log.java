package ru.rbs.http.api.util;


public final class Log {

    private static final String TAG = "Yandex.Money";

    private static Logger logger;

    private Log() {
    }

    /**
     * Sets a logger to use.
     *
     * @param logger logger to use
     */
    public static void setLogger(Logger logger) {
        Log.logger = logger;
    }

    /**
     * Gets current logger.
     *
     * @return logger
     */
    public static Logger getLogger() {
        return logger == null ? DefaultLogger.getInstance() : logger;
    }

    /**
     * Send a debug log message using default tag.
     *
     * @param msg message
     */
    public static void d(String msg) {
        d(TAG, msg);
    }

    /**
     * Send a debug log message.
     *
     * @param tag tag
     * @param msg message
     */
    public static void d(String tag, String msg) {
        getLogger().d(tag, msg);
    }

    /**
     * Send a debug log message and log the exception using default tag.
     *
     * @param msg message
     * @param tr exception
     */
    public static void d(String msg, Throwable tr) {
        d(TAG, msg, tr);
    }

    /**
     * Send a debug log message and log the exception.
     *
     * @param tag tag
     * @param msg message
     * @param tr exception
     */
    public static void d(String tag, String msg, Throwable tr) {
        getLogger().d(tag, msg, tr);
    }

    /**
     * Send an error log message using default tag.
     *
     * @param msg message
     */
    public static void e(String msg) {
        e(TAG, msg);
    }

    /**
     * Send an error log message.
     *
     * @param tag tag
     * @param msg message
     */
    public static void e(String tag, String msg) {
        getLogger().e(tag, msg);
    }


    /**
     * Send an error log message and log the exception using default tag.
     *
     * @param msg message
     * @param tr exception
     */
    public static void e(String msg, Throwable tr) {
        e(TAG, msg, tr);
    }
    /**
     * Send an error log message and log the exception.
     *
     * @param tag tag
     * @param msg message
     * @param tr exception
     */
    public static void e(String tag, String msg, Throwable tr) {
        getLogger().e(tag, msg, tr);
    }

    /**
     * Send an info log message using default tag.
     *
     * @param msg message
     */
    public static void i(String msg) {
        i(TAG, msg);
    }

    /**
     * Send an info log message.
     *
     * @param tag tag
     * @param msg message
     */
    public static void i(String tag, String msg) {
        getLogger().i(tag, msg);
    }

    /**
     * Send an info log message and log the exception using default tag.
     *
     * @param msg message
     * @param tr exception
     */
    public static void i(String msg, Throwable tr) {
        i(TAG, msg, tr);
    }

    /**
     * Send an info log message and log the exception.
     *
     * @param tag tag
     * @param msg message
     * @param tr exception
     */
    public static void i(String tag, String msg, Throwable tr) {
        getLogger().i(tag, msg, tr);
    }

    /**
     * Send a verbose log message using default tag.
     *
     * @param msg message
     */
    public static void v(String msg) {
        v(TAG, msg);
    }

    /**
     * Send a verbose log message.
     *
     * @param tag tag
     * @param msg message
     */
    public static void v(String tag, String msg) {
        getLogger().v(tag, msg);
    }

    /**
     * Send a verbose log message and log the exception using default tag.
     *
     * @param msg message
     * @param tr exception
     */
    public static void v(String msg, Throwable tr) {
        v(TAG, msg, tr);
    }

    /**
     * Send a verbose log message and log the exception.
     *
     * @param tag tag
     * @param msg message
     * @param tr exception
     */
    public static void v(String tag, String msg, Throwable tr) {
        getLogger().v(tag, msg, tr);
    }

    /**
     * Send a warning log message using default tag.
     *
     * @param msg message
     */
    public static void w(String msg) {
        w(TAG, msg);
    }

    /**
     * Send a warning log message.
     *
     * @param tag tag
     * @param msg message
     */
    public static void w(String tag, String msg) {
        getLogger().w(tag, msg);
    }

    /**
     * Send a warning log message and log the exception using default tag.
     *
     * @param msg message
     * @param tr exception
     */
    public static void w(String msg, Throwable tr) {
        w(TAG, msg, tr);
    }

    /**
     * Send a warning log message and log the exception.
     *
     * @param tag tag
     * @param msg message
     * @param tr exception
     */
    public static void w(String tag, String msg, Throwable tr) {
        getLogger().w(tag, msg, tr);
    }
}
