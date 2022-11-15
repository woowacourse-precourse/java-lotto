package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.EnumCreate.RangeNumber;

public class LottoNumberGenerator {

    private static final int MONEY_UNIT = 1000; // 1000원
    private static final int LOTTO_NUMBER_AMOUNT = 6;
    private static final int ZERO = 0;
    private int startNumber = RangeNumber.RANGE_START.getRangeNumber();
    private int endNumber = RangeNumber.RANGE_END.getRangeNumber();
    private List<List<Integer>> returnList = new ArrayList<>();


    public List<List<Integer>> generateLottoNumber(int inputMoney) {

        int lottoAmount = inputMoney / MONEY_UNIT;

        for (int i = ZERO; i < lottoAmount; i++) {
            List<Integer> randomLottoNumber = new ArrayList<>();
            List<Integer> lottoGeneration = pickUniqueNumbersInRange(startNumber, endNumber, LOTTO_NUMBER_AMOUNT);
            randomLottoNumber.addAll(lottoGeneration);
            Collections.sort(randomLottoNumber);
            returnList.add(randomLottoNumber);
        }
        return returnList;
    }
}
