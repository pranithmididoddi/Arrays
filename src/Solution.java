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
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();

        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int length=nums.length;

        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > length/3){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    /**
     * contains duplicate*/
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int length=nums.length;

        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                return true;
            }
        }
        return false;
    }

    public int[] twoSumii(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int res = map.get(nums[i]);
                result[0] = res + 1;
                result[1] = i + 1;
                break;
            } else {
                map.put(target - nums[i], i);
            }

        }
        return result;
    }
    public int majorityElem(int[] nums) {

        List<Integer> list=new ArrayList<>();
        int num=0;

        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int length=nums.length;

        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > length/2){
                num=entry.getKey();
            }
        }
        return num;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length && nums[i+1]-nums[i]==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }
            else{
                list.add(nums[i]+"");
            }
        }
        return list;
    }
    public int findDuplicate(int[] nums) {

        Map<Integer, Integer> map=new HashMap<>();
        int num=0;

        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }

        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>1){
                num=entry.getKey();
            }
        }
        return num;
    }
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list=new ArrayList<>();
        if(numRows<=0){
            return list;
        }
        List<Integer> pre=new ArrayList<>();
        pre.add(1);
        list.add(pre);

        for(int i=2;i<=numRows;i++){
            List<Integer> cur=new ArrayList<>();

            cur.add(1);

            for(int j=0;j<pre.size()-1;j++){
                cur.add(pre.get(j)+pre.get(j+1));
            }
            cur.add(1);

            list.add(cur);

            pre=cur;
        }
        return list;
    }

    /**matrix rotation clockwise*/
    public void rotate(int[][] matrix) {

        int n=matrix.length;

        for(int i=0;i<n/2;i++){
            for(int j=0;j< Math.ceil(((double) n) / 2.); j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }

    }

    public int uniquePaths(int m, int n) {

        int[][] array=new int[m][n];

        for(int i=0;i<m;i++){
            array[i][0]=1;
        }

        for(int j=0;j<n;j++){
            array[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                array[i][j]=array[i-1][j]+array[i][j-1];
            }
        }
        return array[m-1][n-1];
    }
    }
