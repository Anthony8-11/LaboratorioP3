import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String DATABASE_NAME = "BenitoJuarez"; // Nombre de la base de datos

    public static MongoClient connect() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017"); // Cambia localhost y puerto si es necesario
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(settings);
    }

    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = connect();
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
