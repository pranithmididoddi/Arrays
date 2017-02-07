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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || nums[i]>nums[i-1]){
                int j=i+1;
                int k=nums.length-1;

                while(j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        j++;
                        k--;

                        while(j<k && nums[j]==nums[j-1]){
                            j++;
                        }
                        while(j<k && nums[k]==nums[k+1]){
                            k--;
                        }
                    }else if(nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }
                    else{
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        int min=Integer.MAX_VALUE;
        int result=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;

            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                int diff=Math.abs(target-sum);

                if(diff==0){
                    return sum;
                }

                if(diff<min){
                    min=diff;
                    result=sum;
                }
                if(sum<=target){
                    j++;
                }else{
                    k--;
                }

            }
        }
        return result;
    }

}
