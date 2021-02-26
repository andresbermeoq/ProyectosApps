import 'package:flutter/material.dart';
import 'package:proyectos_app/pages/page_comment.dart';
import 'package:proyectos_app/pages/page_comments.dart';
import 'package:proyectos_app/pages/page_login.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "Proyectos App",
      initialRoute: "login",
      routes: {
        "login": (BuildContext context) => LoginPage(),
        "home": (BuildContext context) => CommentsPage(),
        "Comentario": (BuildContext context) => AddPage(),
      },
    );
  }
}
