package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution3065 {
    public Integer minValue=999;
    public int minOperations(int[] nums, int k) {

        int operationNum=0;
        while(true){
            if(!findminValue(nums,minValue)){
                break;
            }
            if(minValue>=k){
                break;
            }
            nums=doOperation(nums,minValue);
            operationNum++;
        }
        return operationNum;
    }
    private int[] doOperation(int[] nums,int minValue){
        int[] newNums=new int[nums.length-1];
        int i=0;
        for(int num:nums){
            if(minValue!=num){
                newNums[i]=num;
                i++;
            }
        }
        return newNums;
    }
    private boolean findminValue(int[] nums,Integer minValue){
        if(0==nums.length){
            return false;
        }
        minValue=nums[0];
        for(int num:nums){
            minValue=minValue>num?num:minValue;
        }
        this.minValue=minValue;
        return true;
    }
}

public class TestSolution3065{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("nums=");
        String input= scanner.nextLine();

        Pattern pattern= Pattern.compile("\\d+");
        Matcher matcher=pattern.matcher(input);

        ArrayList<Integer> numsList=new ArrayList<Integer>();
        while(matcher.find()){
            int num= Integer.parseInt(matcher.group()) ;
            numsList.add(num);
        }
        int[] nums=numsList.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("k=");
        int k = scanner.nextInt();
        System.out.println((new Solution3065()).minOperations(nums,k));


    }
}