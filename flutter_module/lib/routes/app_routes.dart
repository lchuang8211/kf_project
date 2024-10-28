import 'package:flutter/cupertino.dart';
import 'package:flutter_module/home/home_page.dart';
import 'package:flutter_module/notification/notification_page.dart';

enum AppRoutes {
  home,
  notificationsFragment,
}

extension AppRoutesExtension on AppRoutes {
  String get route {
    switch (this) {
      case AppRoutes.home:
        return '/';
      case AppRoutes.notificationsFragment:
        return '/notifications';
      default:
        return '/';
    }
  }
}

Map<String, Widget Function(BuildContext)> appRoutes = {
  AppRoutes.home.route: (context) => const MyHomePage(title: 'Flutter Demo Home Page'),
  AppRoutes.notificationsFragment.route: (context) => const NotificationPage(),
};