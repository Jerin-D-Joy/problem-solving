package learn;

//Find max profit such that weight of all items <= capacity
public class KnapsackProblem {

    int[] weights = { 3, 4, 6, 5 };
    int[] profits = { 2, 3, 1, 4 };
    public int maximiseProfits(int[] weights, int[] profits, int capacity, int currentIndex, int[] profitsTillNow) {
        if(currentIndex >= weights.length) return 0;
        if(weights[currentIndex] > capacity) return  0;
        int select = profits[currentIndex]
                + maximiseProfits(weights, profits, capacity - weights[currentIndex], currentIndex + 1,
                profitsTillNow);
        int noSelect = maximiseProfits(weights, profits, capacity, currentIndex + 1, profitsTillNow);
        profitsTillNow[currentIndex] = Math.max(select, noSelect);
        System.out.println(currentIndex + " : " + profitsTillNow[currentIndex]);
        return profitsTillNow[currentIndex];
    }
}
