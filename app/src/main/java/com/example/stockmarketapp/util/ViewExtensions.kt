package com.example.stockmarketapp.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * Created by Vazhapp on 17.08.2022
 */

inline fun <T : ViewBinding> ViewGroup.viewBinding(crossinline bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> T, attachToParent: Boolean = true) =
    bindingInflater.invoke(LayoutInflater.from(this.context), this, attachToParent)