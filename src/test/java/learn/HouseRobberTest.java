package learn;

import org.junit.Assert;
import org.junit.Test;

public class HouseRobberTest {

    @Test
    public void robHousesTest() {
        HouseRobber houseRobber = new HouseRobber();
        Assert.assertEquals(12, houseRobber.maximiseAmountRobbingMoneyInHouses(new int[]{2, 7, 9, 3, 1}));
        Assert.assertEquals(207, houseRobber.maximiseAmountRobbingMoneyInHouses(new int[]{7, 7, 100, 99, 1, 100}));
    }
}
