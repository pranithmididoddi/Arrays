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

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int val=Math.abs(nums[i])-1;
            if(nums[val]>0){
                nums[val]=-nums[val];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }

    public int thirdMax(int[] nums) {
        Set<Integer> set=new HashSet<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int n : nums){
            if(set.add(n)){
                pq.offer(n);
            }

            if(pq.size()>3){
                pq.poll();
            }
        }
        if(pq.size()==2) pq.poll();

        return pq.peek();

    }
    //move zeros to the front of the array
    public static void moveZeroes(int[] nums) {
        int i = nums.length-1;
        int j = nums.length-1;

        while (j >= 0) {
            if (nums[j] == 0) {
                j--;
            } else {
                nums[i] = nums[j];
                i--;
                j--;
            }
        }

        while (i >=0) {
            nums[i] = 0;
            i--;
        }


    }

    public void moveback(int[] nums) {

        int i=0;
        int j=0;

        while(j<nums.length){
            if(nums[j]==0){
                j++;
            }
            else{
                nums[i]=nums[j];
                i++;
                j++;
            }
        }

        while(i < nums.length){
            nums[i]=0;
            i++;
        }

    }

    public void sortColors(int[] nums) {

        int[] countarray=new int[3];

        for(int i=0;i<nums.length;i++){
            countarray[nums[i]]++;
        }

        for(int i=1;i<countarray.length;i++){
            countarray[i]=countarray[i]+countarray[i-1];
        }

        int[] sortedarray=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int index=countarray[nums[i]]-1;
            countarray[nums[i]]=countarray[nums[i]]-1;

            sortedarray[index]=nums[i];
        }

        System.arraycopy(sortedarray, 0, nums, 0, nums.length);
    }

    public int findPeakElement(int[] nums) {

        int index=0;
        int max=nums[0];

        for(int i=1;i<=nums.length-2;i++){
            int curr=nums[i];
            int prev=nums[i-1];
            int next=nums[i+1];

            if(curr>prev && curr> next && curr>max){
                max=nums[i];
                index=i;
            }
        }

        if(nums[nums.length-1]>max){
            index=nums.length-1;
        }
        return index;
    }

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack=new Stack<>();
        int i=0;
        int max=0;

        while(i<heights.length){
            if(stack.empty() || heights[i]>heights[stack.peek()]){
                stack.push(i);
                i++;
            }

            else{
                int val=stack.pop();
                int ht=heights[val];
                int width=stack.empty()?i :i-stack.peek()-1;
                max=Math.max(max,ht*width);
            }
        }

        while(!stack.empty()){
            int val=stack.pop();
            int ht=heights[val];
            int width=stack.empty()? i : i-stack.peek()-1;
            max=Math.max(max,ht*width);
        }
        return max;
    }

    public int searchInsert(int[] nums, int target) {

        int i=0;
        int j=nums.length-1;

        while(i<=j){
            int mid=(i+j)/2;

            if(target>nums[mid]){
                i=mid+1;
            }else if(target<nums[mid]){
                j=mid-1;
            }else{
                return mid;
            }
        }
        return i;
    }
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(matrix == null || matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int x=0;
        int y=0;

        while(m>0 && n>0){

            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }

            //below, process a circle

            //top - move right
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }

            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }

            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }

            //left - move up
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            m=m-2;
            n=n-2;
        }

        return result;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int instart=0;
        int inend=inorder.length-1;
        int poststart=0;
        int postend=postorder.length-1;

        TreeNode root=construction(inorder, instart, inend, postorder, poststart, postend);

        return root;
    }

    public TreeNode construction(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
        if(instart>inend || poststart>postend){
            return null;
        }

        int rootval=postorder[postend];
        TreeNode root=new TreeNode(rootval);

        int k=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootval){
                k=i;
            }
        }

        root.left=construction(inorder, instart, k-1, postorder, poststart, poststart+ k-(instart+1) );
        root.right=construction(inorder,k+1,inend,postorder,k+poststart-instart, postend-1);

        return root;
    }
    }
