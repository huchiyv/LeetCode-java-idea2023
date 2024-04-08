import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> resultList= new ArrayList<>();
        ArrayList<String>[] listArray=new ArrayList[strs.length];
        HashMap<Integer,ArrayList<String>> map=new HashMap<Integer,ArrayList<String>>();
        for(String str:strs){
            char[] wordChars= str.toCharArray();
            int type=0;
            for(char wordChar:wordChars){
                type+= wordChar;
            }
            insertGroupList(resultList,str,type,map);
        }
        for (Integer i : map.keySet()) {
            ArrayList<String> stringArrayList = map.get(i);
            resultList.add(stringArrayList);
        }


        return  resultList;
    }

    public void insertGroupList(List<List<String>> resultList,String str,int type,HashMap<Integer,ArrayList<String>> map){
        if (map.isEmpty()) {
            ArrayList<String> listString=new ArrayList<>();
            listString.add(str);
            map.put(type,listString);
        }else{
            boolean isExist=false;
            for(Integer key: map.keySet()){
                if(type==key){
                    isExist=true;
                }
            }
            if(isExist){
                ArrayList<String> stringArrayList = map.get(type);
                stringArrayList.add(str);
                map.put(type,stringArrayList);
            }else{
                ArrayList<String> listString=new ArrayList<>();
                listString.add(str);
                map.put(type,listString);
            }
        }

    }
}




public class TestSolution49 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("strs=");
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> stringArrayList = new ArrayList<>();
        while(matcher.find()){
            String str = matcher.group();
            stringArrayList.add(str);
        }
        String[] strs = stringArrayList.toArray(new String[stringArrayList.size()]);
        Solution49 solution49 = new Solution49();
        List<List<String>> lists = solution49.groupAnagrams(strs);
        System.out.print("[");

        for (List<String> list: lists){
            System.out.print("[");
            int i=0;
            for (String str:list){
                if(i<list.size()-1){
                    System.out.print('"'+str+'"'+",");
                }else {
                    System.out.print('"'+str+'"');

                }
                i++;
            }
            System.out.print("]");

        }
        System.out.print("]");


    }
}
