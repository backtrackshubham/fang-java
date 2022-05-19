package shubham.edu.dsalgo.leet.code.practice;

class TwoSum {

    public static void main(String[] args) {

    }
}

class Helper {
    public int[] twoSum(int[] nums, int target) {
        int[] toRet = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    if (nums[i] + nums[j] == target) {
                        toRet[1] = j;
                        toRet[0] = i;
                    }
                }
            }
        }
        return toRet;
    }
}