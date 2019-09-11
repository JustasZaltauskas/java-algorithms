package Algorithms.Array.Greedy;

// https://leetcode.com/problems/lemonade-change/
public class LemonadeChange {
    // Works with n amount of money
    public boolean find(int[] bills) {
        int price = 5;
        int[] money = new int[]{5, 10, 20};
        int[] count = new int[money.length];

        for (int bill : bills) {
            for (int i = 0; i < money.length; i++) {
                if (money[i] == bill) {
                    count[i]++;
                    break;
                }
            }

            bill -= price;

            for (int i = money.length - 1; i >= 0; i--) {
                while (bill >= money[i] && count[i] > 0) {
                    bill -= money[i];
                    count[i]--;
                }
            }

            if (bill > 0) return false;
        }

        return true;
    }
}
