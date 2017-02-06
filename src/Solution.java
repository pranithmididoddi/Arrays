/**
 * Created by Pranith on 2/5/17.
 */
import java.util.*;
public class Solution {

    public static void main(String[] args){
        int[] array={3,4,9,11};
        int taget=7;

        int[] result=twoSum(array,taget);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map=new HashMap<>();

        int[] result=new int[2];

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int res=map.get(nums[i]);
                result[0]=res;
                result[1]=i;
                break;
            }else{
                map.put(target-nums[i],i);
            }

        }
        return result;

    }
    public int removeElement(int[] nums, int val) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }

        }
        return i;
    }
        public int findMaxConsecutiveOnes(int[] nums) {

            int count=0, result=0;

            for(int i=0;i<nums.length;i++){
                if(nums[i]==1){
                    count++;
                    result=Math.max(count,result);
                }else{
                    count=0;
                }
            }
            return result;
        }
}
