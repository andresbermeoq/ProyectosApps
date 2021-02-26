import 'package:flutter/material.dart';
import 'package:proyectos_app/model/comentarios_model.dart';
import 'package:proyectos_app/providers/comentarios_provider.dart';

class CommentsPage extends StatelessWidget {

  static Route<dynamic> route(String mensaje) {
    return MaterialPageRoute(
      builder: (context) => CommentsPage(mensaje: mensaje),
    );
  }

  final String mensaje;

  const CommentsPage({Key key, @required this.mensaje}) : super(key: key);


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Comentarios'),
      ),
      body: _crearListado(),
      floatingActionButton: _crearBoton(context),
    );
  }

  Widget _crearListado() {
    final comentariosProvider = new ComentariosProvider();
    return FutureBuilder(
        future: comentariosProvider.cargarComentarios(),
        builder: (BuildContext context, AsyncSnapshot<List<ComentariosModel>> snapshot) {
          if(snapshot.hasData) {
            final comentarios = snapshot.data;
            return ListView.builder(
              itemCount: comentarios.length,
              itemBuilder: (context, i) => _crearItem(context, comentarios[i]),
              );
          } else {
            return Center(child: CircularProgressIndicator(),);
          }
        }
    );
  }

  _crearItem(BuildContext context, ComentariosModel comentario) {
    return ListTile(
      title: Text("${comentario.comentarioString}"),
      subtitle: Text("${comentario.persona.personaNombre}"),
    );
  }

  _crearBoton(BuildContext context) {
    return FloatingActionButton(
      child: Icon(Icons.add),
      onPressed: () => Navigator.pushNamed(context, 'Comentario'),
      backgroundColor: Colors.deepPurple,
    );
  }
}
