import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    public static void printboard(char[][] board) {
        for (char[] row : board) {
            for (char r : row) {
                System.out.print(r);
            }
            System.out.println();
        }
    }

    public static void positions(char[][] board, String pos, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerpositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpupositions.add(pos);
        }
        switch (pos) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][2] = symbol;
                break;
            case "3":
                board[0][4] = symbol;
                break;
            case "4":
                board[2][0] = symbol;
                break;
            case "5":
                board[2][2] = symbol;
                break;
            case "6":
                board[2][4] = symbol;
                break;
            case "7":
                board[4][0] = symbol;
                break;
            case "8":
                board[4][2] = symbol;
                break;
            case "9":
                board[4][4] = symbol;
                break;
        }
    }

    public static void playerturn(char[][] board, Scanner scan) {
        String req[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        List<String> check = Arrays.asList(req);
        System.out.print("Enter the position from 1-9 = ");
        String playerpos = scan.next();
        while (playerpositions.contains(playerpos) || cpupositions.contains(playerpos)
                || (!check.contains(playerpos))) {
            System.out.println("Incorrect position !!");
            System.out.print("Enter the position from 1-9 = ");
            playerpos = scan.next();
        }
        positions(board, playerpos, "player");
    }

    public static void cputurn(char[][] board) {
        Random r = new Random();
        int c = r.nextInt(9) + 1;
        String cpupos = Integer.toString(c);
        while (playerpositions.contains(cpupos) || cpupositions.contains(cpupos)) {
            c = r.nextInt(9) + 1;
            cpupos = Integer.toString(c);
        }
        System.out.println("Computer chose " + cpupos);
        positions(board, cpupos, "cpu");
    }

    public static boolean gamefinish(char[][] board) {
        if (checkwin(board, 'X')) {
            printboard(board);
            System.out.println("Player Wins! :)");
            return true;
        }
        if (checkwin(board, 'O')) {
            printboard(board);
            System.out.println("Computer Wins! :)");
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        System.out.println(":) Tie!");
        return true;
    }

    public static ArrayList<String> playerpositions = new ArrayList<>();
    public static ArrayList<String> cpupositions = new ArrayList<>();

    public static boolean checkwin(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) ||
                (board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) ||
                (board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) ||
                (board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) ||
                (board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) ||
                (board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) ||
                (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) ||
                (board[0][4] == symbol && board[2][2] == symbol && board[4][0] == symbol)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };
        Scanner scan = new Scanner(System.in);
        while (true) {
            playerturn(board, scan);
            if (gamefinish(board))
                break;
            printboard(board);
            cputurn(board);
            if (gamefinish(board))
                break;
            printboard(board);
        }
        scan.close();
    }
}