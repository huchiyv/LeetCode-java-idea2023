package LeetCode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution85 {
    public int maximalRectangle(char[][] matrix) {

        return 0;
    }
}

public class TestSolution85 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("matrix =");
        String input = scanner.nextLine();
        System.out.println("rows=");
        int rows = scanner.nextInt();
        System.out.println("cols=");
        int cols = scanner.nextInt();

        //处理输入
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        String s ="";
        while (matcher.find()){
            String group = matcher.group();
            s+=group;
        }
        char[] matrixs = s.toCharArray();

        char[][] matrix = new char[rows][cols];
        int k=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=matrixs[k++];
            }
        }

        Solution85 solution85 = new Solution85();

        System.out.println(solution85.maximalRectangle(matrix));


    }
}
