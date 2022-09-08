import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int row = 0, column = 0;
        while (row == 0 || column == 0) {
            if (row != 0 && column != 0) {
                break;
            }
            System.out.print("Row : ");
            row = input.nextInt();
            System.out.print("Column : ");
            column = input.nextInt();
        }
        int mineCount = (row * column) / 4;

        MineSweeper mineSweeper = new MineSweeper(row, column, mineCount);
        mineSweeper.start();

        int gameResult = 1;
        int game=0;
        while (gameResult == 1) {
            game++;
            System.out.print("Row : ");
            row = input.nextInt();
            System.out.print("Column : ");
            column = input.nextInt();
            gameResult = mineSweeper.start(row, column,game);
        }
        if (gameResult == 0) System.out.println("Mayına Bastınız\nOYUN BİTTİ");
        else System.out.println("TEBRİKLER OYUNU KAZANDINIZ!");
    }

}
