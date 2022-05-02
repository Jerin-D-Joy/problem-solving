package learn;

import org.junit.Assert;
import org.junit.Test;

public class ClimbStairWaysTest {

    @Test
    public void numberOfWaysToClimbNStairsRecursionTest() {
        ClimbStairsWays climbStairsWays = new ClimbStairsWays();
        Assert.assertEquals(1, climbStairsWays.numberOfWaysToClimbNStairsRecursion(1));
        Assert.assertEquals(2, climbStairsWays.numberOfWaysToClimbNStairsRecursion(2));
        Assert.assertEquals(3, climbStairsWays.numberOfWaysToClimbNStairsRecursion(3));
        Assert.assertEquals(5, climbStairsWays.numberOfWaysToClimbNStairsRecursion(4));
    }

    @Test
    public void numberOfWaysToClimbNStairsTabulationTest() {
        ClimbStairsWays climbStairsWays = new ClimbStairsWays();
        Assert.assertEquals(1, climbStairsWays.numberOfWaysToClimbNStairsTabulation(1));
        Assert.assertEquals(2, climbStairsWays.numberOfWaysToClimbNStairsTabulation(2));
        Assert.assertEquals(3, climbStairsWays.numberOfWaysToClimbNStairsTabulation(3));
        Assert.assertEquals(5, climbStairsWays.numberOfWaysToClimbNStairsTabulation(4));
    }

    @Test
    public void recursionAndTabulationResultsConsistencyTest() {
        ClimbStairsWays climbStairsWays = new ClimbStairsWays();
        Assert.assertEquals(climbStairsWays.numberOfWaysToClimbNStairsRecursion(1), climbStairsWays.numberOfWaysToClimbNStairsTabulation(1));
        System.out.println(climbStairsWays.numberOfWaysToClimbNStairsRecursion(100 ));
       // Assert.assertEquals(climbStairsWays.numberOfWaysToClimbNStairsRecursion(100), climbStairsWays.numberOfWaysToClimbNStairsTabulation(100 ));
    }
}
