package com.example.everfittest.dialogManager

import android.app.ProgressDialog
import android.content.Context
import java.lang.ref.WeakReference

class DialogManagerImpl(ctx: Context?) : DialogManager {

    private var context: WeakReference<Context?>? = null
    private var progressDialog: ProgressDialog? = null

    init {
        context = WeakReference(ctx).apply {
            progressDialog = ProgressDialog(this.get()!!)
        }
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun hideLoading() {
        progressDialog?.dismiss()
    }

    override fun onRelease() {
        progressDialog = null
    }
}