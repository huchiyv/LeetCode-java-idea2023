import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Solution11 {
    public int maxArea(int[] height) {
        int[] heightSort= Arrays.copyOf(height, height.length);
        Vector<Integer> maxAreaVector=new Vector<>();
        Arrays.sort(heightSort);//从小到大排序
        int currentMinIndex=0;
        int lastMinIndex=0;
        int lastMin=0;//heightSort[j];
        for(int j=0;j<heightSort.length;j++){
            int currentMin=heightSort[j];
            //计算当前最短垂线和其他垂线的距离，并求其组成的面积即容积
            for(int i=0;i<height.length;i++){
                if(currentMin==height[i]){
                    if(lastMin==currentMin &&i==lastMinIndex){
                        continue;
                    }
                    currentMinIndex=i;
                    lastMinIndex=i;
                    lastMin=currentMin;
                    break;
                }
            }

            int maxArea=0;
            for(int i=0;i<height.length;i++){
                if(currentMin<=height[i]){
                    int areaTeamp =Math.abs((currentMinIndex-i))*currentMin;
                    maxArea=areaTeamp>maxArea?areaTeamp:maxArea;
                }

            }
            maxAreaVector.add(maxArea);
        }
        Collections.sort(maxAreaVector);

        return maxAreaVector.lastElement();
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