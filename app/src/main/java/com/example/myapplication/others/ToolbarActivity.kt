package com.example.myapplication.others

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.myapplication.model.IToolbar

open class ToolbarActivity : AppCompatActivity(), IToolbar {
    protected var _toolbar: Toolbar? = null
    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let { setActionBar(toolbar) }
    }

    override fun enableHomeDisplay(value: Boolean) {
        actionBar?.setDisplayHomeAsUpEnabled(value)
    }


}
