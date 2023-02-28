package com.example.everfittest.utils.exts

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun View.onClickListenerDelay(event: () -> Unit) {
    this.setOnClickListener {
        isEnabled = false
        event.invoke()
        postDelayed({ isEnabled = true }, 500)
    }
}


/**
 * Change visibility of view to Visible
 *
 * @param view view need to change visibility
 */
fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.VISIBLE
}


/**
 * Change visibility of view to Visible
 *
 * @param view view need to change visibility
 */
fun View.hide() {
    this.visibility = View.GONE
}

/**
 * Show toast
 *
 * @param CharSequence context
 */
fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


fun View.hideKeyboard(): Boolean {
    try {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    } catch (ignored: RuntimeException) {
    }
    return false
}

fun View.showSnackbar(snackbarText: String, timeLength: Int) {
    Snackbar.make(this, snackbarText, timeLength).show()
}





