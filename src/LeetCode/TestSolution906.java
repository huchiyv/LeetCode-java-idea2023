package LeetCode;

import java.util.Scanner;

class Solution906 {
    public int superpalindromesInRange(String left, String right) {
        Long leftInteger=Long.parseLong(left);
        Long rightInteger=Long.parseLong(right);
        Long midInteger=leftInteger;
        int nums=0;
        while (leftInteger<=midInteger&&midInteger<=rightInteger){
            //判断是否时回文数
            if( !isPalindrome(midInteger)){
                midInteger++;
                continue;
            }
            //到这里确定midIntegerString是一个回文数，接着判断是否是超级回文数
            double sqrted = Math.sqrt(midInteger);
            boolean resultFlag=sqrted>0&&sqrted==(long)sqrted;
            if(resultFlag){
                if(isPalindrome((long)sqrted)){
                    nums++;
                }
            }
            midInteger++;
        }
        return nums;
    }

    public  boolean isPalindrome(long x ){
        // 将整数转换为字符串
        String str = String.valueOf(x);

        // 比较正序和逆序是否相同
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}


public class TestSolution906 {
    public static void main(String[] args) {
        System.out.println("left =");
        Scanner scanner = new Scanner(System.in);
        String left = scanner.next();
        System.out.println("right =");
        String right = scanner.next();

        Solution906 solution906 = new Solution906();
        System.out.println(solution906.superpalindromesInRange(left, right));

    }
}

