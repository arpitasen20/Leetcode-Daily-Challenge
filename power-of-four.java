class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }
        int indexCounter = 0;
        boolean metOne = false;
        while (n > 0) {
            int rightmostBit = n & 1;
            if (indexCounter % 2 == 0 && !metOne && rightmostBit == 1) {
                metOne = true;
            } else if (indexCounter % 2 == 0 && metOne && rightmostBit == 1) {
                return false;
            } else if (indexCounter % 2 == 1 && rightmostBit == 1) {
                return false;
            }
            n >>= 1;
            indexCounter++;
        }

        return true;
    }
}