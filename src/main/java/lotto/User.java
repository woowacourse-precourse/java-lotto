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

    User(int inputCost) {
        valid(inputCost);
        this.inputCost = inputCost;
    }

    private void valid(int inputCost) {
        if (inputCost / 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액이 1000의 배수가 아닙니다.");
        }
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