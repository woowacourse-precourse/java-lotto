package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;
    
    public static List<Lotto> lotto(String userInput) {
        int numberOfLotto = getNumberOfLotto(userInput);
        return getLotto(numberOfLotto);
    }

    private static int getNumberOfLotto(String userInput) throws IllegalArgumentException {
        int amount;
        Validation.existOnlyNumber(userInput);
        amount = Integer.parseInt(userInput);

        Validation.isValidUnit(amount);
        return amount / LOTTO_PRICE;
    }

    private static List<Lotto> getLotto(int numberOfLotto) {
        List<Lotto> lottery = new ArrayList<>(numberOfLotto);

        for (int index = 0; index < numberOfLotto; index++) {
            Lotto lotto = new Lotto(pickLottoNumber());
            lottery.add(lotto);
        }

        return lottery;
    }

    private static List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
