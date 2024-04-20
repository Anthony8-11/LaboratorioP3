public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de PersonaCRUD para interactuar con la base de datos
        PersonaCRUD personaCRUD = new PersonaCRUD();

        // Insertar personas
        personaCRUD.insertarPersona("Juan", 30, "Ciudad A");
        personaCRUD.insertarPersona("María", 25, "Ciudad B");

        // Mostrar personas
        System.out.println("Personas:");
        personaCRUD.mostrarPersonas();

        // Actualizar persona
        personaCRUD.actualizarPersona("Juan", "Juan Pérez");

        // Mostrar personas actualizadas
        System.out.println("\nPersonas después de la actualización:");
        personaCRUD.mostrarPersonas();

        // Eliminar persona
        personaCRUD.eliminarPersona("María");

        // Mostrar personas después de eliminar
        System.out.println("\nPersonas después de la eliminación:");
        personaCRUD.mostrarPersonas();
    }
}
