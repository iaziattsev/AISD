package TwoSum;

import java.util.Arrays;

import static TwoSum.Solution.twoSum;

public class Main {
    public static void main(String[] args) {
        int[] array;
        array = new int[]{5,6,7,1,2,3,4,10,12,100};
        System.out.println(Arrays.toString(twoSum(array,16)));
    }
}
