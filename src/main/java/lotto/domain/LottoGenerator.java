package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    int generateCount;
    public LottoGenerator(int money) {
        try {
            if (checkMoneyUnit(money)) {
                generateCount = money / 1000;
            }
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getGenerateCount() {
        return generateCount;
    }

    private Boolean checkMoneyUnit(int money) throws IllegalArgumentException {
        if ((money % 1000) != 0 || money <= 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public List<Integer> createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
