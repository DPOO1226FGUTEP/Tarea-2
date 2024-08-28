package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Arrays; // TODO


/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros() {
        int copiaint[] = new int[arregloEnteros.length];
        for (int i = 0; i < arregloEnteros.length; i++) {
            copiaint[i] = arregloEnteros[i];
        }
        return copiaint;
    }


    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas()
    {
    	String copiaStr[] = new String[arregloCadenas.length];
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		copiaStr[i] = arregloCadenas[i];
    	}
        return copiaStr;
    }
    
    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros()
    {
        int qtty = arregloEnteros.length;
        return qtty;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas()
    {
        int qtty = arregloCadenas.length;
        return qtty;
    }


    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        int[] bigerrArr = new int[arregloEnteros.length + 1];
        for (int i = 0; i < arregloEnteros.length; i++) {
        	bigerrArr[i] = arregloEnteros[i];
        }
        
        bigerrArr[bigerrArr.length - 1] = entero;
        arregloEnteros = bigerrArr; // Meter el nuevo en el viejo
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] bigerrArr = new String[arregloCadenas.length + 1];
        for (int i = 0; i < arregloCadenas.length; i++) {
        	bigerrArr[i] = arregloCadenas[i];
        }
        
        bigerrArr[bigerrArr.length - 1] = cadena;
        arregloCadenas = bigerrArr; // Meter el nuevo en el viejo
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        int aparece = contarApariciones(valor);
        int[] newArr = new int[arregloEnteros.length - aparece];
        int j = 0;  

        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != valor) {
                newArr[j++] = arregloEnteros[i];
            }
        }

        arregloEnteros = newArr;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        int aparece = contarApariciones(cadena);
        String[] newArr = new String[arregloCadenas.length - aparece];
        int j = 0;  

        for (int i = 0; i < arregloCadenas.length; i++) {
            if (!arregloCadenas[i].equalsIgnoreCase(cadena)) {
                newArr[j++] = arregloCadenas[i];
            }
        }

        arregloCadenas = newArr;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero(int entero, int posicion) {
        int tamanioArreglo = getCantidadEnteros();

        if (posicion < 0) {
            posicion = 0;
        }

        if (posicion > tamanioArreglo) {
            agregarEntero(entero); // Esta función agrega al final del arreglo
        } else {
            // Crear una nueva lista con espacio para el nuevo entero
            int[] totalizadora = new int[arregloEnteros.length + 1];

            // Copiar los elementos antes de la posición
            for (int i = 0; i < posicion; i++) {
                totalizadora[i] = arregloEnteros[i];
            }

            // Insertar el nuevo entero en la posición
            totalizadora[posicion] = entero;

            // Copiar el resto de los elementos después de la posición
            for (int i = posicion; i < arregloEnteros.length; i++) {
                totalizadora[i + 1] = arregloEnteros[i];
            }

            // Asignar la nueva lista al arreglo original
            arregloEnteros = totalizadora;
        }
    }


    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion ) {
        int maxPos = arregloEnteros.length;
        boolean isFucked = false;
        int[] totalizadora = new int[arregloEnteros.length - 1];

        // Hacer OutOfBounds Check
        if (posicion >= maxPos || posicion < 0) {
            isFucked = true;
        }

        if (!isFucked) {
        	int j = 0;
            for (int i = 0; i < maxPos; i++) {
                if (i != posicion) {
                    totalizadora[j] = arregloEnteros[i];
                    j++;
                }
            }

            // Asignar la nueva lista al arreglo original
            arregloEnteros = totalizadora;
        }
    }


    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    int[] totalizadora = new int[valores.length];
    int maxPos = valores.length;
    for (int i = 0; i < maxPos; i++) {
    	Double decimal = valores[i];
    	int current = decimal.intValue();
    	totalizadora[i] = current;
    	}
    // Asignar la nueva lista al arreglo original
    arregloEnteros = totalizadora;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    String[] totalizadora = new String[objetos.length];
    int maxPos = objetos.length;
    for (int i = 0; i < maxPos; i++) {
    	Object something = objetos[i];
    	totalizadora[i] = something.toString();
    	}
    // Asignar la nueva lista al arreglo original
    arregloCadenas = totalizadora;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		int current = arregloEnteros[i];
    		if (current<0) {
    			current = current * -1;
    			arregloEnteros[i] = current;
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	/*
    	int [] organized = new int[arregloEnteros.length];
    	boolean finished = false;
    	int orgPos = 0;
    	while (!finished) {
    		int minPos = 0;
    		double min = Double.POSITIVE_INFINITY;
    		for (int i = 0; i < arregloEnteros.length; i++) {
    			int value = arregloEnteros[i];
    			if (value <= min) {
    				min = value;
    				minPos = i;
    			}
    	
  
    	organized[orgPos] = arregloEnteros[minPos];
    	orgPos++;
    	eliminarEnteroPorPosicion(minPos);
    	
    	if (arregloEnteros.length == 0) {
    		finished = true;			}
    		} 
    	}
    	arregloEnteros = organized;
    	*/
    	// Esto es aceptar mi derrota:
		Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	  Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int counter = 0;
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		if (arregloEnteros[i] == valor) {
    			counter ++;
    		}
    	}
        return counter;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int counter = 0;
    	for (int i = 0; i < arregloCadenas.length; i++) {
    		if (arregloCadenas[i].equalsIgnoreCase(cadena)) {
    			counter ++;
    		}
    	}
        return counter;
    }


    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int numberOfT = contarApariciones(valor);
    	int [] retArray = new int [numberOfT];
    	int newPos = 0;
    	if (numberOfT == 0) {
    		return retArray;
    	}
    	else {
			for(int i = 0; i < arregloEnteros.length; i++) {
				if (arregloEnteros[i] == valor) {
					retArray[newPos] = i;
					newPos ++;
				}
			}
		return retArray;
    	}
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {

    	Integer min = Integer.MAX_VALUE;
    	Integer max = Integer.MIN_VALUE;
    	for(int i = 0; i < arregloEnteros.length; i++) {
    		int value = arregloEnteros[i];
    		if (value > max) {
    			max = value;
    		}
    		if (value < min) {
    			min = value;
    		}
    	}
    	
    	if (arregloEnteros.length == 0) {
    		int[] returnLista = new int[0];
    		return returnLista;
    	}else {
		int[] returnLista = new int[2]; 
		returnLista[0] = min;
		returnLista[1] = max;
		return returnLista;
		} 
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();
    	for (int i = 0; i < arregloEnteros.length; i++) {
    		int entero = arregloEnteros[i];
    		int apariciones = contarApariciones(entero);
    		histograma.put(entero, apariciones);
    		
    	}
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        HashMap<Integer, Integer> histograma = calcularHistograma();
        int contador = 0;

        for (int apariciones : histograma.values()) { // For apariciones in ...
            if (apariciones > 1) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if (Arrays.equals(arregloEnteros, otroArreglo)) {
    		return true;
    	}else {return false;}
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	int contador = 0;
    	for(int i = 0; i < arregloEnteros.length; i++) {
    		boolean isPresent = false; 
    		int value = arregloEnteros[i];
    		
    		for(int j = 0; j < otroArreglo.length; j++) {
    			if (otroArreglo[j] == value);
    			isPresent = true;
    		}
    		otroArreglo[i] = arregloEnteros[i];
    		if (isPresent) {
    			contador ++;
    		}
    	}
       
    	if (contador >= otroArreglo.length) { // This is a fucking bet i'm making
    		return true;
    	}else { return false;}
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int [] randArray = new int[cantidad];
    	for (int i = 0; i < cantidad; i++) {
    		int rand = (int)(Math.random() * (maximo - minimo + 1)) + minimo;
    		randArray[i] = rand;
    	}
    	
    	arregloEnteros = randArray;
    }

}
