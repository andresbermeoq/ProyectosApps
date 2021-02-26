import 'dart:convert';

ComentariosModel comentariosModelFromJson(String str) => ComentariosModel.fromJson(json.decode(str));

String comentariosModelToJson(ComentariosModel data) => json.encode(data.toJson());

class ComentariosModel {
  ComentariosModel({
    this.comentarioId,
    this.comentarioString,
    this.persona,
  });

  int comentarioId;
  String comentarioString;
  Persona persona;

  factory ComentariosModel.fromJson(Map<String, dynamic> json) => ComentariosModel(
    comentarioId: json["comentarioId"],
    comentarioString: json["comentarioString"],
    persona: Persona.fromJson(json["persona"]),
  );

  Map<String, dynamic> toJson() => {
    "comentarioId": comentarioId,
    "comentarioString": comentarioString,
    "persona": persona.toJson(),
  };
}

class Persona {
  Persona({
    this.personaEmail,
    this.personaId,
    this.personaNombre,
    this.personaPassword,
  });

  String personaEmail;
  int personaId;
  String personaNombre;
  String personaPassword;

  factory Persona.fromJson(Map<String, dynamic> json) => Persona(
    personaEmail: json["personaEmail"],
    personaId: json["personaId"],
    personaNombre: json["personaNombre"],
    personaPassword: json["personaPassword"],
  );

  Map<String, dynamic> toJson() => {
    "personaEmail": personaEmail,
    "personaId": personaId,
    "personaNombre": personaNombre,
    "personaPassword": personaPassword,
  };
}
