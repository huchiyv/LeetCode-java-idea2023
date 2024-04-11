package NowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public int getMaxNums(int n){

        Customer customer = new Customer(0, n);
        Shop shop = new Shop();
        exchange(customer,shop);

        return  customer.popNums;
    }

    public  void exchange(Customer customer,Shop shop ){
        if(customer.emptyNums<3&&1==Shop.emptyNums){
            if(customer.emptyNums+Shop.emptyNums>=3){
                Shop.emptyNums--;
                customer.emptyNums++;
                exchange(customer,shop);
                //Shop.emptyNums++;
            }
            return;
        }else if(customer.emptyNums<3&&0==Shop.emptyNums){
            customer.emptyNums--;
            Shop.emptyNums++;
            return;
        }

//        if(customer.emptyNums+Shop.emptyNums<3){
//            return;
//        }

        customer.popNums+=customer.emptyNums/3;
        int getEmptyNums=customer.emptyNums/3;
        customer.emptyNums=customer.emptyNums%3+getEmptyNums;
        exchange(customer,shop);

    }
}

class Customer{
    public int popNums;
    public int emptyNums;

    public Customer(int popNums, int emptyNums) {
        this.popNums = popNums;
        this.emptyNums = emptyNums;
    }
}

class Shop{
    public static int emptyNums=1;
}


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Solution solution = new Solution();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if(0==n){
                break;
            }
            int maxNums = solution.getMaxNums(n);
            list.add(maxNums);
        }
        for (Integer i : list) {
            System.out.println(i);
        }

    }
}