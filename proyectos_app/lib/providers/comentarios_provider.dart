
import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:proyectos_app/model/comentarios_model.dart';

class ComentariosProvider {
  final String _url = "http://localhost:8080/ProyectosExamen/rest/comentarios";

  Future<List<ComentariosModel>> cargarComentarios() async {
    final url = "$_url/all";
    final response = await http.get(url);
    final jsonData = jsonDecode(response.body);
    final List<ComentariosModel> comentarios = new List();

    if (jsonData == null) return [];

    for(var item in jsonData ){
      final comentarioTemp = ComentariosModel.fromJson(item);
      comentarios.add(comentarioTemp);
    }
    return comentarios;
  }

}