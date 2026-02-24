/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);

        int left = ascArr(target,mountainArr,0,peak);
        if(left != -1){
            return left;
        }
       
        return decArr(target, mountainArr, peak + 1, mountainArr.length()-1);
        
    }
    static int findPeak(MountainArray arr){
        int start = 0;
        int end = arr.length() - 1;

        while(start<end){
            int mid = start + (end-start)/2;

            if(arr.get(mid)>arr.get(mid+1)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
    

    static int ascArr(int target, MountainArray arr, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(target==arr.get(mid)){
                return mid;
            }
            else if(target<arr.get(mid)){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
    return -1;
    }

    static int decArr(int target, MountainArray arr, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(target==arr.get(mid)){
                return mid;
            }
            else if(target>arr.get(mid)){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
    return -1;
    }

}