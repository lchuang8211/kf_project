package com.example.kf.flutter

import android.content.Context
import com.example.kf.MyApplication
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.FlutterEngineGroup
import io.flutter.embedding.engine.dart.DartExecutor

object FlutterEngineManager {
    fun flutterEngine(context: Context, engineId: String, enginePoint: String): FlutterEngine {
        var engine = FlutterEngineCache.getInstance().get(engineId)
        if (engine == null) {

            // 新建 FlutterEngine, 執行的入口函數 = entryPoint
            val app = context.applicationContext as MyApplication
            val dartEntryPoint = DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), enginePoint)

            engine = app.engineGroup.createAndRunEngine(context, dartEntryPoint)

            // 儲存快取
            FlutterEngineCache.getInstance().put(engineId, engine)
        }

        return engine!!
    }
}