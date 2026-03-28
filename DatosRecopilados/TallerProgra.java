import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner; // Funcion de Inpus

/** Pedro Segovia - 21672694-4
 *  Valentina Castillo- 15.166.692-2
 * 
 * 
 */

public class TallerProgra {


    // MAIN PRINCIPAL
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
       System.out.print("Seleccione una opción (1-3): ");
        Scanner sc = new Scanner(System.in);
        
        
        int seleccion =sc.nextInt(); 
        clasificador(seleccion);
        sc.close();
    }
    /**
     * Captura y valida la opción ingresada por el usuario.
     * @return int Opción seleccionada validada entre 1 y 3.
     */

    
    /**
     * Redirige el flujo del programa según la opción del menú principal.
     */

    public static void clasificador(int variable) {
        if (variable == 1) {
            try {
				MenuUsuarios();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
        
        else if (variable == 2) {
            MenuAnalisis();

        } 
        
        else {
            Salida();
        
        }

    }
    /**
     * Gestiona el acceso al sistema solicitando credenciales de usuario.
     */



    public static void MenuUsuarios() throws FileNotFoundException {
    
    	Scanner s= new Scanner(System.in);
        System.out.println("Menu Usuarios");
        System.out.println("Ingrese nombre:");
        String nombreUsuario=s.nextLine();
        System.out.println("Contraseña: ");
        String contraseñaUsuario=s.nextLine();
     // Llama a la validación de archivos con las credenciales ingresadas
        String Nombre=LecturaArchivosUsuarios(nombreUsuario,contraseñaUsuario);
        
        System.out.println("Bienvenido " + Nombre);
        
        System.out.println("Que deseas realizar?");
        System.out.println();
        System.out.println("1) Registrar actividad.");
        System.out.println("2) Modificar actividad.");
        System.out.println("3)Eliminar actividad.");
        System.out.println("4)Cambiar contraseña.");
        System.out.println("5)Salir.");
		System.out.println();
        int Expression=s.nextInt();
        
        switch(Expression){
        	case 1:
        		registrarActividad();
        		break;
        	case 2:
        		modificaActividad();
        		break;
        	case 3:
        		break;
        	case 4:
        		break;
        	case 5:
        		break;
        	default:
        		System.out.println("Equivocado, intente otra vez");
        		
        	
        }  s.close();
        
        
    
    }

    private static void modificaActividad() throws FileNotFoundException {
		// TODO Auto-generated method stub
    	System.out.println("Cual actividad deseas modificar?");
    	File archivo= new File("Registros.txt");
		
		Scanner scaner=new Scanner(archivo);
		int conteo= 0;
		String datoModificar = null;
		
		
		String[]  listaID=new String[200];
    	String[]  listaFecha=new String[200];
    	String[]  listaHoras=new String[200];
    	String[]  listaActividad=new String[200];
		
		while(scaner.hasNextLine()) {
			String linea=scaner.nextLine();
			String[] Partes=linea.split(";");
			String Id=Partes[0];
			String Fecha=Partes[1];
			String Horas=Partes[2];
			String Actividad=Partes[3];
			System.out.println(linea);
			listaID[conteo]=Id;
			listaFecha[conteo]=Fecha;
			listaHoras[conteo]=Horas;
			listaActividad[conteo]=Actividad;
			
			
			
			conteo++;	
			
		}scaner.close();
		 Scanner d= new Scanner(System.in);
	    	String Dotmodif=d.nextLine();
	        
	        int Seleccion=d.nextInt();
	        /*
	        for(int i=0;i<conteo;i++ ) {
	        	if(listaID[i].equals(Dotmodif)) {
	        		 datoModificar=listaID[i];
	        		
	        	}
	        	
	        }
	        */

	        switch(Seleccion){
	            case 1:
	                break;
	            case 2:
	            	System.out.println("0) Regresar.");
	            	System.out.println("Ingrese nueva Fecha: ");
	            	String nuevaFecha=d.nextLine();
	            	
	                modificar(Dotmodif,nuevaFecha,listaFecha);
	                System.out.println("Fecha  modificada con exito!");
	                break;
	            case 3:
	            	
	                break;
	            case 4:
	                break;
		
    	
    	
    	
    	
		
	}


	private static String[]  modificar(String Dotmo, String nuevaFechas, String[] treslistaFecha) {
		// TODO Auto-generated method stub
		int conteo = treslistaFecha.length;
		//int  cont=Integer.parseInt(Dotmo);
		for(int i=0;i<conteo;i++ ) {
        	if(treslistaFecha[i].equals(Dotmo)) {
        		treslistaFecha[i]= nuevaFechas;		
        			}
			}
		return treslistaFecha;
	}


	private static void registrarActividad() {
		// TODO Auto-generated method stub
		
	}
	

	 /**
     * Despliega las opciones para el análisis de métricas de procrastinación.
     */

	public static void MenuAnalisis() {
    
        System.out.println("Menu analisis...");
        System.out.println();
        System.out.println("Bienvenido al menu de analisis!");
        System.out.println();
        System.out.println("");
        
    
    }
	 /**
     * Realiza la carga de datos desde 'Usuarios.txt' y verifica credenciales.
     * Implementa la lógica de parsing mediante split por ';'.
     * @param Nombre1 Nombre de usuario a verificar.
     * @param Contraseña1 Contraseña a verificar.
     */

    public static String  LecturaArchivosUsuarios(String Usuariouno, String Contrasenauno ) {
    	
    	
    	System.out.println("Leyendo Archivos....");
    	String[] Usuariosinscritos=new String[100];
    	String[] Contraseñainscritos=new String[100];
        
        
       
        int cont=0;
        String nombreCorrecto="";
        
		try {
			File file= new File("Usuarios.txt");
			 Scanner scanner = new Scanner (file);
		
		// Recorrido del archivo línea por línea
        while (scanner.hasNextLine()){
		        String linea=scanner.nextLine();
		     // Separación de datos según formato CSV (ID;Contraseña)
		        String[] Partes=linea.split(";");
		        
		        String Usuario= Partes[0];
		        Usuariosinscritos[cont]=Usuario;
		        
		        Contraseñainscritos[cont]=Partes[1];
        } scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        for(int i=0;i< cont; i++){
		        if (Usuariosinscritos[i].equals(Usuariouno) && Contraseñainscritos[i].equals(Contrasenauno)){
					System.out.println("Acceso correcto!");
					 nombreCorrecto=Usuariosinscritos[i];
		}else {
			System.out.println("Error");
			}
        
        }
        return  nombreCorrecto;
        
    }
    /**
     * Finaliza la ejecución del programa.
     */
		    
    public static void Salida() {
    
        System.out.println("Chao Nos vemos");
    
    	}
  
    


}
