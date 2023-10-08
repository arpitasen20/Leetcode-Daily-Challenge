public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][][] memo = new Integer[501][501][2];
        return dfs(nums1, nums2, 0, 0, 0, memo);
    }
    private int dfs(int[] nums1, int[] nums2, int i, int j, int atLeastOnePair, Integer[][][] memo){
        if(i == nums1.length || j == nums2.length){
            if(atLeastOnePair == 1) {
                return 0;
            }else {
                return Integer.MIN_VALUE;
            }
        }
        if(memo[i][j][atLeastOnePair] != null){
            return memo[i][j][atLeastOnePair];
        }
        int result = Integer.MIN_VALUE;

        int take = nums1[i] * nums2[j] + dfs(nums1, nums2, i + 1, j + 1, 1, memo);
        int skipI = dfs(nums1, nums2, i + 1, j, atLeastOnePair, memo);
        int skipJ = dfs(nums1, nums2, i, j + 1, atLeastOnePair, memo);

        result = Math.max(take, Math.max(skipI, skipJ));
        memo[i][j][atLeastOnePair] = result;

        return result;
    }
}