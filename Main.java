import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File archivoEntrada = new File("DatosTomados.txt");
        FileReader lectorArchivo = new FileReader(archivoEntrada);
        BufferedReader lectorBuf = new BufferedReader(lectorArchivo);
        String str;
        String Nombres[][] = new String[10][6];
        int Nacimiento[][] = new int[10][6];
        Double Estatura[][] = new Double[10][6];
        int i = 0, y = 0;
        for (int x = 1; x <= 50; x++) {
            str = lectorBuf.readLine();
            String line[] = str.split(",");
            Nombres[i][y] = line[0];
            Nacimiento[i][y] = Integer.valueOf(line[1].trim());
            Estatura[i][y] = Double.parseDouble(line[2].trim());
            y++;
            if (y == 6) {
                i++;
                y = 0;
            }
        }
        lectorBuf.close();
        System.out.println("   ---------------------------");
        System.out.println("| BIENVENIDO, ELIJE UNA OPCIÓN: |");
        System.out.println("   ---------------------------");
        // se tiene que realizar con un ciclo ó invertir la lógica
        switch (Opcion()) {
            case 1:
                BuscarPorNombre(Nombres, Nacimiento, Estatura);
                break;
            case 0:
                System.out.println("bye :)");
                break;
            default:
                System.out.println("Por favor, selecciona una opción válida");
                Opcion(); // no contempla que el usuario erre 2 veces
                break;
        }
    }

    public static int Opcion() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("+-----------------------------------------------------------------------------------+");
        System.out.println("|\t\t 0.Salir                                                            |");
        System.out.println("|\t\t 1.Encontrar a una persona por su nombre                            |");
        System.out.println("|\t\t 2.Encontrar las personas con su año de nacimiento                  |");
        System.out.println("|\t\t 3.Encontar las personas con mayor edad por su año de nacimiento    |");
        System.out.println("|\t\t 4.Encontar las personas con menor edad por su año de nacimiento    |");
        System.out.println("|\t\t 5.Encontrar personas que sus nombres empicen con la letra indicada |");
        System.out.println("|\t\t 6.Encontrar a personas por su estatura                             |");
        System.out.println("|\t\t 7.Encontrar a personas que sean más bajas que una estatura dada    |");
        System.out.println("|\t\t 8.Encontrar a personas que sean más altas que una estatura dada    |");
        System.out.println("|\t\t 9.Encontrar la persona más joven                                   |");
        System.out.println("|\t\t 10.Agregar a una persona                                           |");
        System.out.println("+-----------------------------------------------------------------------------------+");
        int opc = read.nextInt();
        return opc;
    }

    public static void BuscarPorNombre(String Nombres[][], int Nacimiento[][], Double Estatura[][]) {
        read.nextLine();
        System.out.println("Ingresa un nombre");
        String arre[] = new String[3];
        String nomIngresado = read.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < 10 && encontrado == false; i++) {//no es necesario el boolean ni nada similar solo es buena practica y eficiente, ademas se pudiese quedar tal como lo tenias y manejar esa exception con un bloque try-catch, en donde con el catch atrapas la exception e imprimes que no fue encontrado(te ahorras condiciones y algo de codigo) pero no creo que a dalia le parezca buena idea en fin esa es otra opción 
            for (int y = 0; y < 6; y++) {
                if (nomIngresado.equals(Nombres[i][y])) {//la excepción que daba era pq cuando no se encuentra el nombre, la matriz se recorre por completo, sin embargo como la matriz también contiene elementos null´s cuando llegas a uno de esos elementos y tratas de llamar al método .equals(Objeto), aquí es cuando te da un error ya que no puedes llamar al método con un Objeto que sea null, resumiendo solo invertí la condición  
                    encontrado = true;
                    arre[0] = Nombres[i][y];
                    arre[1] = Integer.toString(Nacimiento[i][y]);
                    arre[2] = Double.toString(Estatura[i][y]);
                }
            }
        }
        if (Arrays.stream(arre).allMatch(Objects::nonNull)) {//para que dalia no diga nada se puede recorrer el arreglo y si las posiciones son vacías o null, pd no es necesario recorrer todo el arreglo ya que en la lógica siempre se llena el arreglo o no por lo que podríamos solo hacer una condición que verifique si la primer posición es null  
            for (int x = 0; x < arre.length; x++) {
                System.out.println(arre[x]);
            }
        } else {
            System.out.println(
                    "El nombre que intentas buscar no se encuentra en mi base de datos, deseas agregarlo ahora? (y/N)");
                    //llamas a tu método
                    //agregar elemento 
                    //primero se tendría que verificar una posición vacía etc...
        }
    }

}