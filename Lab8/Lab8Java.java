public class Lab8Java {
    public static void main(String[] args) {
        int[] testArray = {1,2,5};
        System.out.println(coinChange(testArray, 11));

        int[] testArray2 = {2};
        System.out.println(coinChange(testArray2, 3));

        int[] testArray3 = {1};
        System.out.println(coinChange(testArray3, 0));
    }
    public static int coinChange(int[] coins, int amount) {
        int [] coinArray = new int[amount +1];
        for (int i = 1; i<=amount; i++) {
            coinArray[i] = amount+1;
        }
        coinArray [0]= 0;
        for (int i = 1; i<=amount; i++) {
            for (int coin:coins){
                if (coin <= i){
                    coinArray [i] = Math.min( coinArray[i], coinArray [i-coin]+1);
                }
            }
        }
        if (coinArray [amount] > amount){
            return -1;
        }
        return coinArray[amount];
    }
}
