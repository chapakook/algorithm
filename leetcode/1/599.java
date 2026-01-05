import java.util.*;
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<list1.length; i++) {
            map.put(list1[i],i);
        }

        int min = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();

        for(int j = 0 ; j < list2.length; j++) {
            Integer i = map.get(list2[j]);
            if(i == null) continue;
            int sum = i + j;
            if(sum < min) {
                min = sum;
                ans.clear();
                ans.add(list2[j]);
            }else if(sum == min) {
                ans.add(list2[j]);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}