package shubham.edu.dsalgo.leet.code.practice;

public class Tester {
    public static void main(String[] args) {
        int nums[] = {2,1,2,3,4,1,4};
        for(int i=1;i<nums.length;i++) {
            System.out.println(nums[0] ^ nums[i]);
            nums[0] = nums[0] ^ nums[i];
        }
        System.out.println(nums[0]);
    }
}
