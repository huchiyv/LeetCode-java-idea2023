package NowCoder;

import java.util.HashMap;
import java.util.Scanner;

public class TestMain2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String input = in.next();
        String number = input.substring(2); // 去除十六进制数的前缀 "0x"

        HashMap<Character, Integer> map = getCharacterIntegerHashMap();

        char[] nums = number.toCharArray();
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            result += (int) (map.get(nums[i]) * Math.pow(16, nums.length - 1 - i));
        }
        System.out.println(result);

    }

    private static HashMap<Character, Integer> getCharacterIntegerHashMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        return map;
    }
}
