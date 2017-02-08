/**
 * Created by Pranith on 2/5/17.
 */
import java.util.*;
public class Solution {

    public static void main(String[] args){
       int[] nums={3,2,1,-4,6,5};

       for(int i=0;i<nums.length;i++){
           int index=Math.abs(nums[i]+1);
           System.out.println(index);
       }
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
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int[] result=new int[nums.length];
        int max=nums[0];
        result[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            result[i]=Math.max(nums[i],result[i-1]+nums[i]);
        }

        for(int i : result){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0){
                list.add(Math.abs(index+1));
            }
            nums[index]=-nums[index];
        }
        return list;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i]==nums[i-1] ){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l] < target){
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l] > target){
                        l--;
                    }else{
                        List<Integer> singlelist=new ArrayList<>();
                        singlelist.add(nums[i]);
                        singlelist.add(nums[j]);
                        singlelist.add(nums[k]);
                        singlelist.add(nums[l]);
                        list.add(singlelist);

                        k++;
                        l--;

                        while(k<l && nums[l]==nums[l+1]){
                            l--;
                        }
                        while(k<l && nums[k]==nums[k-1]){
                            k++;
                        }
                    }
                }
            }
        }
        return list;
    }
    public boolean canJump(int[] nums) {
        int maxJump=nums[0];
        int maxLength=nums.length-1;

        for(int i=0;i<=maxJump;i++){
            maxJump=Math.max(maxJump, i+nums[i]);
            if(maxJump>=maxLength){
                return true;
            }
        }
        return false;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        int[] a1=new int[nums.length];
        int[] a2=new int[nums.length];

        a1[0]=1;
        a2[nums.length-1]=1;

        for(int i=0;i<a1.length-1;i++){
            a1[i+1]=a1[i]*nums[i];
        }

        for(int i=a2.length-1;i>0;i--){
            a2[i-1]=a2[i]*nums[i];
        }

        for(int i=0;i<result.length;i++){
            result[i]=a1[i]*a2[i];
        }
        return result;
    }
}
