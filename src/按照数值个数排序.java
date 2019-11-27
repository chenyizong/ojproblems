import java.util.*;

/**
 * 按照数值个数排序
 * Description
 * <p>
 * 对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，则按照数值大小排序。例如，给定数组为{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}，则排序后结果为{3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}。
 * <p>
 * <p>
 * Input
 * <p>
 * 输入的第一行为用例个数；后面每一个用例使用两行表示，第一行为数组长度，第二行为数组内容，数组元素间使用空格隔开。
 * <p>
 * <p>
 * Output
 * <p>
 * 每一个用例的排序结果在一行中输出，元素之间使用空格隔开。
 * <p>
 * <p>
 * Sample Input 1
 * <p>
 * 1
 * 4
 * 2 3 2 5
 * Sample Output 1
 * <p>
 * 2 2 3 5
 */
public class 按照数值个数排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Num = Integer.parseInt(sc.nextLine());
        while (Num-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String[] s = sc.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for(int k = 0;k<n;k++){
                if(!map.containsKey(nums[k])){
                    map.put(nums[k],1);
                }else {
                    map.put(nums[k],map.get(nums[k]).intValue()+1);
                }
            }
            List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
                @Override
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            String res = "";
            for(Map.Entry<Integer,Integer> m:list){
                for(int i=0;i<m.getValue();i++){
                    res = res+m.getKey()+" ";
                }
            }
            System.out.println(res.substring(0,res.length()-1));

        }
    }
}
