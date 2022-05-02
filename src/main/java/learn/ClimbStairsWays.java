package learn;

//Find no of ways in which a given number of steps can be climbed where you can take either a single step of 1 or 2.
public class ClimbStairsWays {

    //Memoization - top down
    public long numberOfWaysToClimbNStairsRecursion(int n) {
        if(n == 2 || n == 1) return n;
        if(n < 0) return 0;
        return numberOfWaysToClimbNStairsRecursion(n - 2) + numberOfWaysToClimbNStairsRecursion(n - 1);
    }

    public long numberOfWaysToClimbNStairsTabulation(int n) {
        long[] waysArray = new long[n + 1];
        if(n < 3) return n;
        waysArray[0] = 0;
        waysArray[1] = 1;
        waysArray[2] = 2;
        for(int i = 3; i <=n; i++) {
            waysArray[i] = waysArray[i - 1] + waysArray[i - 2];
        }
        return waysArray[n];
    }
}
