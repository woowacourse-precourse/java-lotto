package lotto.view;

import static lotto.view.util.InputUtil.*;

import java.util.List;
import lotto.domain.Lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static Integer inputMoney() {
        return validateInputMoney(getInput());
    }

    public static Lotto inputLottoWinNumber() {
        final List<String> lottoWinNumber = stringToList(getInput());

        return validateLottoWinNumber(lottoWinNumber);
    }

    private static Integer validateInputMoney(String inputMoney) {
        if (!inputMoney.matches("^[0-9]+000$")) {
            throw new IllegalArgumentException();
        }

        return stringToInteger(inputMoney);
    }

    private static Lotto validateLottoWinNumber(List<String> inputLottoWinNumber) {
        if (!inputLottoWinNumber.stream().allMatch(n -> n.matches("^[0-9]+$"))) {
            throw new IllegalArgumentException();
        }

        if (inputLottoWinNumber.size() != inputLottoWinNumber.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }

        final List<Integer> lottoWinNumber = stringListToIntegerList(inputLottoWinNumber);

        if (!lottoWinNumber.stream().allMatch(n -> (n >= 1 && n <= 45))) {
            throw new IllegalArgumentException();
        }

        return new Lotto(lottoWinNumber);
    }

    private static String getInput() {
        try {
            return Console.readLine();
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }
}
