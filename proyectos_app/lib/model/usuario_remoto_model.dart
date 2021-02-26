import 'dart:convert';

UsuarioRemoto usuarioRemotoFromJson(String str) => UsuarioRemoto.fromJson(json.decode(str));

String usuarioRemotoToJson(UsuarioRemoto data) => json.encode(data.toJson());

class UsuarioRemoto {
  UsuarioRemoto({
    this.email,
    this.password,
  });

  String email;
  String password;

  factory UsuarioRemoto.fromJson(Map<String, dynamic> json) => UsuarioRemoto(
    email: json["email"],
    password: json["password"],
  );

  Map<String, dynamic> toJson() => {
    "email": email,
    "password": password,
  };
}
