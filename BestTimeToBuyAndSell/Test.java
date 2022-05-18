package BestTimeToBuyAndSell;

import java.util.Arrays;

import static BestTimeToBuyAndSell.Solution.maxProfit;

public class Test{
    public static void main(String[] args) {
        int[] array;
        array = new int[]{5,6,7,1,2,3,4,10,12,100};
        System.out.println(maxProfit(array));
    }
}
