package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.Constant;

public class LottoGenerator {

    public static int generateBonusNumber() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER, Constant.BONUS_NUMBER_SIZE);

        return randomNumber.get(0); // TODO: get(0) 안했을 때 왜 size 6이 리턴되는지?
    }

    public static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER, Constant.LOTTO_SIZE)
        );

        Collections.sort(numbers);

        return numbers;
    }
}
