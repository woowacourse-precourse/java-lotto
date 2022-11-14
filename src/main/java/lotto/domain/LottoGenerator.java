package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.NoSuchElementException;

public class LottoGenerator {
    int generateCount;
    public LottoGenerator(int money) {
        checkMoneyUnit(money);
        generateCount = money / 1000;
    }
    public LottoGenerator(String input) {
        char check;
            for (int i = 0; i < input.length(); i++) {
                check = input.charAt(i);

                if (check < 48 || check > 58) {
                    System.err.println("[ERROR]");
                    throw new NoSuchElementException("[ERROR]");
                }
            }
        int money = Integer.parseInt(input);
        checkMoneyUnit(money);
        generateCount = money / 1000;
    }


    public int getGenerateCount() {
        return generateCount;
    }

    private void checkMoneyUnit(int money) {
        if ((money % 1000) != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public List<Integer> createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
