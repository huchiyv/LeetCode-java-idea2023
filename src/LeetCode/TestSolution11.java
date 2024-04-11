package LeetCode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Solution11 {
    /*
    * 双指针算法解决，本题要点在于当你得到最边上两根柱子时，从柱子的高度就能决定如果要获取最大容量接下来就是由最低柱子来决定最大高度，因为从此之后只能
    * 不断缩减两个柱子的距离即面积只会减小，所以使用最小柱子算出最大面积之后就可以排除掉此次最小柱子
    * */
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int area=0;
        int areaMax=0;
        while (i < j ) {
            int h=height[i]>height[j]?height[j]:height[i];
            area=h*(j-i);
            areaMax=area>areaMax?area:areaMax;
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return areaMax;
    }
}



public class TestSolution11{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("height=");
        String inputString=scanner.nextLine();
        // 定义正则表达式，匹配数字
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputString);

        // 创建一个可变长度的数组列表，用于保存匹配到的数字
        ArrayList<Integer> numbers = new ArrayList<>();

        // 遍历匹配到的数字，并转换为 int 值，保存到数组列表中
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            numbers.add(number);
        }

        // 将数组列表转换为 int 数组
        int[] height = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            height[i] = numbers.get(i);
        }
        Solution11 solution=new Solution11();
        System.out.println(solution.maxArea(height));

    }
}