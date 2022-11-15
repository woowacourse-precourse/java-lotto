package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.EnumCreate.RangeNumber;

public class LottoNumberGenerator {

    RangeNumber startRange = RangeNumber.RANGE_START;
    int startNumber = startRange.getRangeNumber();

    RangeNumber endRange = RangeNumber.RANGE_END;
    int endNumber = endRange.getRangeNumber();

    private static final int MONEY_UNIT = 1000; // 1000원
    private static final int LOTTO_NUMBER_AMOUNT = 6;

    private List<List<Integer>> returnList = new ArrayList<>();


    public List<List<Integer>> generateLottoNumber(int inputMoney) {

        int lottoAmount = inputMoney / MONEY_UNIT;

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> randomLottoNumber = new ArrayList<>();
            List<Integer> lottoGeneration = pickUniqueNumbersInRange(startNumber, endNumber, LOTTO_NUMBER_AMOUNT);
            randomLottoNumber.addAll(lottoGeneration);
            Collections.sort(randomLottoNumber);
            returnList.add(randomLottoNumber);
        }
        return returnList;
    }
}
