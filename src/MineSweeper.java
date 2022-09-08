import java.util.Random;

public class MineSweeper {
    private final int row;
    private final int column;
    private final int mineCount;
    String[][] mineSweeper;

    public MineSweeper(int row, int column, int mineCount) {
        this.row = row;
        this.column = column;
        this.mineCount = mineCount;
        this.mineSweeper = new String[this.row][this.column];
    }

    public void start() {
        buryMines();
        System.out.println("-----------------------------");
        mines();
    }


    public int start(int row, int column, int game) {
        int count = 0;
        if (game == this.row * this.column - this.mineCount) return 2;
        if (this.mineSweeper[row][column] == "*\t") return 0;
        else {
            if (row - 1 > -1) {
                if (mineSweeper[row - 1][column] == "*\t") {
                    count++;
                }
                if (column - 1 > -1) {
                    if (mineSweeper[row - 1][column - 1] == "*\t") {
                        count++;
                    }
                }
                if (column + 1 != this.column) {
                    if (mineSweeper[row - 1][column + 1] == "*\t") {
                        count++;
                    }
                }
            }
            if (row + 1 != this.row) {
                if (mineSweeper[row + 1][column] == "*\t") {
                    count++;
                }
                if (column - 1 > -1) {
                    if (mineSweeper[row + 1][column - 1] == "*\t") {
                        count++;
                    }
                }
                if (column + 1 != this.column) {
                    if (mineSweeper[row + 1][column + 1] == "*\t") {
                        count++;
                    }
                }
            }
            if (column - 1 > -1) {
                if (mineSweeper[row][column - 1] == "*\t") {
                    count++;
                }
            }
            if (column + 1 != this.column) {
                if (mineSweeper[row][column + 1] == "*\t") {
                    count++;
                }
            }
            this.mineSweeper[row][column] = String.valueOf(count) + "\t";
            print();
            return 1;
        }
    }

    private void mines() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(this.mineSweeper[i][j]);
            }
            System.out.println();
        }
    }
    private void print() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(this.mineSweeper[i][j]);
            }
            System.out.println();
        }
    }

    private void buryMines() {
        int count = 0;
        int row, column;
        int beforeRowMine = -1, beforeColumnMine = -1;
        while (count <= this.mineCount) {
            if (count == this.mineCount) {
                break;
            }
            Random random = new Random();
            row = random.nextInt(this.row);
            column = random.nextInt(this.column);
            while (row == beforeRowMine || column == beforeColumnMine) {
                row = random.nextInt(this.row);
                column = random.nextInt(this.column);
            }
            beforeRowMine = row;
            beforeColumnMine = column;
            this.mineSweeper[row][column] = "*\t";
            count++;
        }
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                if (this.mineSweeper[i][j] != "*\t") {
                    this.mineSweeper[i][j] = "-\t";
                }
            }
        }
    }
}
