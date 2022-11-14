package lotto.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.RandomLottoNumber;
import lotto.view.InputView;

public class RandomUtil {

    static final int LENGTH_OF_LOTTO_NUMBERS = 6;

    public static List<RandomLottoNumber> getLottoNumbers(String purchaseAmountInput){
        int countFromMoney = getCountFromMoney(purchaseAmountInput);
        return createLottoNumberList(countFromMoney);
    }

    public static int getCountFromMoney(String purchaseAmountInput) {
        ParserUtil.parsePurchaseAmountInput(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        int countFromMoney = purchaseAmount / 1000;
        return countFromMoney;
    }

    public static List<RandomLottoNumber> createLottoNumberList(int countFromMoney) {
        List<RandomLottoNumber> lottoNumberList = new ArrayList<>();
        for (int i=0; i<countFromMoney; i++) {
            RandomLottoNumber randomLottoNumber = createLottoNumbers();
            lottoNumberList.add(randomLottoNumber);
        }
        return lottoNumberList;
    }

    private static RandomLottoNumber createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        while (!validateLottoNumbers(lottoNumbers)) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        RandomLottoNumber randomLottoNumber = new RandomLottoNumber(lottoNumbers);
        return randomLottoNumber;
    }

    private static boolean validateLottoNumbers(List<Integer> lottoNumbers) {
        // Collections.sort(lottoNumbers);
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
