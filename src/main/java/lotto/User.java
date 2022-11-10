package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int InputCost;
    private List<List<Integer>> purchaseLottoList;
    private int[] WinningArray;
    private int getProfit;
    private float EarningsRate;

    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<List<Integer>> getPurchaseLottoList(int purchaseNumber) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            result.add(getLottoNumbers());
        }
        return result;
    }
}