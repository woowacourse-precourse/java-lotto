package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    public static List<Lotto> lotto() {
        String userInput = Console.readLine();

        int numberOfLotto = getNumberOfLotto(userInput);
        return getLotto(numberOfLotto);
    }

    private static int getNumberOfLotto(String userInput) {
        if (!Validation.existOnlyNumber(userInput)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.CANNOT_CONVERT_NUMBER);
        }

        int amount = Integer.parseInt(userInput);
        if (!Validation.isValidRange(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.LOTTO_OUT_OF_RANGE);
        }
        if (!Validation.isValidUnit(amount)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.INVALID_AMOUNT_UNIT);
        }

        return amount / 1000;
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
