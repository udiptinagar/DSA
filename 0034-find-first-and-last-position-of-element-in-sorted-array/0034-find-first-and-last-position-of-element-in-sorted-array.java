class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int first = firstOccurrence(nums, target);
        int second = lastOccurrence(nums, target);
        int[] finalAns = {first, second}; 
        return finalAns;

    }

        private int firstOccurrence(int[] nums, int target){
            int start = 0;
            int end = nums.length -1;
            int ans = -1;

            while(start<=end){
                int mid = start + (end-start)/2;

                if(target==nums[mid]){
                    ans = mid;
                    end = mid-1;
                }
                else if(target<nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            return ans;
        }

        private int lastOccurrence(int[] nums, int target){
            int start = 0;
            int end = nums.length - 1;
            int ans = -1;

            while(start<=end){
                int mid = start + (end-start)/2;

                if(target==nums[mid]){
                    ans = mid;
                    start = mid+1;
                }
                else if(target<nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            return ans;
        }

    
}