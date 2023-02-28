package com.example.everfittest.utils.exts

import android.widget.EditText

val EditText.value
    get() = text.toString()