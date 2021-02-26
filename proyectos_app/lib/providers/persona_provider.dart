
import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:proyectos_app/model/usuario_remoto_model.dart';

class PersonaProvider {
  final String _url = "http://localhost:8080/ProyectosExamen/rest/users";

  Future<bool> loginUser(UsuarioRemoto usuarioRemoto) async {
    final url = "$_url/login";
    final response = await http.post(url, body: usuarioRemotoToJson(usuarioRemoto));
    print(response.body);

  }

  Future nuevoUsuario(String email, String password) async {
    final url = "$_url/login";

    final authData = {
      "email" : email,
      "password" : password
    };

    final response = await http.post(url, body: authData);
    print(authData);
    final jsonData = jsonDecode(response.body);
    print(jsonData);


  }

}