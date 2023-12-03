import java.util.Scanner;
public class busqueda {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String prueba[][] = new String[3][3];
        String arre[] = new String[3];
        for (int x=0; x<3; x++){
            for (int y=0; y<3; y++){
                prueba[x][y] = scanner.nextLine();
            }
        }
        int cont=0;
        for (int x=0; x<3; x++){
            for (int y=0; y<3; y++){
                if (prueba[x][y].equals("a")) {
                    arre[cont]=prueba[x][y];
                    cont++;
                }
            }
        }
        for (int x=0; x<arre.length; x++){
            System.out.println(arre[x]);
        }
    }
}
