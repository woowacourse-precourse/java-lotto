package lotto.util;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.RandomLottoNumber;

public class RandomUtil {

    final static int MIN_UNIT_OF_AMOUNT = 1000;

    public static int getCountFromMoney(String purchaseAmountInput) {
        ParserUtil.parsePurchaseAmountInput(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        int countFromMoney = purchaseAmount / MIN_UNIT_OF_AMOUNT;
        return countFromMoney;
    }

    public static List<RandomLottoNumber> createLottoNumberList(int countFromMoney) {
        List<RandomLottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 0; i < countFromMoney; i++) {
            RandomLottoNumber randomLottoNumber = createLottoNumbers();
            lottoNumberList.add(randomLottoNumber);
        }
        return lottoNumberList;
    }

    private static RandomLottoNumber createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        RandomLottoNumber randomLottoNumber = new RandomLottoNumber(lottoNumbers);
        return randomLottoNumber;
    }
}
