class Solution {
    public:
    vector<int> searchRange (vector<int>& nums, int target) {
        int n = nums.size();
        if (n==0) return {-1, -1};
        int lo = 0 , hi = n - 1 , mid=-1;
        while (lo <= hi) {
            mid  = (lo + hi) / 2;
            if (nums[mid] == target) {
                break;
                } else if (nums [mid]>target) {
                    hi=mid-1;
                    } 
                    else {
                        lo = mid + 1;
                        }
                    }
                    if (nums [mid]!=target)
                    return {-1, -1}; 
                    int start=mid, end=mid;
                    while(start>=0 && nums [start] == target)
                    start--;
                    while (end<n && nums [end]==target)
                    end++;
                    return {start+1, end-1}; 
    }
};