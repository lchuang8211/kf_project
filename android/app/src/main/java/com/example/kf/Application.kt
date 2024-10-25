package com.example.kf

import android.app.Application
import io.flutter.embedding.engine.FlutterEngineGroup

class MyApplication : Application() {
    lateinit var engineGroup: FlutterEngineGroup

    override fun onCreate() {
        super.onCreate()
        engineGroup = FlutterEngineGroup(this)
    }
}