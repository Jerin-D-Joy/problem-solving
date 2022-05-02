package learn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class KnapsackProblemTest {

    @Test
    public void maximiseProfitsTest() {
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        int[] weights = { 3, 4, 6, 5 };
        int[] profits = { 2, 3, 1, 4 };
        int[] profitsTillNow =  new int[]{0,0,0, 0};
        int maxProfit = knapsackProblem.maximiseProfits(weights, profits, 8, 0, profitsTillNow);
        Arrays.stream(profitsTillNow).forEach(value -> System.out.println(value));
        Assert.assertEquals(6, maxProfit);
    }
}
