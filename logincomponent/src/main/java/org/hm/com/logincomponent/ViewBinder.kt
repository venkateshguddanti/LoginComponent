package org.hm.com.logincomponent

import android.databinding.BindingAdapter
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
@BindingAdapter("onClick")
    fun bindOnClick( view: View,listener : View.OnClickListener)
    {
        view.setOnClickListener(listener)
    }
@BindingAdapter("textChangedListener")
    fun bindTextWatcher(editText: EditText,textWatcher: TextWatcher)
{
    editText.addTextChangedListener(textWatcher)
}
