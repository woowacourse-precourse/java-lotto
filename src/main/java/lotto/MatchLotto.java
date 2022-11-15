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


    }


}




