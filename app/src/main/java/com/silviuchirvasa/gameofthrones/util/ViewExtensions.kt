package com.silviuchirvasa.gameofthrones.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// Extend ViewGroup to allow it inflate layouts
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}