from typing import List

class Lab8Python:
    @staticmethod
    def main():
        testArray = [1, 2, 5]
        print(Lab8Python.coinChange(testArray, 11))

        testArray2 = [2]
        print(Lab8Python.coinChange(testArray2, 3))

        testArray3 = [1]
        print(Lab8Python.coinChange(testArray3, 0))

    @staticmethod
    def coinChange(coins: List[int], amount: int) -> int:
        coinArray = [amount + 1] * (amount + 1)
        coinArray[0] = 0
        for i in range(1, amount + 1):
            for coin in coins:
                if coin <= i:
                    coinArray[i] = min(coinArray[i], coinArray[i - coin] + 1)
        if coinArray[amount] > amount:
            return -1
        return coinArray[amount]

# To run the code
Lab8Python.main()
