import java.io.File; // Función para manejar archivos físicos
import java.util.Scanner; // Función para entrada de datos por consola

/** Pedro Segovia - 21672694-4
 *  Valentina - tu ruu
 * 
 * 
 */



public class TallerProgra {
  
    public static void main(String[] args) {
        // Vectores para almacenar datos de usuarios (Requerimiento: No colecciones)
        //String[] vectorNombre;
        //String[] vectorContraseña;
        
        System.out.println("Este es el Metodo Principal");
        SalidPantalla();
    }

    /**
     * Despliega el menú principal del sistema por consola.
     */
    public static void SalidPantalla() {
        String menu = "1) Menu de Usuarios \n2) Menu de Analisis \n3) Salir";
        System.out.println(menu);
        int seleccion = obtenerOpcion();
        clasificador(seleccion);
    }

    /**
     * Captura y valida la opción ingresada por el usuario.
     * @return int Opción seleccionada validada entre 1 y 3.
     */
    public static int obtenerOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean esValido = false;

        // Bucle de validación para evitar errores de ejecución (Robustez)
        while (!esValido) {
            try {
                System.out.print("Seleccione una opción (1-3): ");
                opcion = Integer.parseInt(sc.nextLine());
                
                if (opcion >= 1 && opcion <= 3) {
                    esValido = true;
                } else {
                    System.out.println("Error: Debe elegir entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: ¡Debes ingresar un número!");
            }
        }
        return opcion;
    }

    /**
     * Redirige el flujo del programa según la opción del menú principal.
     */
    public static void clasificador(int variable) {
        if (variable == 1) {
            MenuUsuarios();
        } else if (variable == 2) {
            MenuAnalisis();
        } else {
            Salida();
        }
    }

    /**
     * Gestiona el acceso al sistema solicitando credenciales de usuario.
     */
    public static void MenuUsuarios() {
        Scanner sc = new Scanner(System.in); // Se requiere para capturar los strings
        System.out.println("Menu Usuarios");
        System.out.println("Ingrese nombre:");
        String nombreUsuario = sc.nextLine();
        System.out.println("Contraseña: ");
        String contraseñaUsuario = sc.nextLine();
        
        // Llama a la validación de archivos con las credenciales ingresadas
        LecturaArchivosUsuarios(nombreUsuario, contraseñaUsuario);
    }

    /**
     * Despliega las opciones para el análisis de métricas de procrastinación.
     */
    public static void MenuAnalisis() {
        System.out.println("Menu analisis...");
    }

    /**
     * Realiza la carga de datos desde 'Usuarios.txt' y verifica credenciales.
     * Implementa la lógica de parsing mediante split por ';'.
     * @param Nombre1 Nombre de usuario a verificar.
     * @param Contraseña1 Contraseña a verificar.
     */
    public static void LecturaArchivosUsuarios(String Nombre1, String Contraseña1) {
        System.out.println("Leyendo Archivos....");
        
        try {
            File file = new File("Usuarios.txt");
            Scanner scanner = new Scanner(file);
            
            // Recorrido del archivo línea por línea
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                // Separación de datos según formato CSV (ID;Contraseña)
                String[] Partes = linea.split(";");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Finaliza la ejecución del programa.
     */
    public static void Salida() {
        System.out.println("Chao Nos vemos");
    }
}