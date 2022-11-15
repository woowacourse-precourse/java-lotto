package lotto.view;

import static lotto.view.util.InputUtil.*;

import java.util.List;
import lotto.domain.Lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_LOTTO_NOT_NUMBER = "숫자만 입력할 수 있습니다.";
    private static final String ERROR_INPUT_MONEY = "로또 구입 금액은 1000원 단위의 숫자여야 합니다.";
    private static final String ERROR_NULL_INPUT = "값을 입력해야 합니다.";

    public static Integer inputMoney() {
        System.out.println(INPUT_MONEY);
        return validateInputMoney(getInput());
    }

    public static Lotto inputLottoWinNumber() {
        System.out.println(INPUT_LOTTO_WIN_NUMBER);
        final List<String> lottoWinNumber = stringToList(getInput());

        return validateLottoWinNumber(lottoWinNumber);
    }

    public static Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return validateBonusNumber(getInput());
    }

    private static Integer validateBonusNumber(String inputBonusNumber) {
        if (!inputBonusNumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ERROR_LOTTO_NOT_NUMBER);
        }

        return stringToInteger(inputBonusNumber);
    }

    private static Integer validateInputMoney(String inputMoney) {
        if (!inputMoney.matches("^[0-9]+000$")) {
            throw new IllegalArgumentException(ERROR_INPUT_MONEY);
        }

        return stringToInteger(inputMoney);
    }

    private static Lotto validateLottoWinNumber(List<String> inputLottoWinNumber) {
        if (!inputLottoWinNumber.stream().allMatch(n -> n.matches("^[0-9]+$"))) {
            throw new IllegalArgumentException(ERROR_LOTTO_NOT_NUMBER);
        }

        return new Lotto(stringListToIntegerList(inputLottoWinNumber));
    }

    private static String getInput() {
        try {
            return Console.readLine();
        } catch (Exception exception) {
            throw new IllegalArgumentException(ERROR_NULL_INPUT);
        }
    }
}
