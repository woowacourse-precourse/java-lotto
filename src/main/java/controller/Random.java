package controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Random {
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers;
    }

    public static List<List<Integer>> getLottoNumber(int purchaseQuantity) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoNumbers.add(getRandomNumber());
        }
        return lottoNumbers;
    }
}
