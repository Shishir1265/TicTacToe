import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class TicTacToe
{
    public static void printboard(char [] [] board)
    {   for(char [] row : board)
        {   for(char r : row)
            { System.out.print(r);}
            System.out.println(); }}
    public static void positions(char[][]board,int pos,String user)
    {   char symbol= ' ';
        if(user.equals("player"))
        { symbol = 'X';
          playerpositions.add(pos);}
        else if(user.equals("cpu"))
        { symbol = 'O';
          cpupositions.add(pos);}
        switch(pos)
        {   case 1 : board [0][0] = symbol;
            break;
            case 2 : board [0][2] = symbol;
            break;
            case 3 : board [0][4] = symbol;
            break;
            case 4 : board [2][0] = symbol;
            break;
            case 5 : board [2][2] = symbol;
            break;
            case 6 : board [2][4] = symbol;
            break;
            case 7 : board [4][0] = symbol;
            break;
            case 8 : board [4][2] = symbol;
            break;
            case 9 : board [4][4] = symbol;
            break;
            default : System.out.println(":( Wrong command");
            break;}} 
    public static void playerturn(char [][] board, Scanner scan )
    {   System.out.print("Enter the position from 1-9 = ");
        int playerpos = scan.nextInt();
        while(playerpositions.contains(playerpos)||cpupositions.contains(playerpos))
        {System.out.println("Incorrect position !!");
         System.out.print("Enter the position from 1-9 = ");
         playerpos = scan.nextInt();}
        positions(board,playerpos,"player");}
    public static void cputurn(char[][]board)
    {   Random r = new Random();
        int cpupos = r.nextInt(9)+1;
        while (playerpositions.contains(cpupos)||cpupositions.contains(cpupos))
        {cpupos = r.nextInt(9)+1;}
        System.out.println("Computer chose " + cpupos);
        positions(board,cpupos,"cpu"); }
    public static boolean gamefinish (char[][] board)
    {   if(checkwin(board,'X')){System.out.println("Player Wins! :)");
        printboard(board);return true;}
        if(checkwin(board,'O')){System.out.println("Computer Wins! :)");
        printboard(board);return true;}
        for(int i=0; i<board.length; i++)
        { for(int j=0; j<board[i].length; j++)
            { if(board[i][j] == ' ')
                return false; }}
        System.out.println(":) Tie!");
        return true;}
    public static ArrayList<Integer> playerpositions = new ArrayList<>();
    public static ArrayList<Integer> cpupositions = new ArrayList<>();
    public static boolean checkwin(char [][] board, char symbol)
    {if((board[0][0]== symbol && board[0][2]== symbol && board[0][4]== symbol)||
        (board[2][0]== symbol && board[2][2]== symbol && board[2][4]== symbol)||
        (board[4][0]== symbol && board[4][2]== symbol && board[4][4]== symbol)||
        (board[0][0]== symbol && board[2][0]== symbol && board[4][0]== symbol)||
        (board[0][2]== symbol && board[2][2]== symbol && board[4][2]== symbol)||
        (board[0][4]== symbol && board[2][4]== symbol && board[4][4]== symbol)||
        (board[0][0]== symbol && board[2][2]== symbol && board[4][4]== symbol)||
        (board[0][4]== symbol && board[2][2]== symbol && board[4][0]== symbol))
    {return true;}
    else {return false;}}
    public static void main(String[] args) {
        char [][] board = {{' ','|',' ','|',' '},
                           {'-','+','-','+','-'},
                           {' ','|',' ','|',' '},
                           {'-','+','-','+','-'},
                           {' ','|',' ','|',' '}};
        Scanner scan = new Scanner (System.in);
        while(true)
        {
        playerturn(board,scan);
        if(gamefinish(board))
            break;
        printboard(board);
        cputurn(board);
        if(gamefinish(board))
            break;
        printboard(board);
        }
        scan.close();
    }
}