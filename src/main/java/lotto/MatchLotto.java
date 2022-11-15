package lotto;

import java.text.DecimalFormat;
import java.util.List;


public class MatchLotto {
    private static List<List<Integer>> Lotto_Random_arr;
    private static List<Integer> numbers;
    private static int bonusNum;

    private static int sum;
    private static int[] countMatch = {0, 0, 0, 0, 0};

    public MatchLotto(List<List<Integer>> Lotto_Random_arr, List<Integer> numbers, int bonusNum) {
        this.Lotto_Random_arr = Lotto_Random_arr;
        this.numbers = numbers;
        this.bonusNum = bonusNum;
        Matching();
        showStatistics();

    }

    private static void Matching() {
        for (List<Integer> Lotto_Random_one : Lotto_Random_arr) {
            int count = countNumber(Lotto_Random_one);
            boolean bonus = containBonus(Lotto_Random_one);

            if (count >= 3) {
                MatchMoney matchMoney = insertMoney(Lotto_Random_one, count, bonus);
            }
        }
    }

    private static MatchMoney insertMoney(List<Integer> Lotto_Random_one, int count, boolean bonus) {
        MatchMoney matchMoney = MatchMoney.Matching(count);
        if (count == 5) {
            matchMoney = matchMoney.countFive(bonus);
        }
        countMatch[matchMoney.ordinal()] += 1;
        return matchMoney;
    }

}




