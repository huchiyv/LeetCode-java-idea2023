import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSolution53 {
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
        Solution53 solution=new Solution53();
        System.out.println(solution.maxSubArray(height));

    }
}


class Solution53 {
    public int maxSubArray(int[] nums) {
        Integer[] numsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        HashSet<Integer> setInteger=new HashSet<Integer>();

        getSet(numsInteger,setInteger,numsInteger.length,0,true);
        getSet(numsInteger,setInteger,numsInteger.length,numsInteger.length-1,false);
        ArrayList<Integer> list=new ArrayList<Integer>(setInteger);
        Collections.sort(list,Collections.reverseOrder());
        return list.get(0);
    }

    public void getSet(Integer[] numsInteger,HashSet<Integer> setInteger,int length,int index,boolean delectDir){
        if(delectDir){
            if(index==length-1){
                setInteger.add(numsInteger[0]);
                return;
            }
        }else{
            if(index==0){
                setInteger.add(numsInteger[0]);
                return;
            }

        }
        Integer maxNum=0;
        for(Integer nums:numsInteger){
            maxNum+=nums;
        }
        setInteger.add(maxNum);
        if(0==numsInteger.length-1){
            return;
        }
        Integer[] newNums=new Integer[numsInteger.length-1];
        int deleteIndex=index;
        if(delectDir){
            index++;
        }else{
            index--;
        }
        int j=0;
        for(int i=0;i<numsInteger.length;i++){
            if(deleteIndex!=i){
                newNums[j]=numsInteger[i];
                j++;
            }

        }
        getSet(newNums,setInteger,length,index,delectDir);

    }
}