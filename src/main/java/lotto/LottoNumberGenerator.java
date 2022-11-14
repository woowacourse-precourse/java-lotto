package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {

    private static int START_LOTTO_NUMBER = 1;
    private static int END_LOTTO_NUMBER = 45;
    private static int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
    }

    public int generateBonusNumber(List<Integer> numbers) {
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            int candidate = (int) (Math.random() * END_LOTTO_NUMBER) + 1;
            if (!numbers.contains(candidate)) {
                bonusNumber = candidate;
            }
        }
        return bonusNumber;
    }
}
