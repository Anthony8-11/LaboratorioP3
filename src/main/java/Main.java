public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de PersonaCRUD para interactuar con la base de datos
        PersonaCRUD personaCRUD = new PersonaCRUD();

        // Insertar personas
        personaCRUD.insertarPersona("Yeison", 30, "Jutiapa");
        personaCRUD.insertarPersona("Martin", 25, "Guatemala");
        personaCRUD.insertarPersona("ElEx", 35, "Cuba");
        personaCRUD.insertarPersona("Benito", 50, "Rusia");


        // Mostrar personas
        System.out.println("Personas:");
        personaCRUD.mostrarPersonas();

        // Actualizar persona
        personaCRUD.actualizarPersona("Yeison", "Yeison López");

        // Mostrar personas actualizadas
        System.out.println("\nPersonas después de la actualización:");
        personaCRUD.mostrarPersonas();

        // Eliminar persona
        personaCRUD.eliminarPersona("ElEx");

        // Mostrar personas después de eliminar
        System.out.println("\nPersonas después de la eliminación:");
        personaCRUD.mostrarPersonas();
    }
}
