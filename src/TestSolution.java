import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList();
        //取数字
        char[] digit=digits.toCharArray();
        //没有直接返回
        if(0==digit.length){
            return result;
        }
        String[][] collectionString={
                {"2","a","b","c"},
                {"3","d","e","f"},
                {"4","g","h","i"},
                {"5","j","k","l"},
                {"6","m","n","o"},
                {"7","p","q","r","s"},
                {"8","t","u","v"},
                {"9","w","x","y","z"}};

        List<String[]> charList=new ArrayList<>();
        int rows=0;
        //分配数字对应的字母
        for(int i=0;i<digit.length;i++){
            rows=digit[i]-'0'-2;
            charList.add(collectionString[rows]);
        }
        //只有一个直接返回
        if(1==digit.length){
            for(int i=1;i<charList.get(0).length;i++){
                result.add(charList.get(0)[i]);
            }
            return result;
        }
        //多个数字迭代
        // for(int i=0;i<charList.size();i++){
        //     String[] firstCharList=charList.get(i);
        //     for(int j=i+1;j<charList.size();j++){
        //         String[] secondCharList=charList.get(j);
        //         //String tempRusult;
        //         result.addAll(getResultList(secondCharList,firstCharList));

        //     }
        // }

        //递归
        getResultsList(result,0,charList,"");




        return result;
    }

    /**
     两个String数组排列组合，返回组合结果
     */
    private List<String> getResultList(String[] first,String[] second){
        List<String>  resultList= new ArrayList();
        for(int i=1;i<first.length;i++){
            for(int j=1;j<second.length;j++){
                String result= second[j]+first[i];
                resultList.add(result);
            }

        }
        return resultList;
    }

    private void  getResultsList(List<String> result,int index, List<String[]> charList,String characters){
        if(charList.size()<=index){
            return ;
        }
        String[] charStrings=charList.get(index);
        for(int i=1;i<charStrings.length;i++){
            String character=charStrings[i]+characters;
            getResultsList(result,index+1,charList,character);
            if(index==charList.size()-1){
                result.add(character);
            }
        }

    }




}

public class TestSolution{
    public static void main(String[] arg){
        Solution solution=new Solution();
        Scanner scanner=new Scanner(System.in);
        System.out.print("digits=");
        String digits=scanner.next();
        List<String> resultList=solution.letterCombinations(digits);
        System.out.println();
        System.out.print("[");
        for (int i=0;i<resultList.size();i++) {
            // 处理每个元素
            System.out.println("\""+resultList.get(i)+"\"");
            if(i<resultList.size()-1){
                System.out.println(",");
            }
        }
        System.out.print("]");
    }
}