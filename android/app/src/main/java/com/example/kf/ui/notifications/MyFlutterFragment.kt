package com.example.kf.ui.notifications

import android.os.Bundle
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.RenderMode

class MyFlutterFragment: FlutterFragment() {
    companion object {
        fun newInstance(): MyFlutterFragment {
            // 使用已存在的 cached Engine
            return withCachedEngine("flutter_notification")
                .renderMode(RenderMode.surface)
                .build() as MyFlutterFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("MyFlutterFragment.onCreate")
    }
}