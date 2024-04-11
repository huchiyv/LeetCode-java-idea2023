package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
示例 1：

输入：cardPoints = [1,2,3,4,5,6,1], k = 3
输出：12
解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 */
class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        //滑动窗口算法，开始滑动窗大小为cardPoints.length 滑动变化获取中间最小值,那么窗口之外就是最大值(前提:数组内都是正数),窗口最大缩小范围小于k
        windos windos = new windos(0,cardPoints.length-1,0,cardPoints);
        //保存初始合
        int sum=windos.calSum();
        //滑动获取窗口内最小和
        windos.getMinSum(k);
        //返回最大值
        return sum-windos.sum;
    }
}

class windos{
    public int leftIndex;
    public int rightIndex;

    public int[] cardValues;
    public int sum;

    //public static ArrayList<Integer> sumList=new ArrayList<>();

    public windos(int leftIndex, int rightIndex, int sum,int[] cardValues) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.sum = sum;
        this.cardValues=cardValues;
    }

    public int calSum(){
        sum=0;
        for(int i=leftIndex;i<=rightIndex;i++){
            if(i<=rightIndex){
                sum+=cardValues[i];
            }else{
                System.out.println("为0");
            }
        }
        return sum;
    }

    public void getMinSum(int useableNums) {
        this.rightIndex = cardValues.length - useableNums - 1;
        int sumTemp = calSum();
        this.sum = sumTemp;
        for (int i = 0; i < useableNums; i++) {
            sumTemp += cardValues[rightIndex + 1] - cardValues[leftIndex];
            rightIndex++;
            leftIndex++;
            this.sum = this.sum > sumTemp ? sumTemp : this.sum;
        }
    }
}


public class TestSolution1423 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("cardPoints =");
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        ArrayList<Integer> list=new ArrayList<>();
        while(matcher.find()){
            String cardPoint = matcher.group();
            list.add(Integer.parseInt(cardPoint));
        }
        int[] cardPoints = list.stream().mapToInt(Integer::intValue).toArray();
        Solution1423 solution1423 = new Solution1423();
        System.out.println("k=");
        int k = scanner.nextInt();
        scanner.close();

        System.out.println(solution1423.maxScore(cardPoints, k));

    }
}
