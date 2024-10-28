package com.example.kf

import android.app.Application
import com.example.kf.flutter.FlutterEngineManager
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngineGroup

class MyApplication : Application() {
    lateinit var engineGroup: FlutterEngineGroup

    override fun onCreate() {
        super.onCreate()
        println("MyApplication.onCreate")
        // 初始化 Flutter
        FlutterInjector.instance().flutterLoader().startInitialization(this)
        engineGroup = FlutterEngineGroup(this)
        FlutterEngineManager.initialize(this)
    }
}