package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static final int MONEY_UNIT = 1000; // 1000원
    private List<List<Integer>> returnList = new ArrayList<>();


    public List<List<Integer>> generateLottoNumber(int inputMoney) {

        int lottoAmount = inputMoney / MONEY_UNIT;

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> randomLottoNumber = new ArrayList<>();
            List<Integer> lottoGeneration = pickUniqueNumbersInRange(1, 45, 6);
            randomLottoNumber.addAll(lottoGeneration);

            Collections.sort(randomLottoNumber);
            returnList.add(randomLottoNumber);
        }

        return returnList;
    }


}
