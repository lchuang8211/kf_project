package com.example.kf.flutter

import android.app.Application
import android.content.Context
import com.example.kf.MyApplication
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

object FlutterEngineManager {
    private lateinit var applicationContext: Context

    // 初始化方法，在Application onCreate時調用
    fun initialize(application: Application) {
        applicationContext = application.applicationContext
    }

    fun flutterEngine(engineId: String, enginePoint: String): FlutterEngine {
        if (!::applicationContext.isInitialized) {
            throw IllegalStateException("FlutterEngineManager must be initialized before use")
        }

        var engine = FlutterEngineCache.getInstance().get(engineId)
        if (engine == null) {

            // 新建 FlutterEngine, 執行的入口函數 = entryPoint
            val app = applicationContext.applicationContext as MyApplication
            val dartEntryPoint = DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), enginePoint)

            engine = app.engineGroup.createAndRunEngine(applicationContext, dartEntryPoint)

            // 儲存快取
            FlutterEngineCache.getInstance().put(engineId, engine)
        }

        return engine!!
    }

    // 可選：清理方法
    fun clearEngine(engineId: String) {
        FlutterEngineCache.getInstance().remove(engineId)
    }

    // 可選：檢查engine是否存在
    fun hasEngine(engineId: String): Boolean {
        return FlutterEngineCache.getInstance().contains(engineId)
    }
}