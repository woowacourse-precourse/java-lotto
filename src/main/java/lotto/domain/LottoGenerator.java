package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    int generateCount;
    public LottoGenerator(int money) {
        checkMoneyUnit(money);
        generateCount = money / 1000;
    }

    public int getGenerateCount() {
        return generateCount;
    }

    private void checkMoneyUnit(int money) {
        if ((money % 1000) != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR]: OUT OF UNIT!");
        }
    }

    public List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
