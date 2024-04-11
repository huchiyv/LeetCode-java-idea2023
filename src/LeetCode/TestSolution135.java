package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//未通过
class Solution135 {
    public int[] candyNums;
    public Integer maxRat;
    public int candy(int[] ratings) {
        candyNums=new int[ratings.length];
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < candyNums.length; i++) {
            candyNums[i]=0;
            set1.add(ratings[i]);
        }
        HashSet<Integer> set = new HashSet<>();

        while(true){
            if(valid(ratings)){
                break;
            }
            //Integer maxRat=0;
            //Integer maxRatIndex=0;

            if(getMaxRat(ratings,set))
            {
                giveCandy(ratings,maxRat);
                //candyNums[maxRatIndex]++;
            }
        }

        for (int i = 0; i < candyNums.length; i++) {
            if(0==candyNums[i]){
                candyNums[i]++;
            }
        }

        int minNums=0;
        for (int i = 0; i < candyNums.length; i++) {
            minNums+=candyNums[i];
        }
        return minNums;
    }

    public boolean valid(int[] ratings){
        for (int i = 0; i < ratings.length; i++) {
            int nextI=i+1;
            if(nextI>=ratings.length){
                //nextRat=ratings[nextI];
                break;
            }
            int nextRat=ratings[nextI];
            if(nextRat>ratings[i]){
                if(candyNums[nextI]<=candyNums[i]){
                    return false;
                }
            } else if (nextRat==ratings[i]) {
                //candyNums[nextI]--;
                continue;
            } else {
                if(candyNums[nextI]>=candyNums[i]){
                    return false;
                }
            }

        }
        return true;
    }


    public boolean getMaxRat(int[] ratings,HashSet<Integer> set){
        int[] sortRat = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            sortRat[i]=ratings[i];
        }
        Arrays.sort(sortRat);
        for (int i = sortRat.length-1; i>=0; i--) {
            while (set.add(sortRat[i])){
                maxRat= sortRat[i];
                //maxRatIndex=i;
                return true;
            }

        }
        return false;
    }

    public void  giveCandy(int[] ratings,Integer maxRat){
        for (int i = 0; i < ratings.length; i++) {
            if(maxRat==ratings[i]){
                candyNums[i]++;
            }
        }

    }



}
public class TestSolution135 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ratings =");
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (matcher.find()){
            String group = matcher.group();
            arrayList.add(Integer.parseInt(group));
        }

        int[] ratings = arrayList.stream().mapToInt(Integer::intValue).toArray();

        Solution135 solution135 = new Solution135();
        System.out.println(solution135.candy(ratings));


    }
}
