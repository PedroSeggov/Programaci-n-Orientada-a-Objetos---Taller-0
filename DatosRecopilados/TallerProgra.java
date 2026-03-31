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
    public static void main(String[] args) throws FileNotFoundException {
    	 // Vectores para almacenar datos de usuarios (Requerimiento: No colecciones)
        //String[] vectorNombre;
        //String[] vectorContraseña;
    	String[]  listaID=new String[300];
    	String[]  listaFecha=new String[300];
    	String[]  listaHoras=new String[300];
    	String[]  listaActividad=new String[300];
    	
        System.out.println("Este es el Metodo Principal");
        SalidPantalla(listaID,listaFecha,listaHoras,listaActividad);
    }
 

    /**
     * Despliega el menú principal del sistema por consola.
     * @param clistaActividad 
     * @param clistaHoras 
     * @param clistaFecha 
     * @param clistaID 
     * @throws FileNotFoundException 
     */

    public static void SalidPantalla(String[] clistaID, String[] clistaFecha, String[] clistaHoras, String[] clistaActividad) throws FileNotFoundException {
        String menu = "1) Menu de Usuarios \n2) Menu de Analisis \n3) Salir";
        System.out.println(menu);
        System.out.print("Seleccione una opción (1-3): ");
        Scanner sc = new Scanner(System.in);
        
        
        int seleccion =sc.nextInt(); 
        clasificador(seleccion,clistaID,clistaFecha,clistaHoras,clistaActividad);
      
    }
    /**
     * Captura y valida la opción ingresada por el usuario.
     * @param opcion2 
     * @return int Opción seleccionada validada entre 1 y 3.
     */

   
    /**
     * Redirige el flujo del programa según la opción del menú principal.
     * @throws FileNotFoundException 
     */

    public static void clasificador(int variable,String[] ListaID,String[] ListaFecha,String[] ListaHoras,String[] ListaActividad) throws FileNotFoundException {
        if (variable == 1) {
            
				MenuUsuarios( ListaID, ListaFecha, ListaHoras,ListaActividad);
			
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



    public static void MenuUsuarios(String[] flistaID,String[] flistaFecha,String[] flistaHoras,String[] flistaActividad) throws FileNotFoundException {
    	boolean Nombre = false;
    	Scanner s= new Scanner(System.in);
        System.out.println("Menu Usuarios");
        System.out.println();
        System.out.print("Ingrese nombre:");
        String nombreUsuario=s.nextLine();
        System.out.print("Contraseña: ");
        String contraseñaUsuario=s.nextLine();
     // Llama a la validación de archivos con las credenciales ingresadas
        while (Nombre == false ) {
        
        	Nombre=LecturaArchivosUsuarios(nombreUsuario,contraseñaUsuario);
        	if (Nombre == false) {
        		System.out.println("Error!");
        	
        		System.exit(0);
        	}
        		
        	
        }
        System.out.println("Bienvenido " + nombreUsuario);
        
        System.out.println("Que deseas realizar?");
        System.out.println();
        System.out.println("1) Registrar actividad.");
        System.out.println("2) Modificar actividad.");
        System.out.println("3)Eliminar actividad.");
        System.out.println("4)Cambiar contraseña.");
        System.out.println("5)Salir.");
        
        int Expression=s.nextInt();
        
        switch(Expression){
        	case 1:
        		registrarActividad(flistaID,flistaFecha,flistaHoras,flistaActividad);
        		break;
        	case 2:
        		
        		
        		modificaActividad(flistaID,flistaFecha,flistaHoras,flistaActividad);
        		//Hay un error de implementación averiguar por que 
        		break;
        	case 3:
        		eliminarActividad(flistaID,flistaFecha,flistaHoras,flistaActividad);
        		break;
        	case 4:
        		cambiarContraseña(nombreUsuario,contraseñaUsuario);
        		break;
        	case 5:
        		Salida();
        		break;
        	default:
        		System.out.println("Equivocado, intente otra vez");
        		
        	
        }  s.close();
        
        
    
    }

   


	private static void cambiarContraseña(String nombreUsuario, String contraseñaUsuario) {
		// TODO Auto-generated method stub
		
	}


	private static void eliminarActividad(String[] elListaID,String[] elListaFecha,String[] elListaHoras, String[] elListaActividad ) throws FileNotFoundException {
		System.out.println("Cual actividad deseas Eliminar?");
    	File archivo= new File("Registros.txt");
		
		Scanner scaner=new Scanner(archivo);
		int conteo= 0;
		Scanner scv=new Scanner(System.in);
		
		
		
		while(scaner.hasNextLine()) {
			String linea=scaner.nextLine();
			String[] Partes=linea.split(";");
			String Id=Partes[0];
			String Fecha=Partes[1];
			String Horas=Partes[2];
			String Actividad=Partes[3];
			System.out.println(linea);
			elListaID[conteo]=Id;
			elListaFecha[conteo]=Fecha;
			elListaHoras[conteo]=Horas;
			elListaActividad[conteo]=Actividad;
			
			
			
			conteo++;	
			
		}
		
		System.out.println("ID de actividad a eliminar");
		// TODO Auto-generated method stub
		int cont=scv.nextInt();
		
		
	}


	private static void modificaActividad(String[] tlistaID, String[] tlistaFecha, String[] tlistaHoras, String[] tlistaActividad) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("Cual actividad deseas modificar?");
    	File archivo= new File("Registros.txt");
		
		Scanner scaner=new Scanner(archivo);
		int conteo= 0;
		Scanner scv=new Scanner(System.in);
		
		
		
		
		while(scaner.hasNextLine()) {
			String linea=scaner.nextLine();
			String[] Partes=linea.split(";");
			String Id=Partes[0];
			String Fecha=Partes[1];
			String Horas=Partes[2];
			String Actividad=Partes[3];
			System.out.println(linea);
			tlistaID[conteo]=Id;
			tlistaFecha[conteo]=Fecha;
			tlistaHoras[conteo]=Horas;
			tlistaActividad[conteo]=Actividad;
			
			
			
			conteo++;	
			
		}
    	
			Scanner sca=new Scanner(System.in);
	    	String Dotmodif=sca.nextLine();
	    	System.out.println("Que deseas modificar?");
	    	System.out.println();
	    	System.out.println("0) Regresar.");
	    	System.out.println("1) Fecha");
	    	System.out.println("2) Duracion");
	    	System.out.println("3) Tipo de actividad");
	        
	        int Seleccion=sca.nextInt();
	        
	        //Modificacion de usuario completa!!!!!

	        switch(Seleccion){
	            case 1:
	            	System.out.println("0) Regresar.");
	            	System.out.println("Ingrese nueva Fecha: ");
	            	
	            	
	            	
	            	modificar(Dotmodif,tlistaID,tlistaFecha);
	                System.out.println("Fecha  modificada con exito!");
	                
	                break;
	            case 2:
	            	System.out.println("0) Regresar.");
	            	System.out.println("Ingrese nueva duración: ");
	            
	            	modificar(Dotmodif,tlistaID,tlistaHoras);
	            	System.out.println("Duracion modificada con exito!");
	            	
	                break;
	            case 3:
	            	System.out.println("0) Regresar.");
	            	System.out.print("Ingrese nuevo tipo de actividad: ");
	            	
	            	modificar(Dotmodif,tlistaID,tlistaActividad);
	            	System.out.println("Actividad modificada  modificada con exito!");
	            	
	            	
	                break;
	            case 4:
	            	
	                break;
		
		
		
	    };
		
	       
		// TODO Auto-generated method stub
		
	            
	}

	


	private static void modificar(String Dotmo, String[] tilistaID, String[] tilistaFecha) {
		// TODO Auto-generated method stub
		
		int conteo = tilistaID.length;
		Scanner scv = new Scanner(System.in);
		String nuevaFecha=scv.nextLine();
		//int  cont=Integer.parseInt(Dotmo);
		for(int i=0;i<conteo;i++ ) {
        	if(tilistaID[i].equals(Dotmo) && tilistaID[i] != null) {
        		tilistaFecha[i]=nuevaFecha;		
        			}
			}
		
	}


	private static void registrarActividad(String[] ClistaID, String[] ClistaFecha, String[] ClistaHoras, String[] ClistaActividad) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Cual actividad deseas modificar?");
    	
		Scanner sca=new Scanner(System.in);
		System.out.println("Dato a agrega: ");
		System.out.print("ID: ");
		String nuevaId=sca.nextLine();
		System.out.print("Fecha");
		String nuevaFecha=sca.nextLine();
		System.out.println("Hora");
		String nuevaHora=sca.nextLine();
		System.out.println("Actividad");
		String nuevaActividad=sca.nextLine();
		
		int conteo=ClistaID.length;		
		for(int a=0;a<conteo;a++) {
			if(ClistaID[a].equals(nuevaId) && ClistaID!= null) {
				for(int b=a; b<conteo+1;b++) {
					String Aux= ClistaID[b];
					ClistaID[b] = nuevaId;
					ClistaID[b+1]=Aux;
					
					String Auxfecha=ClistaFecha[b];
					ClistaFecha[b]=nuevaFecha;
					ClistaFecha[b+1]= Auxfecha;
					
					String Auxhora=ClistaHoras[b];
					ClistaHoras[b]=nuevaHora;
					ClistaHoras[b]= Auxhora;
					
					String Auxact=ClistaActividad[b];
					ClistaActividad[b]=nuevaActividad;
					ClistaActividad[b]=Auxact;
					
				}
				
				
				
			}
			
		}
		
		
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
	 * @throws FileNotFoundException 
     */

    public static boolean  LecturaArchivosUsuarios(String nombreUsuario, String contraseñaUsuario ) throws FileNotFoundException {
    	
    	
    	System.out.println("Leyendo Archivos....");
    	String[] Usuariosinscritos=new String[100];
    	String[] Contraseñainscritos=new String[100];
        
        
       
        int cont=0;
        boolean nombreCorrecto = false;
        
		
			File file= new File("Usuarios.txt");
			 Scanner scanner = new Scanner (file);
		
		// Recorrido del archivo línea por línea
        while (scanner.hasNextLine()){
		        String linea=scanner.nextLine();
		     // Separación de datos según formato CSV (ID;Contraseña)
		        String[] Partes=linea.split(";");
		        Usuariosinscritos[cont]=Partes[0];
		        
		        Contraseñainscritos[cont]=Partes[1];
		        cont++;
        } scanner.close();
		
		
        for(int i=0;i< cont; i++){
        	
		        if (Usuariosinscritos[i].equals(nombreUsuario) && Contraseñainscritos[i].equals(contraseñaUsuario)){
					System.out.println("Acceso correcto!");
					 nombreCorrecto=true;
					 break;
		        }else {
		        	System.out.println("Error");
		        	nombreCorrecto=false;
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
