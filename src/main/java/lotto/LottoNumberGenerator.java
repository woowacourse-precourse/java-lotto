package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int generateBonusNumber(List<Integer> numbers) {
        int bonusNumber = 0;
        while (bonusNumber == 0) {
            int candidate = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(candidate)) {
                bonusNumber = candidate;
            }
        }
        return bonusNumber;
    }
}
