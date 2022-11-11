package lotto.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    static final int LENGTH_OF_LOTTO_NUMBERS = 6;

    public static List<List<Integer>> getLottoNumbers(int money){
        int countFromMoney = getCountFromMoney(money);
        return createLottoNumberList(countFromMoney);
    }

    private static int getCountFromMoney(int money) {
        int countFromMoney = money / 1000;
        return countFromMoney;
    }

    private static List<List<Integer>> createLottoNumberList(int countFromMoney) {
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        for (int i=0; i<countFromMoney; i++) {
            List<Integer> lottoNumbers = createLottoNumbers();
            lottoNumberList.add(lottoNumbers);
        }
        return lottoNumberList;
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        while (!validateLottoNumbers(lottoNumbers)) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        return lottoNumbers;
    }

    private static boolean validateLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        for (int i=0; i<LENGTH_OF_LOTTO_NUMBERS; i++) {
            if (isDuplicate(lottoNumbers, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate(List<Integer> lottoNumbers, int index) {
        Integer eachNumber = lottoNumbers.get(index);
        List<Integer> restOfListValues = lottoNumbers.subList(index, LENGTH_OF_LOTTO_NUMBERS);
        if (restOfListValues.contains(eachNumber)) {
            return false;
        }
        return true;
    }
}
