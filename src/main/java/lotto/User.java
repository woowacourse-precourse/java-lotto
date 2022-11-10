package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    public int inputCost;
    public List<List<Integer>> purchaseLottoList;
    private int[] winningArray;
    private int getProfit;
    private float earningsRate;

    User(int inputConst) {
        this.inputCost = inputConst;
    }
    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void getPurchaseLottoList() {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < inputCost/1000; i++) {
            result.add(getLottoNumbers());
        }
        this.purchaseLottoList = result;
    }
}