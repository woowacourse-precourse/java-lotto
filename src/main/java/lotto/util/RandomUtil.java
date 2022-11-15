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
        // Collections.sort(lottoNumbers);
        RandomLottoNumber randomLottoNumber = new RandomLottoNumber(lottoNumbers);
        return randomLottoNumber;
    }
}
