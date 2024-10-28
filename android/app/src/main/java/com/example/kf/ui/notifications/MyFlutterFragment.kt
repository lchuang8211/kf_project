package com.example.kf.ui.notifications

import android.os.Bundle
import com.example.kf.flutter.FlutterEngineManager
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.RenderMode

class MyFlutterFragment : FlutterFragment() {
    companion object {
        fun newInstance(): MyFlutterFragment {
            val ENGINE_ID = "flutter_notification"
            val ENTRY_POINT = "/notifications"

            FlutterEngineManager.flutterEngine(engineId = ENGINE_ID, enginePoint = ENTRY_POINT)

            return withCachedEngine(ENGINE_ID)
                .renderMode(RenderMode.surface)
                .build()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("MyFlutterFragment.onCreate")
    }
}