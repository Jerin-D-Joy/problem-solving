package learn;


//Given an array of numbers representing money, find maximum amount that can be robbed without choosing adjacent houses
public class HouseRobber {

    public int robHouse(int[] moneyInHouses, int robberIndex, int[] results) {
        if(robberIndex >= moneyInHouses.length)
            return 0;

        int rob = moneyInHouses[robberIndex] + robHouse(moneyInHouses, robberIndex + 2, results);
        int noRob = robHouse(moneyInHouses, robberIndex + 1, results);
        results[robberIndex] = Math.max(rob, noRob);
        return results[robberIndex];
    }

    public int maximiseAmountRobbingMoneyInHouses(int[] moneyInHouses) {
       int[] results = new int[moneyInHouses.length];
       return robHouse(moneyInHouses, 0, results);
    }
}
