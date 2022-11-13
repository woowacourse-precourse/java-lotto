package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.ui.Error;
import camp.nextstep.edu.missionutils.Randoms;

public class Manager {


    public List<Integer> sumUpResult(List<Integer> result) {
        List<Integer> sumOfResult = new ArrayList<>();
        for (int i = 3; i <= 6; i++) {
            sumOfResult.add(Collections.frequency(result, i));
            if (i == 5) {
                sumOfResult.add(Collections.frequency(result, 15));
            }
        }
        return sumOfResult;
    }

    public float getRateOfReturn(List<Integer> sumOfResult) {
        float sum = 0;
        int[] prizeMoney = {5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};
        for (int i = 0; i < sumOfResult.size(); i++) {
            sum += sumOfResult.get(i) * prizeMoney[i];
        }
        return sum / (8 * Lotto.PRICE) * 100;
    }
}


