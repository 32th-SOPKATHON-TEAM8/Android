package com.example.sopthactaton.util

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun arePermissionsGranted(permissions: Array<String>,context: Context): Boolean {
    return permissions.all {
        ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }
}