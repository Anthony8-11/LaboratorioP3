import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class PersonaCRUD {
    private MongoCollection<Document> personasCollection;

    public PersonaCRUD() {
        MongoDatabase database = MongoDBConnection.getDatabase();
        personasCollection = database.getCollection("personas");
    }

    public void insertarPersona(String nombre, int edad, String ciudad) {
        Document persona = new Document("nombre", nombre)
                .append("edad", edad)
                .append("ciudad", ciudad);
        personasCollection.insertOne(persona);
        System.out.println("Persona insertada correctamente:");
        imprimirPersona(persona);
        System.out.println("-------------------------------");
    }

    public void mostrarPersonas() {
        System.out.println("Listado de personas:");
        for (Document persona : personasCollection.find()) {
            imprimirPersona(persona);
        }
        System.out.println("-------------------------------");
    }

    public void actualizarPersona(String nombreActual, String nuevoNombre) {
        personasCollection.updateOne(Filters.eq("nombre", nombreActual),
                Updates.set("nombre", nuevoNombre));
        System.out.println("Persona actualizada correctamente.");
        System.out.println("-------------------------------");
    }

    public void eliminarPersona(String nombre) {
        personasCollection.deleteOne(Filters.eq("nombre", nombre));
        System.out.println("Persona eliminada correctamente.");
        System.out.println("-------------------------------");
    }

    private void imprimirPersona(Document persona) {
        System.out.println("Nombre: " + persona.getString("nombre"));
        System.out.println("Edad: " + persona.getInteger("edad"));
        System.out.println("Ciudad: " + persona.getString("ciudad"));
        System.out.println();
    }
}
