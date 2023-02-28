package com.example.everfittest.utils

import android.util.Log

object LogUtil {

    fun e(info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.e(Constant.TAG, infos.toString())
        }
    }

    fun d(info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.d(Constant.TAG, infos.toString())
        }
    }

    fun i(info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.i(Constant.TAG, infos.toString())
        }
    }

    fun w(info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.w(Constant.TAG, infos.toString())
        }
    }

    fun v(info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.v(Constant.TAG, infos.toString())
        }
    }

    private fun getFileLineMethod(): String {
        val traces = Throwable().stackTrace
        val traceElement = traces[2]
        val toStringBuffer = StringBuilder("[")
            .append(traceElement.fileName).append(" | ")
            .append(traceElement.lineNumber).append(" | ")
            .append(traceElement.methodName).append("()").append("]")
        return toStringBuffer.toString()
    }
}