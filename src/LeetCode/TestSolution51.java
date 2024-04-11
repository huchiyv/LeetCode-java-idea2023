package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution51 {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        ChessBoard chessBoard = new ChessBoard(n);
        backTrack(chessBoard,0,n);
        return result;

    }

    public void backTrack( ChessBoard chessBoard,int row,int col){
        if(row==col){
            ArrayList<String> list=new ArrayList<>();
            for (int i = 0; i < chessBoard.Board.length; i++) {
                String str="\"";
                for (int j = 0; j < chessBoard.Board[i].length; j++) {
                    str+=chessBoard.Board[i][j];
                }
                str+="\"";
                list.add(str);
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < col; i++) {
            if(chessBoard.validNQueens(row,i)){
                chessBoard.Board[row][i]="Q";
                backTrack(chessBoard,row+1,col);
                chessBoard.Board[row][i]=".";
            }

        }

    }

}

class ChessBoard{
    public String[][] Board;

   public ChessBoard(int n){
       Board=new String[n][n];
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               Board[i][j]=".";
           }
       }
    }

    public boolean validNQueens(int row,int col){
        for (int i = 0; i < Board.length; i++) {
            if(Board[i][col].equals("Q")){
                return false;
            }
        }
        int m=row;
        int n=col;
        while (m>=0&&n>=0){
            if(Board[m][n].equals("Q")){
                return false;
            }
            m--;
            n--;
        }
        m=row;
        n=col;
        while (m<Board.length&&n<Board.length){
            if(Board[m][n].equals("Q")){
                return false;
            }
            m++;
            n++;
        }
        m=row;
        n=col;
        while (m>=0&&n<Board.length){
            if(Board[m][n].equals("Q")){
                return false;
            }
            m--;
            n++;
        }
        m=row;
        n=col;
        while (m<Board.length&&n>=0){
            if(Board[m][n].equals("Q")){
                return false;
            }
            m++;
            n--;
        }
        return  true;

    }
}

public class TestSolution51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution51 solution51 = new Solution51();
        List<List<String>> lists = solution51.solveNQueens(n);
        System.out.print("[");
        for (int i = 0; i < lists.size(); i++) {
            //System.out.print("[");
            if(i==lists.size()-1){
                System.out.print(lists.get(i));

            }else {

                System.out.print(lists.get(i)+",");
            }
            //System.out.print("]");

        }
        System.out.print("]");

    }
}
