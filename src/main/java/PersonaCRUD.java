import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;



    public class PersonaCRUD {
        private MongoCollection<Document> personasCollection; // Colección MongoDB para almacenar personas

        // Constructor de la clase PersonaCRUD
        public PersonaCRUD() {
            // Obtenemos la instancia de la base de datos MongoDB
            MongoDatabase database = MongoDBConnection.getDatabase();
            // Obtenemos la colección "personas" de la base de datos
            personasCollection = database.getCollection("personas");
        }

        // Método para insertar una nueva persona en la colección
        public void insertarPersona(String nombre, int edad, String ciudad) {
            // Creamos un nuevo documento para la persona con los campos nombre, edad y ciudad
            Document persona = new Document("nombre", nombre)
                    .append("edad", edad)
                    .append("ciudad", ciudad);
            // Insertamos el documento en la colección
            personasCollection.insertOne(persona);
            // Mostramos la persona insertada
            System.out.println("Persona insertada correctamente:");
            imprimirPersona(persona);
            // Mostramos el resultado de la operación de inserción
            System.out.println("-------------------------------");
            if (personasCollection.countDocuments(persona) == 1) {
                System.out.println("Operación de inserción completada correctamente.");
            } else {
                System.out.println("Error: La operación de inserción no se ha completado correctamente.");
            }
        }

        // Método para mostrar todas las personas en la colección
        public void mostrarPersonas() {
            // Mostramos un encabezado
            System.out.println("Listado de personas:");
            // Iteramos sobre todos los documentos en la colección y los mostramos
            for (Document persona : personasCollection.find()) {
                imprimirPersona(persona);
            }
            // Mostramos el resultado de la operación de lectura
            System.out.println("-------------------------------");
            System.out.println("Operación de lectura completada correctamente.");
        }

        // Método para actualizar el nombre de una persona en la colección
        public void actualizarPersona(String nombreActual, String nuevoNombre) {
            // Actualizamos el nombre de la persona que coincida con el nombre actual especificado
            personasCollection.updateOne(Filters.eq("nombre", nombreActual),
                    Updates.set("nombre", nuevoNombre));
            // Mostramos el resultado de la operación de actualización
            System.out.println("Persona actualizada correctamente.");
            System.out.println("-------------------------------");
            if (personasCollection.countDocuments(Filters.eq("nombre", nuevoNombre)) == 1) {
                System.out.println("Operación de actualización completada correctamente.");
            } else {
                System.out.println("Error: La operación de actualización no se ha completado correctamente.");
            }
        }

        // Método para eliminar una persona de la colección
        public void eliminarPersona(String nombre) {
            // Eliminamos la persona que coincida con el nombre especificado
            personasCollection.deleteOne(Filters.eq("nombre", nombre));
            // Mostramos el resultado de la operación de eliminación
            System.out.println("Persona eliminada correctamente.");
            System.out.println("-------------------------------");
            if (personasCollection.countDocuments(Filters.eq("nombre", nombre)) == 0) {
                System.out.println("Operación de eliminación completada correctamente.");
            } else {
                System.out.println("Error: La operación de eliminación no se ha completado correctamente.");
            }
        }

        // Método auxiliar para imprimir los detalles de una persona
        private void imprimirPersona(Document persona) {
            System.out.println("Nombre: " + persona.getString("nombre"));
            System.out.println("Edad: " + persona.getInteger("edad"));
            System.out.println("Ciudad: " + persona.getString("ciudad"));
            System.out.println();
        }
    }
