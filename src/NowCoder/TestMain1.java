package NowCoder;
import java.util.*;

class Solution1{

    public void sort(){

    }

}




// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class TestMain1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n= in.nextInt();
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            integers.add(x);
        }
        Integer[] array = integers.toArray(new Integer[integers.size()]);
        Arrays.sort(array);
        for (Integer number:array){
            System.out.println(number);
        }

    }
}