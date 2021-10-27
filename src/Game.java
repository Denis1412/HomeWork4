import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final int SIZE =3;
    private static final char DON_X = 'X';
    private static final char DON_0 = '0';

    private static final char DON_EMPTY = '•';
    private static Scanner scanner;
    private static char[][] map = new char[SIZE][SIZE];


    public static void main(String[] args) {
        InitMap();scanner = new Scanner(System.in);
        printMap();

        while (true) {
            humanTurn(scanner);
            printMap();
            if (isMapFull()){System.out.println(("Ничия!"));
            break;
            }

            if (isWin(DON_X)){
                System.out.println("Победил человек");
            }

            aiTurn();
            printMap();
            if (isMapFull()){System.out.println(("Ничия!"));
                break;
            }

            if (isWin(DON_0)){
                System.out.println("Победил ПК");
            }


        }

    }
    private static boolean isWin(char symbol){
        if (map[0][0] == symbol && map[0][1] == symbol && map[0][2]== symbol) return true;
        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2]== symbol) return true;
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2]== symbol) return true;
        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0]== symbol) return true;
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1]== symbol) return true;
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2]== symbol) return true;
        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2]== symbol) return true;
        if (map[2][0] == symbol && map[1][1] == symbol && map[0][2]== symbol) return true;
        return false;
    }


 private static boolean isMapFull() {
     for (int i = 0; i < SIZE; i++) {
         for (int j = 0; j < SIZE; j++) {
             if (isEmptyCell(i ,j)){
                 return false;
             }
         }

     }return true;
     }
    public static void aiTurn()  {
        int i, j;
        Random random = new Random();
        do {
            i = random.nextInt(SIZE- 1);
            j = random.nextInt(SIZE- 1);
        }while(!isEmptyCell(i , j ));
        map[i ][j ] = DON_0;


    }
    private static void humanTurn(Scanner scanner) {
        System.out.print("Введите координаты строки стобца: ");
        int i= 0;
        int j= 0;
        do {
            i = readIndex(scanner);
            j = readIndex(scanner);


            if (!checkRange(i) || !checkRange(j)) {
                System.out.println("координата должна лежать от 1 до " + SIZE);
                continue;
            }
            if (isEmptyCell(i - 1, j - 1)) {
                break;
            } else {
                System.out.println("Клкетка уже занята!");
            }
        }
        while (true) ;





        map[i - 1][j - 1] = DON_X;
    }
     private static boolean isEmptyCell(int i,int j ){
        return map[i][j] == DON_EMPTY;
}

    private static boolean checkRange(int index) {
        return index >= 1 && index <= SIZE;


    }

    private static int readIndex(Scanner scanner) {
       while (!scanner.hasNextInt()){
           System.out.println("Координаты должны иметь Целочисленое значение!");
           scanner.next();
       }
        return scanner.nextInt();
    }









    private static void InitMap() {
        for (int i = 0; i < map.length; i++){
            Arrays.fill(map[i], DON_EMPTY);
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i+" ");
        }

        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) +" ");
            for (int j = 0; j < map[i].length ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


}
